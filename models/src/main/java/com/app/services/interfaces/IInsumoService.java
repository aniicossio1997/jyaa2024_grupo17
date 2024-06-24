package com.app.services.interfaces;

import com.app.viewModels.InsumoCreateViewModel;
import com.app.viewModels.InsumoViewModel;
import com.app.viewModels.RecursoPostViewModel;
import com.app.viewModels.base.NameableViewModel;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IInsumoService {
    List<NameableViewModel> getAll();
    InsumoViewModel create(InsumoCreateViewModel entityToAdd);
    InsumoViewModel getById(Long id);
    InsumoViewModel update(Long id, RecursoPostViewModel entityToEdit);
    void delete(Long id);
}
