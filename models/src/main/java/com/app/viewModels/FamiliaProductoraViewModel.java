package com.app.viewModels;

import com.app.viewModels.base.NameableViewModel;

public class FamiliaProductoraViewModel extends NameableViewModel {
    public String descripcion;



    public FamiliaProductoraViewModel(Long id, String nombre, String descripcion) {
        super(id, nombre);
        this.descripcion = descripcion;
    }
}
