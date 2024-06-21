package com.app.dao.implementations;

import com.app.dao.BaseDao;
import com.app.dao.interfaces.ILoteProductoElaboradoDao;
import com.app.models.LoteProductoElaborado;
import org.jvnet.hk2.annotations.Service;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class LoteProductoElaboradoDao extends BaseDao<LoteProductoElaborado> implements ILoteProductoElaboradoDao {

    public List<LoteProductoElaborado> getByRecetaId(Long recetaId) {
        TypedQuery<LoteProductoElaborado> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE receta_id = :recetaId", this.getGenericClass());
        q.setParameter("recetaId", recetaId);
        return q.getResultList();
    }
}
