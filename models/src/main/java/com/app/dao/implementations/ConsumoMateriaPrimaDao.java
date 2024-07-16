package com.app.dao.implementations;

import com.app.dao.BaseDao;
import com.app.dao.interfaces.IConsumoMateriaPrimaDao;
import com.app.models.ConsumoMateriaPrima;
import org.jvnet.hk2.annotations.Service;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class ConsumoMateriaPrimaDao extends BaseDao<ConsumoMateriaPrima> implements IConsumoMateriaPrimaDao {

    @Override
    public List<ConsumoMateriaPrima> getByElaboracion(Long elaboracionId) {
        TypedQuery<ConsumoMateriaPrima> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE elaboracion_id = :elaboracionId", this.getGenericClass());
        q.setParameter("elaboracionId", elaboracionId);
        return q.getResultList();
    }

    @Override
    public List<ConsumoMateriaPrima> getByMateriaPrima(Long materiaPrimaId) {
        TypedQuery<ConsumoMateriaPrima> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE materia_prima_id = :materiaPrimaId", this.getGenericClass());
        q.setParameter("materiaPrimaId", materiaPrimaId);
        return q.getResultList();
    }

    @Override
    public List<ConsumoMateriaPrima> getByIngresoMateriaPrima(Long ingresoMateriaPrimaId) {
        TypedQuery<ConsumoMateriaPrima> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE ingreso_materia_prima_id = :ingresoMateriaPrimaId", this.getGenericClass());
        q.setParameter("ingresoMateriaPrimaId", ingresoMateriaPrimaId);
        return q.getResultList();
    }

}
