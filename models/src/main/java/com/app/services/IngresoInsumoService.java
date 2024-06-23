package com.app.services;

import com.app.dao.FactoryDAO;
import com.app.dao.interfaces.*;
import com.app.models.*;
import com.app.services.interfaces.IIngresoInsumoService;
import com.app.services.interfaces.IIngresoMateriaPrimaService;
import com.app.utils.ListUtils;
import com.app.utils.MappingUtils;
import com.app.viewModels.IngresoInsumoCreateViewModel;
import com.app.viewModels.IngresoMateriaPrimaCreateViewModel;
import com.app.viewModels.IngresoInsumoViewModel;
import jakarta.inject.Inject;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;

import java.util.Date;
import java.util.List;

@Service
@PerLookup
public class IngresoInsumoService implements IIngresoInsumoService {
    @Inject
    private IInsumoDao insumoDao;
    @Inject
    private IIngresoInsumoDao ingresoInsumoDao;

    @Override
    public IngresoInsumoViewModel create(IngresoInsumoCreateViewModel entityToAdd) {
        return null;
    }

    @Override
    public List<IngresoInsumoViewModel> getByFilters() {
        return List.of();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
/*
    @Override
    public IngresoInsumoViewModel create(IngresoInsumoCreateViewModel entityToAdd) {
        Insumo insumo = this.insumoDao.getById(entityToAdd.insumoId);


        IngresoInsumo ingresoInsumoI = new IngresoInsumo( insumo, new Date(), entityToAdd.descripcion, entityToAddantidad, String codigo, double valorCompra);
        ingresoMateriaPrima.setMateriaPrima(materiaPrima);


        ingresoInsumoDao.save(insumo);
        return this.toViewModel(ingresoMateriaPrima);
    }

    @Override
    public List<IngresoInsumoViewModel> getByFilters() {
        return ListUtils.mapList(this.ingresoMateriaPrimaDao.getAll(), this::toViewModel);
    }

    @Override
    public boolean delete(Long id) {
        IngresoMateriaPrima entityToDelete= this.ingresoMateriaPrimaDao.getById(id);
        entityToDelete.setDeleted(true);
        ingresoMateriaPrimaDao.save(entityToDelete);
        return  true;
        
    }


    private IngresoInsumoViewModel toViewModel(IngresoMateriaPrima imp) {
        return new IngresoInsumoViewModel(
                imp.getId(), imp.getValorCompra(),
                imp.getMateriaPrima(), imp.getFecha(),
                MappingUtils.toViewModel(imp.getProductor()),
                imp.getDescripcion(), imp.getCodigo(), imp.getCantidad()


        );
    }
    */

}
