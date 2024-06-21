package com.app.dao.interfaces;

import com.app.models.IngredienteReceta;
import com.app.models.LoteProductoElaborado;
import com.app.models.PuntoVenta;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;
@Contract
public interface ILoteProductoElaboradoDao extends IBasicDao<LoteProductoElaborado> {

    List<LoteProductoElaborado> getByRecetaId(Long recetaId);
}
