package com.app.dao.interfaces;

import com.app.models.ConsumoMateriaPrima;

import java.util.List;

public interface IConsumoMateriaPrimaDao extends IBasicDao<ConsumoMateriaPrima> {

    List<ConsumoMateriaPrima> getByLote(Long loteId);

    List<ConsumoMateriaPrima> getByMateriaPrima(Long materiaPrimaId);

    List<ConsumoMateriaPrima> getByIngresoMateriaPrima(Long ingresoMateriaPrimaId);

}
