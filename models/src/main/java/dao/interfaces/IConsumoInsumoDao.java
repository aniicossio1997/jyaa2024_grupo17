package dao.interfaces;

import grupo17.ConsumoInsumo;
import grupo17.IngredienteReceta;
import grupo17.IngresoInsumo;

import java.util.List;

public interface IConsumoInsumoDao extends IBasicDao<ConsumoInsumo> {

    List<ConsumoInsumo> getByLote(Long loteId);

    List<ConsumoInsumo> getByInsumo(Long insumoId);

}
