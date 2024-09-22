package com.app.dao.implementations;

import com.app.dao.BaseDao;
import com.app.dao.interfaces.IEntregaElaboracionDao;
import com.app.models.EntregaElaboracion;
import org.jvnet.hk2.annotations.Service;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class EntregaElaboracionDao extends BaseDao<EntregaElaboracion> implements IEntregaElaboracionDao {

    @Override
    public List<EntregaElaboracion> getByElaboracion(Long elaboracionId) {
        TypedQuery<EntregaElaboracion> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE elaboracion_id = :elaboracionId", this.getGenericClass());
        q.setParameter("elaboracionId", elaboracionId);
        return q.getResultList();
    }

    @Override
    public List<EntregaElaboracion> getByPuntoVenta(Long puntoVentaId) {
        TypedQuery<EntregaElaboracion> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE punto_venta_id = :puntoVentaId", this.getGenericClass());
        q.setParameter("puntoVentaId", puntoVentaId);
        return q.getResultList();
    }
}
