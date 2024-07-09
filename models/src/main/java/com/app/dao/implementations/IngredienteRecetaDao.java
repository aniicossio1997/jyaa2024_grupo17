package com.app.dao.implementations;

import com.app.dao.BaseDao;
import com.app.dao.interfaces.IIngredienteRecetaDao;
import com.app.models.IngredienteReceta;
import org.jvnet.hk2.annotations.Service;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class IngredienteRecetaDao extends BaseDao<IngredienteReceta> implements IIngredienteRecetaDao {

    @Override
    public boolean getDeletable() {
        return true;
    }

    public boolean delete(Long id) {
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        try {
            Query q = em.createQuery("DELETE FROM " + this.getGenericClass().getName() + " i WHERE id = :id");
            q.setParameter("id", id);
            q.executeUpdate();
            etx.commit();
            return true;
        } catch (Exception e) {
            etx.rollback();
            throw e;
        }
    }

    public List<IngredienteReceta> getByRecetaId(Long recetaId) {
        TypedQuery<IngredienteReceta> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE receta_id = :recetaId", this.getGenericClass());
        q.setParameter("recetaId", recetaId);
        return q.getResultList();
    }
}
