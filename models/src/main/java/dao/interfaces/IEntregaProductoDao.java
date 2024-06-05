package dao.interfaces;

import grupo17.EntregaProducto;
import grupo17.Insumo;

import java.util.List;

public interface IEntregaProductoDao extends IBasicDao<EntregaProducto> {
    List<EntregaProducto> getByLote(Long loteId);

    List<EntregaProducto> getByPuntoVenta(Long puntoVentaId);
}
