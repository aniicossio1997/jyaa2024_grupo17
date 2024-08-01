package com.app.services.interfaces;

import com.app.viewModels.EstadoIngresoMateriaPrimaCreateViewModel;
import com.app.viewModels.EstadoViewModel;
import org.jvnet.hk2.annotations.Contract;

@Contract
public interface IEstadoElaboracionService {
    EstadoViewModel create(EstadoIngresoMateriaPrimaCreateViewModel entityToAdd);
}
