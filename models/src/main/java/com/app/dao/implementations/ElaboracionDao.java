package com.app.dao.implementations;

import com.app.dao.BaseDao;
import com.app.dao.interfaces.IElaboracionDao;
import com.app.models.Elaboracion;
import org.jvnet.hk2.annotations.Service;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class ElaboracionDao extends BaseDao<Elaboracion> implements IElaboracionDao {

    public List<Elaboracion> getByRecetaId(Long recetaId) {
        TypedQuery<Elaboracion> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE receta_id = :recetaId", this.getGenericClass());
        q.setParameter("recetaId", recetaId);
        return q.getResultList();
    }
}
