package com.app.dao.interfaces;

import com.app.models.EstadoLote;
import com.app.models.EstadoMateriaPrima;

import java.util.List;

public interface IEstadoMateriaPrimaDao extends IBasicDao<EstadoMateriaPrima> {

    List<EstadoMateriaPrima> getByMateriaPrima(Long materiaPrimaId);
    List<EstadoMateriaPrima> getByIngresoMateriaPrima(Long ingresoMateriaPrimaId);

}
