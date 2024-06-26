package com.app.services.interfaces;

import com.app.viewModels.IngresoInsumoViewModel;
import com.app.viewModels.IngresoInsumoCreateViewModel;
import com.app.viewModels.IngresoMateriaPrimaViewModel;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IIngresoInsumoService {
    List<IngresoInsumoViewModel> getByFilters();
    IngresoInsumoViewModel create(IngresoInsumoCreateViewModel entityToAdd);
    IngresoInsumoViewModel getById(Long id);
    IngresoInsumoViewModel update(Long id,IngresoInsumoCreateViewModel entityToAdd);
    boolean delete(Long id);
}
