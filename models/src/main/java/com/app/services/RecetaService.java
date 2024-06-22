package com.app.services;

import com.app.dao.implementations.MateriaPrimaDao;
import com.app.dao.interfaces.IInsumoDao;
import com.app.dao.interfaces.IMateriaPrimaDao;
import com.app.dao.interfaces.IRecetaDao;
import com.app.dao.interfaces.IUsuarioDao;
import com.app.models.*;
import com.app.services.interfaces.IRecetaService;
import com.app.services.interfaces.IUsuarioService;
import com.app.utils.ListUtils;
import com.app.viewModels.*;
import jakarta.inject.Inject;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            IngredienteReceta ingrediente = null;
            if (ing.getInsumoId() != null) {
                Insumo insumo = insumoDao.getById(ing.getInsumoId());
                ingrediente = new IngredienteReceta(ing.getCantidad(), insumo, receta);
                receta.addIngrediente(ingrediente);
            } else if (ing.getMateriaPrimaId() != null) {
                MateriaPrima materiaPrima = materiaPrimaDao.getById(ing.getMateriaPrimaId());
                ingrediente = new IngredienteReceta(ing.getCantidad(), materiaPrima, receta);
                receta.addIngrediente(ingrediente);
            }
        }

        recetaDao.save(receta);
        return mappingService.toDetalleViewModel(receta);
    }

    @Override
    public RecetaDetalleViewModel update(Long recetaId, RecetaCreateViewModel view) {
        Receta receta = recetaDao.getById(recetaId);
        if (view.getDescripcion() != null) receta.setDescripcion(view.getDescripcion());
        if (view.getNombre() != null) receta.setNombre(view.getNombre());
        return mappingService.toDetalleViewModel(receta);
    }

}
