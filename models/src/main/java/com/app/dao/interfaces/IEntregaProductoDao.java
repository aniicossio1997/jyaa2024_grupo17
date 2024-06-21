package com.app.dao.interfaces;

import com.app.models.EntregaProducto;
import com.app.models.Insumo;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;
@Contract
public interface IEntregaProductoDao extends IBasicDao<EntregaProducto> {
    List<EntregaProducto> getByLote(Long loteId);

    List<EntregaProducto> getByPuntoVenta(Long puntoVentaId);
}
