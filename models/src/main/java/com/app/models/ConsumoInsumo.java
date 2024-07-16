package com.app.models;

import javax.persistence.*;

@Entity
@Table(name = "consumo_insumo")
public class ConsumoInsumo extends ConsumoRecurso {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insumo_id")
    private Insumo insumo;

    public ConsumoInsumo() {
        super();
    }

    public ConsumoInsumo(Double cantidad, Insumo insumo, Elaboracion elaboracion) {
        super(cantidad);
        this.insumo = insumo;
        this.elaboracion = elaboracion;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Elaboracion getElaboracion() {
        return elaboracion;
    }

    public void setElaboracion(Elaboracion elaboracion) {
        this.elaboracion = elaboracion;
    }

    @Override
    public String toString() {
        return "{"
                + " \"id\":\"" + id + "\""
                + ", \"insumoId\":" + insumo.getId()
                + ", \"elaboracionId\":" + elaboracion.getId()
                + ", \"cantidad\":\"" + cantidad + "\""
                + "}";
    }
}
