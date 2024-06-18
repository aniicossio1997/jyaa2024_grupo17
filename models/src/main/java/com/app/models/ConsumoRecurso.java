package com.app.models;

import com.app.models.baseEntity.IdentifiableBaseEntity;

import javax.persistence.*;

@MappedSuperclass
public abstract class ConsumoRecurso extends IdentifiableBaseEntity {
    protected Double cantidad;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lote_producto_elaborado_id")
    protected LoteProductoElaborado lote;

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

    public LoteProductoElaborado getLote() {
        return lote;
    }

    public void setLote(LoteProductoElaborado lote) {
        this.lote = lote;
    }
}