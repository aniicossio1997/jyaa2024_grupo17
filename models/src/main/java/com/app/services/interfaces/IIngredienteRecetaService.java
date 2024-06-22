package com.app.services.interfaces;

import com.app.viewModels.*;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IIngredienteRecetaService {

    List<IngredienteRecetaViewModel> getAllByReceta(Long recetaId);

    IngredienteRecetaViewModel getById(Long id);

    IngredienteRecetaViewModel create(IngredienteRecetaCreateViewModel view);

    IngredienteRecetaViewModel update(Long id, IngredienteRecetaCreateViewModel view);

    boolean delete(Long id);

}
