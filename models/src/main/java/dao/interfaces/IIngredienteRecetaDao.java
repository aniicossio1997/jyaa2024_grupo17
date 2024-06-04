package dao.interfaces;

import grupo17.IngredienteReceta;

import java.util.List;

public interface IIngredienteRecetaDao extends IBasicDao<IngredienteReceta> {

    List<IngredienteReceta> getByRecetaId(Long recetaId);
}
