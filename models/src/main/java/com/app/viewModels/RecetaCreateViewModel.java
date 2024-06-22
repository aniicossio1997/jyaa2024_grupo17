package com.app.viewModels;


import com.app.viewModels.base.NameableViewModel;

import java.util.ArrayList;
import java.util.List;

public class RecetaCreateViewModel extends NameableViewModel {
    String descripcion;
    List<IngredienteRecetaCreateViewModel> ingredientes = new ArrayList<>();

    public RecetaCreateViewModel() {
        super();
    }

    public RecetaCreateViewModel(Long id, String nombre, String descripcion) {
        super(id, nombre);
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<IngredienteRecetaCreateViewModel> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteRecetaCreateViewModel> ingredientes) {
        this.ingredientes = ingredientes;
    }
}

