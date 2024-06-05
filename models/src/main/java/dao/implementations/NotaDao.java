package dao.implementations;

import dao.BaseDao;
import dao.interfaces.ILoteProductoElaboradoDao;
import dao.interfaces.INotaDao;
import grupo17.IngredienteReceta;
import grupo17.LoteProductoElaborado;
import grupo17.Nota;

import javax.persistence.TypedQuery;
import java.util.List;

public class NotaDao extends BaseDao<Nota> implements INotaDao {

    protected boolean getDeletable() {
        return true;
    }

    public List<Nota> getByLote(Long loteId) {
        TypedQuery<Nota> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE lote.id = :loteId", this.getGenericClass());
        q.setParameter("loteId", loteId);
        return q.getResultList();
    }
}
