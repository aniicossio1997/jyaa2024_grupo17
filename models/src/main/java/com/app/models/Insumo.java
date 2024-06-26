package com.app.models;

import com.app.models.enums.UnidadMedidaEnum;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "insumo")
public class Insumo extends Recurso {
    @Transient
    public List<IngresoInsumo> ingresos = new ArrayList<>();

    public Insumo() {
        super();
    }

    public Insumo(String nombre, Double cantidadDisponible, String descripcion, UnidadMedidaEnum unidadMedida) {
        super(cantidadDisponible, descripcion, nombre, unidadMedida);
    }

    public Insumo(String nombre,  String descripcion, UnidadMedidaEnum unidadMedida) {
        super(0.0, descripcion, nombre, unidadMedida);
    }

    public List<IngresoInsumo> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<IngresoInsumo> ingresos) {
        this.ingresos = ingresos;
    }

    @Override
    public String toString() {
        return "{"
                + "\"id\":\"" + id + "\""
                + ", \"descripcion\":\"" + descripcion + "\""
                + ", \"unidadMedida\":\"" + unidadMedida + "\""
                + ", \"cantidadDisponible\":\"" + cantidadDisponible + "\""
                + ", \"nombre\":\"" + nombre + "\""
                + ", \"ingresos\":" + ingresos
                + "}";
    }
    public void addIngresoInsumo(IngresoInsumo entity){
        this.ingresos.add(entity);
    }
}
