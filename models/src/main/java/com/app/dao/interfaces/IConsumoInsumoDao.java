package com.app.dao.interfaces;

import com.app.models.ConsumoInsumo;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IConsumoInsumoDao extends IBasicDao<ConsumoInsumo> {

    List<ConsumoInsumo> getByElaboracion(Long elaboracionId);

    List<ConsumoInsumo> getByInsumo(Long insumoId);

}
