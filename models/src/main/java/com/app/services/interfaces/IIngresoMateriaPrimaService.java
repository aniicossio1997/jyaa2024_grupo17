package com.app.services.interfaces;

import com.app.viewModels.IngresoMateriaPrimaCreateViewModel;
import com.app.viewModels.IngresoMateriaPrimaViewModel;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IIngresoMateriaPrimaService {
    IngresoMateriaPrimaViewModel create(IngresoMateriaPrimaCreateViewModel ingresoMateriaPrima);
    List<IngresoMateriaPrimaViewModel> getByFilters();
    boolean delete(Long id);
    IngresoMateriaPrimaViewModel getById(Long id);
}