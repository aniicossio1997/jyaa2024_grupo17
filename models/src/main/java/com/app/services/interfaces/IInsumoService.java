package com.app.services.interfaces;

import com.app.viewModels.*;
import com.app.viewModels.base.NameableViewModel;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IInsumoService {
    List<RecursoViewModel> getAll();
    RecursoDetailViewModel create(InsumoCreateViewModel entityToAdd);
    RecursoDetailViewModel getById(Long id);
    RecursoDetailViewModel update(Long id, RecursoPostViewModel entityToEdit);
    void delete(Long id);
}
