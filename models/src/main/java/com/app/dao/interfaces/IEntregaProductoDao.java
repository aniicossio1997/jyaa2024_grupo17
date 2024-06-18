package com.app.dao.interfaces;

import com.app.models.EntregaProducto;
import com.app.models.Insumo;

import java.util.List;

public interface IEntregaProductoDao extends IBasicDao<EntregaProducto> {
    List<EntregaProducto> getByLote(Long loteId);

    List<EntregaProducto> getByPuntoVenta(Long puntoVentaId);
}
