package com.app.models;

import com.app.models.baseEntity.DeletableBaseEntity;
import com.app.models.baseEntity.DeletableWithNameBaseEntity;
import com.app.models.baseEntity.NameableBaseEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "familia_productora")
@SQLDelete(sql = "UPDATE nota SET fechaBaja = CURRENT_TIMESTAMP WHERE id = ?")
public class FamiliaProductora extends DeletableWithNameBaseEntity {
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
