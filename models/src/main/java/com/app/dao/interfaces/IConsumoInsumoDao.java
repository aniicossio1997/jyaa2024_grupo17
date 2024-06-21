package com.app.dao.interfaces;

import com.app.models.ConsumoInsumo;
import com.app.models.IngredienteReceta;
import com.app.models.IngresoInsumo;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IConsumoInsumoDao extends IBasicDao<ConsumoInsumo> {

    List<ConsumoInsumo> getByLote(Long loteId);

    List<ConsumoInsumo> getByInsumo(Long insumoId);

}
