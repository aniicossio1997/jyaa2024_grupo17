package dao.implementations;

import dao.BaseDao;
import dao.interfaces.ILoteProductoElaboradoDao;
import dao.interfaces.IPuntoVentaDao;
import grupo17.IngredienteReceta;
import grupo17.LoteProductoElaborado;
import grupo17.PuntoVenta;

import javax.persistence.TypedQuery;
import java.util.List;

public class LoteProductoElaboradoDao extends BaseDao<LoteProductoElaborado> implements ILoteProductoElaboradoDao {

    public List<LoteProductoElaborado> getByRecetaId(Long recetaId) {
        TypedQuery<LoteProductoElaborado> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE receta_id = :recetaId", this.getGenericClass());
        q.setParameter("recetaId", recetaId);
        return q.getResultList();
    }
}
