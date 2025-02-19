package com.app.models;

import javax.persistence.*;

@Entity
@Table(name = "consumo_materia_prima")
public class ConsumoMateriaPrima extends ConsumoRecurso {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingreso_materia_prima_id")
    private IngresoMateriaPrima ingreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "materia_prima_id")
    private MateriaPrima materiaPrima;

    public ConsumoMateriaPrima() {
        super();
    }

    public ConsumoMateriaPrima(Double cantidad, IngresoMateriaPrima ingreso, Elaboracion elaboracion) {
        super(cantidad);
        this.ingreso = ingreso;
        this.materiaPrima = ingreso.getMateriaPrima();
        this.elaboracion = elaboracion;
    }

    public IngresoMateriaPrima getIngreso() {
        return ingreso;
    }

    public void setIngreso(IngresoMateriaPrima ingreso) {
        this.ingreso = ingreso;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    @Override
    public String toString() {
        return "{"
                + " \"id\":\"" + id + "\""
                + ", \"materiaPrimaId\":" + materiaPrima.getId()
                + ", \"ingresoMateriaPrimaId\":" + ingreso.getId()
                + ", \"elaboracionId\":" + elaboracion.getId()
                + ", \"cantidad\":\"" + cantidad + "\""
                + "}";
    }
}
