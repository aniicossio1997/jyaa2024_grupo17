package com.app.dao.interfaces;

import com.app.models.EstadoLote;
import com.app.models.IngredienteReceta;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;
@Contract
public interface IEstadoLoteDao extends IBasicDao<EstadoLote> {

    List<EstadoLote> getByLote(Long loteId);
}
