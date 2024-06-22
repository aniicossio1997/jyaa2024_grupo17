package com.app.services;

import com.app.dao.FactoryDAO;
import com.app.dao.interfaces.IFamiliaProductoraDao;
import com.app.dao.interfaces.IIngresoMateriaPrimaDao;
import com.app.dao.interfaces.IMateriaPrimaDao;
import com.app.models.FamiliaProductora;
import com.app.models.IngresoMateriaPrima;
import com.app.models.Insumo;
import com.app.models.MateriaPrima;
import com.app.services.interfaces.IIngresoMateriaPrimaService;
import com.app.utils.ListUtils;
import com.app.utils.MappingUtils;
import com.app.viewModels.IngresoMateriaPrimaCreateViewModel;
import com.app.viewModels.IngresoMateriaPrimaViewModel;
import com.app.viewModels.InsumoViewModel;
import jakarta.inject.Inject;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;

import java.util.Date;
import java.util.List;

@Service
@PerLookup
public class IngresoMateriaPrimaService implements IIngresoMateriaPrimaService {
    @Inject
    private IFamiliaProductoraDao familiaProductoraDao;
    @Inject
    private IMateriaPrimaDao materiaPrimaDao;
    @Inject
    private IIngresoMateriaPrimaDao ingresoMateriaPrimaDao;

    @Override
    public IngresoMateriaPrimaViewModel create(IngresoMateriaPrimaCreateViewModel entityToAdd) {
        FamiliaProductora familia = familiaProductoraDao.getById(entityToAdd.familiaPrimaId,true);
        MateriaPrima materiaPrima = this.materiaPrimaDao.getById(entityToAdd.materiaPrimaId);
        IngresoMateriaPrima ingresoMateriaPrima = new IngresoMateriaPrima(entityToAdd.cantidad, entityToAdd.codigo, entityToAdd.descripcion,
                entityToAdd.fecha, entityToAdd.valorCompra);
        ingresoMateriaPrima.setMateriaPrima(materiaPrima);
        ingresoMateriaPrima.setProductor(familia);

        ingresoMateriaPrimaDao.save(ingresoMateriaPrima);
        return this.toViewModel(ingresoMateriaPrima);
    }

    @Override
    public List<IngresoMateriaPrimaViewModel> getByFilters() {
        return ListUtils.mapList(this.ingresoMateriaPrimaDao.getAll(), this::toViewModel);
    }

    @Override
    public boolean delete(Long id) {
        IngresoMateriaPrima entityToDelete= this.ingresoMateriaPrimaDao.getById(id);
        entityToDelete.setFechaBaja(new Date());;
        ingresoMateriaPrimaDao.save(entityToDelete);
        return  true;
        
    }

    @Override
    public IngresoMateriaPrimaViewModel getById(Long id) {
        return toViewModel(this.ingresoMateriaPrimaDao.getById(id));
    }


    private IngresoMateriaPrimaViewModel toViewModel(IngresoMateriaPrima imp) {
        return new IngresoMateriaPrimaViewModel(
                imp.getId(), imp.getValorCompra(),
                imp.getMateriaPrima(), imp.getFecha(),
                MappingUtils.toViewModel(imp.getProductor()),
                imp.getDescripcion(), imp.getCodigo(), imp.getCantidad()


        );
    }
}