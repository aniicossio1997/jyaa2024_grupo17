package com.app.dao.implementations;


import com.app.dao.BaseDao;
import com.app.dao.interfaces.IMateriaPrimaDao;
import com.app.models.MateriaPrima;
import org.jvnet.hk2.annotations.Service;

import javax.persistence.TypedQuery;

@Service
public class MateriaPrimaDao extends BaseDao<MateriaPrima> implements IMateriaPrimaDao {

    public double getCantidadIngresos(Long materiaPrimaId) {
        String jpql = "SELECT SUM(i.cantidad) FROM IngresoMateriaPrima i WHERE i.materiaPrima.id = :materiaPrimaId";
        TypedQuery<Double> query = em.createQuery(jpql, Double.class);
        query.setParameter("materiaPrimaId", materiaPrimaId);
        Double result = query.getSingleResult();
        return result != null ? result : 0.0;
    }
}
