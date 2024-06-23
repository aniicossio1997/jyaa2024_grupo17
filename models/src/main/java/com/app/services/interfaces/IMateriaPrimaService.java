package com.app.services.interfaces;

import com.app.models.baseEntity.NameableBaseEntity;
import com.app.viewModels.RecursoPostViewModel;
import com.app.viewModels.RecursoViewModel;
import com.app.viewModels.base.NameableViewModel;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IMateriaPrimaService {
    List<NameableViewModel> getAll();
    RecursoViewModel getById(Long id);
    RecursoViewModel create(RecursoPostViewModel entityToAdd);
    RecursoViewModel update(Long id,RecursoPostViewModel entityToEdit);

    void delete(Long id);

}
