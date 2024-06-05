package dao.implementations;

import dao.BaseDao;
import dao.interfaces.IEntregaProductoDao;
import dao.interfaces.IPuntoVentaDao;
import grupo17.EntregaProducto;
import grupo17.IngredienteReceta;
import grupo17.PuntoVenta;

import javax.persistence.TypedQuery;
import java.util.List;

public class EntregaProductoDao extends BaseDao<EntregaProducto> implements IEntregaProductoDao {

    @Override
    public List<EntregaProducto> getByLote(Long loteId) {
        TypedQuery<EntregaProducto> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE lote_producto_elaborado_id = :loteId", this.getGenericClass());
        q.setParameter("loteId", loteId);
        return q.getResultList();
    }

    @Override
    public List<EntregaProducto> getByPuntoVenta(Long puntoVentaId) {
        TypedQuery<EntregaProducto> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE punto_venta_id = :puntoVentaId", this.getGenericClass());
        q.setParameter("puntoVentaId", puntoVentaId);
        return q.getResultList();
    }
}
