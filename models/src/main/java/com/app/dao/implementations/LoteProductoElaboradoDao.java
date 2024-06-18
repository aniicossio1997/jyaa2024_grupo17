package com.app.dao.implementations;

import com.app.dao.BaseDao;
import com.app.dao.interfaces.ILoteProductoElaboradoDao;
import com.app.models.IngredienteReceta;
import com.app.models.LoteProductoElaborado;
import com.app.models.PuntoVenta;

import javax.persistence.TypedQuery;
import java.util.List;

public class LoteProductoElaboradoDao extends BaseDao<LoteProductoElaborado> implements ILoteProductoElaboradoDao {

    public List<LoteProductoElaborado> getByRecetaId(Long recetaId) {
        TypedQuery<LoteProductoElaborado> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE receta_id = :recetaId", this.getGenericClass());
        q.setParameter("recetaId", recetaId);
        return q.getResultList();
    }
}
