package com.app.dao.implementations;

import com.app.dao.BaseDao;
import com.app.dao.interfaces.IEstadoElaboracionDao;
import com.app.models.EstadoElaboracion;
import org.jvnet.hk2.annotations.Service;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class EstadoElaboracionDao extends BaseDao<EstadoElaboracion> implements IEstadoElaboracionDao {

    @Override
    public List<EstadoElaboracion> getByElaboracion(Long elaboracionId) {
        TypedQuery<EstadoElaboracion> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE elaboracion_id = :elaboracionId", this.getGenericClass());
        q.setParameter("elaboracionId", elaboracionId);
        return q.getResultList();
    }
}
