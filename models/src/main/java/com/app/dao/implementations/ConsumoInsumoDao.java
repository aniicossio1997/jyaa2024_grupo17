package com.app.dao.implementations;

import com.app.dao.BaseDao;
import com.app.dao.interfaces.IConsumoInsumoDao;
import com.app.models.ConsumoInsumo;
import org.jvnet.hk2.annotations.Service;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class ConsumoInsumoDao extends BaseDao<ConsumoInsumo> implements IConsumoInsumoDao {


    @Override
    public List<ConsumoInsumo> getByLote(Long loteId) {
        TypedQuery<ConsumoInsumo> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE lote_producto_elaborado_id = :loteId", this.getGenericClass());
        q.setParameter("loteId", loteId);
        return q.getResultList();
    }

    @Override
    public List<ConsumoInsumo> getByInsumo(Long insumoId) {
        TypedQuery<ConsumoInsumo> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE insumo_id = :insumoId", this.getGenericClass());
        q.setParameter("insumoId", insumoId);
        return q.getResultList();
    }
}
