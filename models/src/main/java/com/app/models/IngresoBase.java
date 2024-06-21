package com.app.models;

import com.app.models.baseEntity.DeletableBaseEntity;
import com.app.models.baseEntity.IdentifiableBaseEntity;

import javax.persistence.MappedSuperclass;
import java.util.Date;
@MappedSuperclass
public class IngresoBase extends DeletableBaseEntity {
    protected Date fecha;
    protected String descripcion;
    protected double cantidad;
    protected String codigo;
    protected double valorCompra;

    public IngresoBase() {
        super();
    }

    public IngresoBase(double cantidad, String codigo, String descripcion, Date fecha, double valorCompra) {
        super();
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.valorCompra = valorCompra;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
