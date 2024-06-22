package com.app.services;

import com.app.dao.FactoryDAO;
import com.app.dao.interfaces.IMateriaPrimaDao;
import com.app.models.FamiliaProductora;
import com.app.models.Insumo;
import com.app.models.MateriaPrima;
import com.app.services.interfaces.IMateriaPrimaService;
import com.app.utils.ListUtils;
import com.app.viewModels.InsumoViewModel;
import com.app.viewModels.RecursoPostViewModel;
import com.app.viewModels.RecursoViewModel;
import com.app.viewModels.base.NameableViewModel;
import jakarta.inject.Inject;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@Service
@PerLookup
public class MateriaPrimaService  implements IMateriaPrimaService {
    @Inject
    private IMateriaPrimaDao materiaPrimaDao;

    @Override
    public List<NameableViewModel> getAll() {
        return  ListUtils.mapList(materiaPrimaDao.getAll(), this::toViewModelName);
    }

    @Override
    public RecursoViewModel getById(Long id) {
        MateriaPrima entity = this.materiaPrimaDao.getById(id);
        return this.toViewModel(entity);
    }

    @Override
    public RecursoViewModel create(RecursoPostViewModel entityToAdd) {
        MateriaPrima entityNew= new MateriaPrima(entityToAdd.nombre, entityToAdd.unidadMedida, entityToAdd.descripcion);
        this.materiaPrimaDao.save(entityNew);
        return this.toViewModel(entityNew);
    }

    @Override
    public RecursoViewModel update(Long id, RecursoPostViewModel entityToEdit) {
        MateriaPrima entity = this.materiaPrimaDao.getById(id);
        entity.setNombre(entityToEdit.nombre);
        entity.setDescripcion(entityToEdit.descripcion);
        this.materiaPrimaDao.save(entity);
        return this.toViewModel(entity);
    }

    @Override
    public void delete(Long id) {

    }

    private NameableViewModel toViewModelName(MateriaPrima entity) {
        return new NameableViewModel(
                entity.getId(),
                entity.getNombre()

        );
    }
    private RecursoViewModel toViewModel(MateriaPrima entity) {
        return new RecursoViewModel(
                entity.getId(),
                entity.getNombre(),
                entity.getCantidadIngresos(),
                entity.getUnidadMedida(),
                entity.getDescripcion()

        );
    }
}
