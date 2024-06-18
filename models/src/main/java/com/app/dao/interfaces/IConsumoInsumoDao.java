package com.app.dao.interfaces;

import com.app.models.ConsumoInsumo;
import com.app.models.IngredienteReceta;
import com.app.models.IngresoInsumo;

import java.util.List;

public interface IConsumoInsumoDao extends IBasicDao<ConsumoInsumo> {

    List<ConsumoInsumo> getByLote(Long loteId);

    List<ConsumoInsumo> getByInsumo(Long insumoId);

}
