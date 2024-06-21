package com.app.viewModels;

import com.app.models.enums.UnidadMedidaEnum;
import com.app.viewModels.base.NameableViewModel;

public class InsumoViewModel extends NameableViewModel {
    public UnidadMedidaEnum unidadMedida;
    public Double cantidadDisponible;
    public String descripcion;

    public InsumoViewModel(Long id, String nombre) {
        super(id, nombre);
    }

    public InsumoViewModel(Long id, String nombre, Double cantidadDisponible, UnidadMedidaEnum unidadMedida, String descripcion) {
        super(id, nombre);
        this.cantidadDisponible = cantidadDisponible;
        this.unidadMedida = unidadMedida;
        this.descripcion = descripcion;
    }
}
