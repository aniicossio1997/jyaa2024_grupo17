package com.app.dao.implementations;

import com.app.dao.BaseDao;
import com.app.dao.interfaces.INotaDao;
import com.app.models.IngredienteReceta;
import com.app.models.LoteProductoElaborado;
import com.app.models.Nota;

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
