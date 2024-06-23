package com.app.models;

import com.app.models.enums.EstadoMateriaPrimaEnum;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "estado_materia_prima")
public class EstadoMateriaPrima  extends EstadoBase{
    public  EstadoMateriaPrimaEnum estado;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingreso_materia_prima_id")
    private IngresoMateriaPrima ingresoMateriaPrima;


    public EstadoMateriaPrima() {
        super();
    }

    public EstadoMateriaPrima(Usuario autor, Date fecha, EstadoMateriaPrimaEnum estado, IngresoMateriaPrima ingresoMateriaPrima) {
        super(autor, fecha);
        this.estado = estado;
        this.ingresoMateriaPrima = ingresoMateriaPrima;

    }
    public EstadoMateriaPrima(Usuario autor, Date fecha, EstadoMateriaPrimaEnum estado) {
        super(autor, fecha);
        this.estado = estado;
    }
    public EstadoMateriaPrima(Usuario autor,  EstadoMateriaPrimaEnum estado) {
        super(autor, new Date());
        this.estado = estado;
    }
    public EstadoMateriaPrimaEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoMateriaPrimaEnum estado) {
        this.estado = estado;
    }





    @Override
    public String toString() {
        return "{"
                + ", \"id\":\"" + id + "\""
                + "\"estado\":\"" + estado + "\""
                + ", \"autorId\":" + autor.getId()
                + ", \"fecha\":" + fecha
                + "}";
    }
}
