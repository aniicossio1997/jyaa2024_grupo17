package com.app.viewModels;

import com.app.models.enums.UnidadMedidaEnum;

public class RecursoPostViewModel {
    public String nombre;
    public UnidadMedidaEnum unidadMedida;
    public String descripcion;

    public RecursoPostViewModel() {
    }

    public RecursoPostViewModel(Double cantidadDisponible, String descripcion, String nombre, UnidadMedidaEnum unidadMedida) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
    }





    public UnidadMedidaEnum getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedidaEnum unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
