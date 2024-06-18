package com.app.dao.interfaces;


import com.app.models.IngredienteReceta;
import com.app.models.Nota;

import java.util.List;

public interface INotaDao extends IBasicDao<Nota> {

    List<Nota> getByLote(Long loteId);
}
