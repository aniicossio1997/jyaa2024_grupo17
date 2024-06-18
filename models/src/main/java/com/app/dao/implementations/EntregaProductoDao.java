package com.app.dao.implementations;

import com.app.dao.BaseDao;
import com.app.dao.interfaces.IEntregaProductoDao;
import com.app.models.EntregaProducto;
import com.app.models.IngredienteReceta;
import com.app.models.PuntoVenta;

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
