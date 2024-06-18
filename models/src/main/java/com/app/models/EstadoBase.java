package com.app.models;

import com.app.models.baseEntity.IdentifiableBaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
public abstract class EstadoBase extends IdentifiableBaseEntity {
    protected Date fecha;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    protected Usuario autor;


    protected EstadoBase() {
        super();
    }

    public EstadoBase(Usuario autor, Date fecha) {
        this.autor = autor;
        this.fecha = fecha;
    }

    public EstadoBase(Usuario autor) {
        this.autor = autor;
        this.fecha = new Date();
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "EstadoBase{" +
                "autor=" + autor +
                ", fecha=" + fecha +
                ", id=" + id +
                '}';
    }
}
