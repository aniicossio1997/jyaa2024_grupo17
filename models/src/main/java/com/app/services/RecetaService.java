package com.app.services;

import com.app.dao.interfaces.IInsumoDao;
import com.app.dao.interfaces.IMateriaPrimaDao;
import com.app.dao.interfaces.IRecetaDao;
import com.app.dao.interfaces.IUsuarioDao;
import com.app.models.*;
import com.app.services.interfaces.IRecetaService;
import com.app.utils.ListUtils;
import com.app.viewModels.*;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;

import java.util.*;

@Service
@PerLookup
public class RecetaService implements IRecetaService {

    @Inject
    private IUsuarioDao usuarioDao;

    @Inject
    private IRecetaDao recetaDao;

    @Inject
    private IInsumoDao insumoDao;

    @Inject
    private IMateriaPrimaDao materiaPrimaDao;

    @Inject
    private MappingService mappingService;

    @Override
    public List<RecetaViewModel> getAll() {
        return ListUtils.mapList(recetaDao.getAll(), mappingService::toViewModel);
    }


    @Override
    public RecetaDetalleViewModel getById(Long recetaId) {
        return mappingService.toDetalleViewModel(recetaDao.getById(recetaId));
    }

    @Override
    public RecetaDetalleViewModel create(RecetaCreateViewModel view) {
        Usuario autor = usuarioDao.getById(1L); // Por ahora hardcodeado
        Receta receta = new Receta(view.getNombre(), view.getDescripcion(), new ArrayList<>(), autor);

        // Ingredientes
        for (IngredienteRecetaCreateViewModel ing : view.getIngredientes()) {
            IngredienteReceta ingrediente = buildIngrediente(ing, receta);
            receta.addIngrediente(ingrediente);
        }
        recetaDao.save(receta);
        return mappingService.toDetalleViewModel(receta);
    }

    @Override
    public boolean delete(Long id) {
        Receta receta = recetaDao.getById(id);
        receta.setFechaBaja(new Date());
        recetaDao.save(receta);
        return true;
    }

    @Override
    public RecetaDetalleViewModel update(Long recetaId, RecetaCreateViewModel view) {
        Receta receta = recetaDao.getById(recetaId);
        if (view.getDescripcion() != null) receta.setDescripcion(view.getDescripcion());
        if (view.getNombre() != null) receta.setNombre(view.getNombre());

        for (IngredienteRecetaCreateViewModel ing : view.getIngredientes()) {
            if (ing.getInsumoId() == null) { // Se agrega un nuevo ingrediente
                IngredienteReceta ingrediente = buildIngrediente(ing, receta);
                receta.addIngrediente(ingrediente);
            } else { // Se modifica uno existente
                updateIngrediente(ing, receta);
            }
        }
        recetaDao.save(receta);
        return mappingService.toDetalleViewModel(receta);
    }

    private IngredienteReceta buildIngrediente(IngredienteRecetaCreateViewModel ing, Receta receta) {
        IngredienteReceta ingrediente = null;
        if (ing.getInsumoId() != null) {
            Insumo insumo = insumoDao.getById(ing.getInsumoId());
            if (insumo == null) throw new NotFoundException("insumo_not_found");
            ingrediente = new IngredienteReceta(ing.getCantidad(), insumo, receta);
        } else if (ing.getMateriaPrimaId() != null) {
            MateriaPrima materiaPrima = materiaPrimaDao.getById(ing.getMateriaPrimaId());
            if (materiaPrima == null) throw new NotFoundException("materia_prima_not_found");
            ingrediente = new IngredienteReceta(ing.getCantidad(), materiaPrima, receta);
        }
        return ingrediente;
    }

    private void updateIngrediente(IngredienteRecetaCreateViewModel ing, Receta receta) {
        Optional<IngredienteReceta> optIngrediente = receta.ingredientes.stream().filter(i -> Objects.equals(i.getId(), ing.getId())).findFirst();
        if (optIngrediente.isEmpty()) throw new NotFoundException("missing_ingredient");
        IngredienteReceta ingrediente = optIngrediente.get();
        if (ing.getCantidad() != null) ingrediente.setCantidad(ing.getCantidad());
        if (ing.getInsumoId() != null) {
            Insumo insumo = insumoDao.getById(ing.getInsumoId());
            if (insumo == null) throw new NotFoundException("insumo_not_found");
            ingrediente.setInsumo(insumo);
        }
        if (ing.getMateriaPrimaId() != null) {
            MateriaPrima materiaPrima = materiaPrimaDao.getById(ing.getMateriaPrimaId());
            if (materiaPrima == null) throw new NotFoundException("materia_prima_not_found");
            ingrediente.setMateriaPrima(materiaPrima);
        }
    }

}
