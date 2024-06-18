package com.app.dao.interfaces;

import com.app.models.EstadoLote;
import com.app.models.IngredienteReceta;

import java.util.List;

public interface IEstadoLoteDao extends IBasicDao<EstadoLote> {

    List<EstadoLote> getByLote(Long loteId);
}
