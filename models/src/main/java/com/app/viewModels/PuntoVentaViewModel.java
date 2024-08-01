package com.app.viewModels;

import com.app.viewModels.base.NameableViewModel;

public class PuntoVentaViewModel extends NameableViewModel {
    public String descripcion;

    public PuntoVentaViewModel(Long id, String nombre, String descripcion) {
        super(id, nombre);
        this.descripcion = descripcion;
    }
}
