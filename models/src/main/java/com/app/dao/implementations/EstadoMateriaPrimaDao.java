package com.app.dao.implementations;

import com.app.dao.BaseDao;
import com.app.dao.interfaces.IEstadoMateriaPrimaDao;
import com.app.models.EstadoMateriaPrima;
import org.jvnet.hk2.annotations.Service;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class EstadoMateriaPrimaDao extends BaseDao<EstadoMateriaPrima> implements IEstadoMateriaPrimaDao {

    @Override
    public List<EstadoMateriaPrima> getByMateriaPrima(Long materiaPrimaId) {
        TypedQuery<EstadoMateriaPrima> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE i.ingresoMateriaPrima.materiaPrima.id = :materiaPrimaId", this.getGenericClass());
        q.setParameter("materiaPrimaId", materiaPrimaId);
        return q.getResultList();
    }

    @Override
    public List<EstadoMateriaPrima> getByIngresoMateriaPrima(Long ingresoMateriaPrimaId) {
        TypedQuery<EstadoMateriaPrima> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE ingreso_materia_prima_id = :ingresoMateriaPrimaId", this.getGenericClass());
        q.setParameter("ingresoMateriaPrimaId", ingresoMateriaPrimaId);
        return q.getResultList();
    }
}
