package com.app.models;

import com.app.models.baseEntity.DeletableBaseEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "entrega_producto")
@SQLDelete(sql = "UPDATE nota SET fechaBaja = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "fechaBaja IS NULL")
public class EntregaProducto extends DeletableBaseEntity {
    private Double cantidad;
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "elaboracion_id")
    private Elaboracion elaboracion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "punto_venta_id")
    private PuntoVenta puntoVenta;

    public EntregaProducto() {
    }

    public EntregaProducto(Double cantidad, Elaboracion elaboracion, PuntoVenta puntoVenta) {
        this.cantidad = cantidad;
        this.elaboracion = elaboracion;
        this.fecha = new Date();
        this.puntoVenta = puntoVenta;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Elaboracion getElaboracion() {
        return elaboracion;
    }

    public void setElaboracion(Elaboracion elaboracion) {
        this.elaboracion = elaboracion;
    }

    public PuntoVenta getPuntoVenta() {
        return puntoVenta;
    }

    public void setPuntoVenta(PuntoVenta puntoVenta) {
        this.puntoVenta = puntoVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "{"
                + "\"id\":\"" + id + "\""
                + ", \"cantidad\":\"" + cantidad + "\""
                + ", \"elaboracion\":" + elaboracion.getId()
                + ", \"puntoVentaId\":" + puntoVenta.getId()
                + "}";
    }
}
