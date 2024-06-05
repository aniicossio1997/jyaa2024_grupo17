package dao.interfaces;

import grupo17.ConsumoMateriaPrima;

import java.util.List;

public interface IConsumoMateriaPrimaDao extends IBasicDao<ConsumoMateriaPrima> {

    List<ConsumoMateriaPrima> getByLote(Long loteId);

    List<ConsumoMateriaPrima> getByMateriaPrima(Long materiaPrimaId);

    List<ConsumoMateriaPrima> getByIngresoMateriaPrima(Long ingresoMateriaPrimaId);

}
