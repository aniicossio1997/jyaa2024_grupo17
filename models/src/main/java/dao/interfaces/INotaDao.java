package dao.interfaces;


import grupo17.IngredienteReceta;
import grupo17.Nota;

import java.util.List;

public interface INotaDao extends IBasicDao<Nota> {

    List<Nota> getByLote(Long loteId);
}
