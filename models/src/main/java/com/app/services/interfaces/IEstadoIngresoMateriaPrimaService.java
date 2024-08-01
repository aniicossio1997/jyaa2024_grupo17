package com.app.services.interfaces;

import com.app.viewModels.EstadoElaboracionCreateViewModel;
import com.app.viewModels.EstadoIngresoMateriaPrimaCreateViewModel;
import com.app.viewModels.EstadoViewModel;
import com.app.viewModels.IngresoMateriaPrimaCreateViewModel;
import org.jvnet.hk2.annotations.Contract;

@Contract
public interface IEstadoIngresoMateriaPrimaService {
    EstadoViewModel create(EstadoElaboracionCreateViewModel entityToAdd);
}
