package com.app.dao.interfaces;

import com.app.models.ConsumoMateriaPrima;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;
@Contract
public interface IConsumoMateriaPrimaDao extends IBasicDao<ConsumoMateriaPrima> {

    List<ConsumoMateriaPrima> getByLote(Long loteId);

    List<ConsumoMateriaPrima> getByMateriaPrima(Long materiaPrimaId);

    List<ConsumoMateriaPrima> getByIngresoMateriaPrima(Long ingresoMateriaPrimaId);

}
