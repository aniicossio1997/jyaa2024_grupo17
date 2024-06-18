package com.app.models;

import com.app.models.baseEntity.IdentifiableBaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ingreso_insumo")
public class IngresoInsumo extends IdentifiableBaseEntity {
    protected Date fecha;
    protected String descripcion;
    protected double cantidad;
    protected String codigo;
    protected double valorCompra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insumo_id")
    protected Insumo insumo;

    public IngresoInsumo() {
    }

    // Constructor
    public IngresoInsumo(Insumo insumo, Date fecha, String descripcion, double cantidad, String codigo, double valorCompra) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.valorCompra = valorCompra;
        this.insumo = insumo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    @Override
    public String toString() {
        return "{"
                + "\"id\":\"" + id + "\""
                + ",\"fecha\":" + fecha
                + ", \"descripcion\":\"" + descripcion + "\""
                + ", \"cantidad\":\"" + cantidad + "\""
                + ", \"codigo\":\"" + codigo + "\""
                + ", \"valorCompra\":\"" + valorCompra + "\""
                + ", \"insumoId\":" + insumo.getId()
                + "}";
    }
}
