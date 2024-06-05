package dao.implementations;

import dao.BaseDao;
import dao.interfaces.IEstadoLoteDao;
import dao.interfaces.IEstadoMateriaPrimaDao;
import grupo17.EstadoLote;
import grupo17.EstadoMateriaPrima;

import javax.persistence.TypedQuery;
import java.util.List;

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
