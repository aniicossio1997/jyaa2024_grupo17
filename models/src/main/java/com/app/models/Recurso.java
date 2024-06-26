package com.app.models;

import com.app.models.baseEntity.DeletableWithNameBaseEntity;
import com.app.models.baseEntity.NameableBaseEntity;
import com.app.models.enums.UnidadMedidaEnum;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.MappedSuperclass;
@MappedSuperclass
@SQLDelete(sql = "UPDATE nota SET fechaBaja = CURRENT_TIMESTAMP WHERE id = ?")
public class Recurso extends DeletableWithNameBaseEntity {

    public String descripcion;
    public UnidadMedidaEnum unidadMedida;
    public Double cantidadDisponible;

    public Recurso() {
        super();
    }

    public Recurso(Double cantidadDisponible, String descripcion, String nombre, UnidadMedidaEnum unidadMedida) {
        super(nombre);
        this.cantidadDisponible = cantidadDisponible;
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
    }

    public Recurso(String nombre, UnidadMedidaEnum unidadMedida,
                        String descripcion) {
        super(nombre);
        this.cantidadDisponible = 0.0;
        this.descripcion = descripcion;
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

    @Override
    public String toString() {
        return "{" +
                "id=" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidadDisponible='" + cantidadDisponible + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", unidadMedida=" + unidadMedida +

                '}';
    }
}
