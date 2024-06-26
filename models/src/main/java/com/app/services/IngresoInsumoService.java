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
        Insumo insumo= insumoDao.getById(entityToAdd.insumoId,true);


        IngresoInsumo entity = new IngresoInsumo(insumo,new Date(),entityToAdd.descripcion,
                entityToAdd.cantidad,entityToAdd.codigo,entityToAdd.valorCompra
                );
        insumo.addIngresoInsumo(entity);
        ingresoInsumoDao.save(entity);

        return this.toViewModel(entity);
    }

    @Override
    public IngresoInsumoViewModel getById(Long id) {
        return this.toViewModel(this.ingresoInsumoDao.getById(id));
    }

    @Override
    public IngresoInsumoViewModel update(Long id, IngresoInsumoCreateViewModel entityToAdd) {
        Insumo insumo= insumoDao.getById(entityToAdd.insumoId);
        IngresoInsumo entity=ingresoInsumoDao.getById(id);

        entity.setInsumo(insumo);
        entity.setCantidad(entityToAdd.cantidad);
        entity.setCodigo(entityToAdd.codigo);
        entity.setDescripcion(entityToAdd.descripcion);
        entity.setValorCompra(entityToAdd.valorCompra);

        ingresoInsumoDao.save(entity);

        return this.toViewModel(entity);
    }

    @Override
    public List<IngresoInsumoViewModel> getByFilters() {
        return ListUtils.mapList(this.ingresoInsumoDao.getAll(), this::toViewModel);
    }

    @Override
    public boolean delete(Long id) {
        IngresoInsumo entityToDelete= this.ingresoInsumoDao.getById(id);
        entityToDelete.setFechaBaja(new Date());
        ingresoInsumoDao.save(entityToDelete);
        return  true;
    }

    private IngresoInsumoViewModel toViewModel(IngresoInsumo imp) {

        return new IngresoInsumoViewModel(
                imp.getId(), imp.getValorCompra(),
                imp.getFecha(),imp.getInsumo(),
                imp.getDescripcion(), imp.getCodigo(), imp.getCantidad()


        );
    }

}
