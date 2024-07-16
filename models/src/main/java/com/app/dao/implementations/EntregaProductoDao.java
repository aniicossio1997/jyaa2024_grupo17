package com.app.dao.implementations;

import com.app.dao.BaseDao;
import com.app.dao.interfaces.IEntregaProductoDao;
import com.app.models.EntregaProducto;
import org.jvnet.hk2.annotations.Service;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class EntregaProductoDao extends BaseDao<EntregaProducto> implements IEntregaProductoDao {

    @Override
    public List<EntregaProducto> getByElaboracion(Long elaboracionId) {
        TypedQuery<EntregaProducto> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE elaboracion_id = :elaboracionId", this.getGenericClass());
        q.setParameter("elaboracionId", elaboracionId);
        return q.getResultList();
    }

    @Override
    public List<EntregaProducto> getByPuntoVenta(Long puntoVentaId) {
        TypedQuery<EntregaProducto> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE punto_venta_id = :puntoVentaId", this.getGenericClass());
        q.setParameter("puntoVentaId", puntoVentaId);
        return q.getResultList();
    }
}
