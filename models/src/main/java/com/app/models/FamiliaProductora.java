package com.app.models;

import com.app.models.baseEntity.NameableBaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "familia_productora")
public class FamiliaProductora extends NameableBaseEntity {
    private String descripcion;

    public FamiliaProductora() {
        super();
    }

    public FamiliaProductora(String nombre, String descripcion) {
        super(nombre);
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "{"
                + "\"id\":\"" + id + "\""
                + ", \"descripcion\":\"" + descripcion + "\""
                + ", \"nombre\":\"" + nombre + "\""
                + "}";
    }
}
