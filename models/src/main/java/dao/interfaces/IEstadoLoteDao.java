package dao.interfaces;

import grupo17.EstadoLote;
import grupo17.IngredienteReceta;

import java.util.List;

public interface IEstadoLoteDao extends IBasicDao<EstadoLote> {

    List<EstadoLote> getByLote(Long loteId);
}
