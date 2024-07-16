package com.app.models;

import com.app.models.enums.EstadoElaboracionEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "estado_elaboracion")
public class EstadoElaboracion extends EstadoBase {
    private EstadoElaboracionEnum estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "elaboracion_id")
    private Elaboracion elaboracion;


    public EstadoElaboracion() {
        super();
    }

    public EstadoElaboracion(Usuario autor, Date fecha, EstadoElaboracionEnum estado, Elaboracion elaboracion) {
        super(autor, fecha);
        this.estado = estado;
        this.elaboracion = elaboracion;
    }

    public EstadoElaboracionEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoElaboracionEnum estado) {
        this.estado = estado;
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
                + ", \"id\":\"" + id + "\""
                + "\"estado\":\"" + estado.getValue() + "\""
                + ", \"autorId\":" + autor.getId()
                + ", \"elaboracionId\":" + elaboracion.getId()
                + ", \"fecha\":" + fecha
                + "}";
    }
}
