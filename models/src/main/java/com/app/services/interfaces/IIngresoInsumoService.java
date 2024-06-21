package com.app.services.interfaces;

import com.app.viewModels.IngresoInsumoViewModel;
import com.app.viewModels.IngresoInsumoCreateViewModel;
import com.app.viewModels.IngresoMateriaPrimaViewModel;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IIngresoInsumoService {
    IngresoInsumoViewModel create(IngresoInsumoCreateViewModel entityToAdd);
    List<IngresoInsumoViewModel> getByFilters();
    boolean delete(Long id);
}
