package com.app.dao.implementations;

import com.app.dao.BaseDao;
import com.app.dao.interfaces.IEstadoLoteDao;
import com.app.models.EstadoLote;
import org.jvnet.hk2.annotations.Service;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class EstadoLoteDao extends BaseDao<EstadoLote> implements IEstadoLoteDao {

    @Override
    public List<EstadoLote> getByLote(Long loteId) {
        TypedQuery<EstadoLote> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE lote_producto_elaborado_id = :loteId", this.getGenericClass());
        q.setParameter("loteId", loteId);
        return q.getResultList();
    }
}
