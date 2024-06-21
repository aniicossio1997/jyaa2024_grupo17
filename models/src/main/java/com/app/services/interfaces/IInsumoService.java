package com.app.services.interfaces;

import com.app.viewModels.InsumoCreateViewModel;
import com.app.viewModels.InsumoViewModel;
import com.app.viewModels.base.NameableViewModel;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IInsumoService {
    List<NameableViewModel> getAll();
    InsumoViewModel create(InsumoCreateViewModel materiaPrima);
}
