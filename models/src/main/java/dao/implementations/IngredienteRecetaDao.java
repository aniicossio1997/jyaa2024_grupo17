package dao.implementations;

import dao.BaseDao;
import dao.interfaces.IIngredienteRecetaDao;
import dao.interfaces.IRecetaDao;
import grupo17.IngredienteReceta;
import grupo17.Receta;

import javax.persistence.TypedQuery;
import java.util.List;

public class IngredienteRecetaDao extends BaseDao<IngredienteReceta> implements IIngredienteRecetaDao {

    public List<IngredienteReceta> getByRecetaId(Long recetaId) {
        TypedQuery<IngredienteReceta> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE receta_id = :recetaId", this.getGenericClass());
        q.setParameter("recetaId", recetaId);
        return q.getResultList();
    }
}
