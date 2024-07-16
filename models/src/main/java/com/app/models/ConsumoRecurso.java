package com.app.models;

import com.app.models.baseEntity.IdentifiableBaseEntity;

import javax.persistence.*;

@MappedSuperclass
public abstract class ConsumoRecurso extends IdentifiableBaseEntity {
    protected Double cantidad;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "elaboracion_id")
    protected Elaboracion elaboracion;

    public ConsumoRecurso() {
        super();
    }

    public ConsumoRecurso(Double cantidad) {
        this.cantidad = cantidad;
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
}
