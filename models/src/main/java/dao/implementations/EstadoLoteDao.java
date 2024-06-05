package dao.implementations;

import dao.BaseDao;
import dao.interfaces.IEstadoLoteDao;
import dao.interfaces.IIngresoInsumoDao;
import grupo17.EstadoLote;
import grupo17.IngredienteReceta;
import grupo17.IngresoInsumo;

import javax.persistence.TypedQuery;
import java.util.List;

public class EstadoLoteDao extends BaseDao<EstadoLote> implements IEstadoLoteDao {

    @Override
    public List<EstadoLote> getByLote(Long loteId) {
        TypedQuery<EstadoLote> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE lote_producto_elaborado_id = :loteId", this.getGenericClass());
        q.setParameter("loteId", loteId);
        return q.getResultList();
    }
}
