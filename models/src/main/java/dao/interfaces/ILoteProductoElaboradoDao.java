package dao.interfaces;

import grupo17.IngredienteReceta;
import grupo17.LoteProductoElaborado;
import grupo17.PuntoVenta;

import java.util.List;

public interface ILoteProductoElaboradoDao extends IBasicDao<LoteProductoElaborado> {

    List<LoteProductoElaborado> getByRecetaId(Long recetaId);
}
