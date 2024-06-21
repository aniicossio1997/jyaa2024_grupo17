package com.app.dao.interfaces;

import com.app.models.IngredienteReceta;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;
@Contract
public interface IIngredienteRecetaDao extends IBasicDao<IngredienteReceta> {

    List<IngredienteReceta> getByRecetaId(Long recetaId);
}
