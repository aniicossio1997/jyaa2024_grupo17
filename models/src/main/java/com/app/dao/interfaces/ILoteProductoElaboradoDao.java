package com.app.dao.interfaces;

import com.app.models.IngredienteReceta;
import com.app.models.LoteProductoElaborado;
import com.app.models.PuntoVenta;

import java.util.List;

public interface ILoteProductoElaboradoDao extends IBasicDao<LoteProductoElaborado> {

    List<LoteProductoElaborado> getByRecetaId(Long recetaId);
}
