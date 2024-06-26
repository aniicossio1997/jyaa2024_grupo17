package com.app.services;

import com.app.dao.interfaces.IMateriaPrimaDao;
import com.app.models.MateriaPrima;
import com.app.models.Recurso;
import com.app.services.interfaces.IMateriaPrimaService;
import com.app.utils.ListUtils;
import com.app.viewModels.RecursoPostViewModel;
import com.app.viewModels.RecursoDetailViewModel;
import com.app.viewModels.RecursoViewModel;
import com.app.viewModels.base.NameableViewModel;
import jakarta.inject.Inject;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;

import java.util.Date;
import java.util.List;

@Service
@PerLookup
public class MateriaPrimaService  implements IMateriaPrimaService {
    @Inject
    private IMateriaPrimaDao materiaPrimaDao;
    @Inject
    private MappingService mappingService;

    @Override
    public List<RecursoViewModel> getAll() {
        return  ListUtils.mapList(materiaPrimaDao.getAll(true), this::toViewModel);
    }

    @Override
    public RecursoDetailViewModel getById(Long id) {
        MateriaPrima entity = this.materiaPrimaDao.getById(id);
        return mappingService.toViewModelDetail(entity);
    }

    @Override
    public RecursoDetailViewModel create(RecursoPostViewModel entityToAdd) {
        MateriaPrima entityNew= new MateriaPrima(entityToAdd.nombre, entityToAdd.unidadMedida, entityToAdd.descripcion);
        this.materiaPrimaDao.save(entityNew);
        return mappingService.toViewModelDetail(entityNew);
    }

    @Override
    public RecursoDetailViewModel update(Long id, RecursoPostViewModel entityToEdit) {
        MateriaPrima entity = this.materiaPrimaDao.getById(id);
        entity.setNombre(entityToEdit.nombre);
        entity.setDescripcion(entityToEdit.descripcion);
        entity.setUnidadMedida(entityToEdit.unidadMedida);

        this.materiaPrimaDao.save(entity);
        return mappingService.toViewModelDetail(entity);
    }

    @Override
    public void delete(Long id) {
        MateriaPrima entityToDelete= this.materiaPrimaDao.getById(id,true);
        entityToDelete.setFechaBaja(new Date());;
        this.materiaPrimaDao.save(entityToDelete);
    }

    public RecursoViewModel toViewModel(MateriaPrima entity) {
        return new RecursoViewModel(
                entity.getId(),
                entity.getNombre(),
                entity.getUnidadMedida(),
                entity.getCantidadIngresos(),
                entity.getTotalValorDeCompra()
        );
    }
    public RecursoDetailViewModel toViewModelDetail(Recurso entity) {
        return new RecursoDetailViewModel(
                entity.getId(),
                entity.getNombre(),
                entity.getUnidadMedida(),
                entity.getDescripcion(),
                entity.getCantidadIngresos(),
                entity.getTotalValorDeCompra()

        );
    }

}
