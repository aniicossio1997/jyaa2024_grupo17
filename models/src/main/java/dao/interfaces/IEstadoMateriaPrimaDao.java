package dao.interfaces;

import grupo17.EstadoLote;
import grupo17.EstadoMateriaPrima;

import java.util.List;

public interface IEstadoMateriaPrimaDao extends IBasicDao<EstadoMateriaPrima> {

    List<EstadoMateriaPrima> getByMateriaPrima(Long materiaPrimaId);
    List<EstadoMateriaPrima> getByIngresoMateriaPrima(Long ingresoMateriaPrimaId);

}
