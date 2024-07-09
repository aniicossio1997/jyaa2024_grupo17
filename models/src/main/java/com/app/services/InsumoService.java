package com.app.services;

import com.app.dao.FactoryDAO;
import com.app.dao.interfaces.IInsumoDao;

import com.app.models.IngresoMateriaPrima;
import com.app.models.Insumo;
import com.app.models.MateriaPrima;
import com.app.services.interfaces.IInsumoService;
import com.app.utils.ListUtils;
import com.app.utils.MappingUtils;
import com.app.viewModels.*;
import com.app.viewModels.base.NameableViewModel;
import jakarta.inject.Inject;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Contract;
import org.jvnet.hk2.annotations.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@PerLookup
public class InsumoService  implements IInsumoService {
    @Inject
    private IInsumoDao insumoDao;


    @Inject
    private MappingService mappingService;

    @Override
    public List<RecursoViewModel> getAll() {
        return  ListUtils.mapList(insumoDao.getAll(true), this::toViewModel);
    }

    @Override
    public RecursoDetailViewModel create(InsumoCreateViewModel entityToAdd) {
        Insumo insumo=new Insumo(entityToAdd.getNombre(),  entityToAdd.getDescripcion(), entityToAdd.getUnidadMedida());

        this.insumoDao.save(insumo );
       return  mappingService.toViewModelDetail(insumo);
    }

    @Override
    public InsumoDetailViewModel getById(Long id) {
        return this.toViewModelDetail(insumoDao.getById(id,true));
    }

    @Override
    public RecursoDetailViewModel update(Long id, RecursoPostViewModel entityToEdit) {
        Insumo entity = this.insumoDao.getById(id,true);

        entity.setNombre(entityToEdit.nombre);
        entity.setDescripcion(entityToEdit.descripcion);
        entity.setUnidadMedida(entityToEdit.unidadMedida);
        this.insumoDao.save(entity);
        return mappingService.toViewModelDetail(entity);
    }


    @Override
    public void delete(Long id) {
        Insumo entityToDelete= this.insumoDao.getById(id,true);
        entityToDelete.setFechaBaja(new Date());;
        this.insumoDao.save(entityToDelete);

    }

    private RecursoViewModel toViewModel(Insumo entity) {
        double total=entity.getTotalValorDeCompra();
        double t1=entity.getCantidadIngresos();
        return new RecursoViewModel(
                entity.getId(),
                entity.getNombre(),
                entity.getUnidadMedida(),
                entity.getCantidadIngresos(),
                entity.getTotalValorDeCompra()
        );
    }

    public InsumoDetailViewModel toViewModelDetail(Insumo entity) {
        List<IngresoInsumoViewModel> listIngresos = entity.getIngresos()
                .stream()
                .map(MappingUtils::toViewModelDetails)
                .collect(Collectors.toList());

        return new InsumoDetailViewModel(
                entity.getId(),
                entity.getNombre(),
                entity.getUnidadMedida(),
                entity.getDescripcion(),
                entity.getCantidadIngresos(),
                entity.getTotalValorDeCompra(),
                listIngresos
        );
    }


}
