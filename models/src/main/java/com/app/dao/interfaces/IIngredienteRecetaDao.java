package com.app.dao.interfaces;

import com.app.models.IngredienteReceta;

import java.util.List;

public interface IIngredienteRecetaDao extends IBasicDao<IngredienteReceta> {

    List<IngredienteReceta> getByRecetaId(Long recetaId);
}
