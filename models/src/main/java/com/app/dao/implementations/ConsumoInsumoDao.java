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
    public List<ConsumoInsumo> getByElaboracion(Long elaboracionId) {
        TypedQuery<ConsumoInsumo> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE elaboracion_id = :elaboracionId", this.getGenericClass());
        q.setParameter("elaboracionId", elaboracionId);
        return q.getResultList();
    }

    @Override
    public List<ConsumoInsumo> getByInsumo(Long insumoId) {
        TypedQuery<ConsumoInsumo> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE insumo_id = :insumoId", this.getGenericClass());
        q.setParameter("insumoId", insumoId);
        return q.getResultList();
    }
}
