package com.app.models;

import com.app.models.baseEntity.DeletableWithNameBaseEntity;
import com.app.models.baseEntity.IdentifiableBaseEntity;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "punto_venta")
@SQLDelete(sql = "UPDATE nota SET fechaBaja = CURRENT_TIMESTAMP WHERE id = ?")
public class PuntoVenta  extends DeletableWithNameBaseEntity {
    public String descripcion;
    @Transient
    public List<EntregaProducto> recepciones = new ArrayList<>();

    public PuntoVenta() {
        super();
    }

    public PuntoVenta(String nombre, String descripcion) {
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<EntregaProducto> getRecepciones() {
        return recepciones;
    }

    public void setRecepciones(List<EntregaProducto> recepciones) {
        this.recepciones = recepciones;
    }

    @Override
    public String toString() {
        return "{"
                + "\"nombre\":\"" + nombre + "\""
                + ", \"descripcion\":\"" + descripcion + "\""
                + ", \"recepciones\":" + recepciones
                + ", \"id\":\"" + id + "\""
                + "}";
    }
}
