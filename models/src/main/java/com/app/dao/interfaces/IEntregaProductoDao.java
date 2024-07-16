package com.app.dao.interfaces;

import com.app.models.EntregaProducto;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;
@Contract
public interface IEntregaProductoDao extends IBasicDao<EntregaProducto> {
    List<EntregaProducto> getByElaboracion(Long elaboracionId);

    List<EntregaProducto> getByPuntoVenta(Long puntoVentaId);
}
