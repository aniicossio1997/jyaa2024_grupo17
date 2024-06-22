package com.app.dao.implementations;

import com.app.dao.BaseDao;
import com.app.dao.interfaces.IIngredienteRecetaDao;
import com.app.models.IngredienteReceta;
import org.jvnet.hk2.annotations.Service;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class IngredienteRecetaDao extends BaseDao<IngredienteReceta> implements IIngredienteRecetaDao {

    @Override
    public boolean getDeletable() {
        return true;
    }

    public List<IngredienteReceta> getByRecetaId(Long recetaId) {
        TypedQuery<IngredienteReceta> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE receta_id = :recetaId", this.getGenericClass());
        q.setParameter("recetaId", recetaId);
        return q.getResultList();
    }
}
