package com.app.services;

import com.app.dao.FactoryDAO;
import com.app.dao.interfaces.IInsumoDao;

import com.app.models.Insumo;
import com.app.models.MateriaPrima;
import com.app.services.interfaces.IInsumoService;
import com.app.utils.ListUtils;
import com.app.viewModels.InsumoCreateViewModel;
import com.app.viewModels.InsumoViewModel;
import com.app.viewModels.RecursoPostViewModel;
import com.app.viewModels.base.NameableViewModel;
import jakarta.inject.Inject;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Contract;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@Service
@PerLookup
public class InsumoService  implements IInsumoService {
    @Inject
    private IInsumoDao insumoDao;
    @Override
    public List<NameableViewModel> getAll() {
        return  ListUtils.mapList(insumoDao.getAll(), this::toViewModel);
    }

    @Override
    public InsumoViewModel create(InsumoCreateViewModel entityToAdd) {
        Insumo insumo=new Insumo(entityToAdd.getNombre(), entityToAdd.getCantidadDisponible(), entityToAdd.getDescripcion(), entityToAdd.getUnidadMedida());
       this.insumoDao.save(insumo );
       return this.toViewModel(insumo);
    }

    @Override
    public InsumoViewModel getById(Long id) {
        return toViewModel(insumoDao.getById(id));
    }

    @Override
    public InsumoViewModel update(Long id, RecursoPostViewModel entityToEdit) {
        Insumo entity = this.insumoDao.getById(id);
        entity.setNombre(entityToEdit.nombre);
        entity.setDescripcion(entityToEdit.descripcion);
        this.insumoDao.save(entity);
        return this.toViewModel(entity);
    }


    @Override
    public void delete(Long id) {

    }

    private InsumoViewModel toViewModel(Insumo insumo) {
        return new InsumoViewModel(
                insumo.getId(),
                insumo.getNombre(),
                insumo.getCantidadDisponible(),
                insumo.getUnidadMedida(),
                insumo.getDescripcion()

        );
    }
}
