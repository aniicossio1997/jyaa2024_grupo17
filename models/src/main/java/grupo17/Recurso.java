package grupo17;

import grupo17.enums.UnidadMedidaEnum;

import java.util.ArrayList;
import java.util.List;

public class Recurso {
    String nombre;
    String descripcion;
    UnidadMedidaEnum unidadMedida;
    Double cantidadDisponible;

    public Recurso() {
        super();
    }

    public Recurso(Double cantidadDisponible, String descripcion, String nombre, UnidadMedidaEnum unidadMedida) {
        this.cantidadDisponible = cantidadDisponible;
        this.descripcion = descripcion;
        this.nombre = nombre;
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

    public UnidadMedidaEnum getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedidaEnum unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Double getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Double cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
}
