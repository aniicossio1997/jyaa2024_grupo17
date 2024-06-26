package com.app.services;

import com.app.dao.interfaces.*;
import com.app.exceptions.InvalidParameterException;
import com.app.models.*;
import com.app.services.interfaces.IIngredienteRecetaService;
import com.app.services.interfaces.IRecetaService;
import com.app.utils.ListUtils;
import com.app.viewModels.*;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@PerLookup
public class IngredienteRecetaService implements IIngredienteRecetaService {

    @Inject
    private IRecetaDao recetaDao;

    @Inject
    private IInsumoDao insumoDao;

    @Inject
    private IIngredienteRecetaDao ingredienteRecetaDao;

    @Inject
    private IMateriaPrimaDao materiaPrimaDao;

    @Inject
    private MappingService mappingService;


    @Override
    public List<IngredienteRecetaViewModel> getAllByReceta(Long recetaId) {
        return ListUtils.mapList(ingredienteRecetaDao.getByRecetaId(recetaId), mappingService::toViewModel);
    }

    @Override
    public IngredienteRecetaViewModel getById(Long id) {
        IngredienteReceta ingredienteReceta = ingredienteRecetaDao.getById(id);
        if (ingredienteReceta == null) throw new NotFoundException("ingrediente_not_found");
        return mappingService.toViewModel(ingredienteReceta);
    }

    @Override
    public IngredienteRecetaViewModel create(IngredienteRecetaCreateViewModel view) {
        Receta receta = recetaDao.getById(view.getRecetaId());
        IngredienteReceta ingrediente;
        if (view.getInsumoId() == null && view.getMateriaPrimaId() == null) {
            return null;
        }
        if (view.getInsumoId() != null) {
            Insumo insumo = insumoDao.getById(view.getInsumoId());
            ingrediente = new IngredienteReceta(view.getCantidad(), insumo, receta);
        } else {
            MateriaPrima materiaPrima = materiaPrimaDao.getById(view.getMateriaPrimaId());
            ingrediente = new IngredienteReceta(view.getCantidad(), materiaPrima, receta);
        }
        this.ingredienteRecetaDao.save(ingrediente);
        return mappingService.toViewModel(ingrediente);
    }

    @Override
    public IngredienteRecetaViewModel update(Long id, IngredienteRecetaCreateViewModel view) {
        IngredienteReceta ingrediente = ingredienteRecetaDao.getById(id);

        if (view.getRecetaId() != null) {
            Receta receta = recetaDao.getById(view.getRecetaId());
            ingrediente.setReceta(receta);
        }

        if (view.getCantidad() != null) ingrediente.setCantidad(view.getCantidad());


        if (view.getInsumoId() != null || view.getMateriaPrimaId() != null) {
            if (view.getInsumoId() != null) {
                Insumo insumo = insumoDao.getById(view.getInsumoId());
                ingrediente.setInsumo(insumo);
            } else {
                MateriaPrima materiaPrima = materiaPrimaDao.getById(view.getMateriaPrimaId());
                ingrediente.setMateriaPrima(materiaPrima);
            }
        }

        this.ingredienteRecetaDao.save(ingrediente);
        return mappingService.toViewModel(ingrediente);
    }

    @Override
    public boolean delete(Long id) {
        IngredienteReceta ingrediente = ingredienteRecetaDao.getById(id);
        ingrediente.setFechaBaja(new Date());
        ingredienteRecetaDao.save(ingrediente);
        return true;
    }
}
