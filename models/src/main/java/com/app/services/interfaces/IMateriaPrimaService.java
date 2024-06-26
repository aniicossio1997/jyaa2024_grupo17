package com.app.services.interfaces;

import com.app.viewModels.RecursoPostViewModel;
import com.app.viewModels.RecursoDetailViewModel;
import com.app.viewModels.RecursoViewModel;
import com.app.viewModels.base.NameableViewModel;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IMateriaPrimaService {
    List<RecursoViewModel> getAll();
    RecursoDetailViewModel getById(Long id);
    RecursoDetailViewModel create(RecursoPostViewModel entityToAdd);
    RecursoDetailViewModel update(Long id, RecursoPostViewModel entityToEdit);

    void delete(Long id);

}
