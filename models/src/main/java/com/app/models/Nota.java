package com.app.models;

import com.app.models.baseEntity.DeletableBaseEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nota")
@SQLDelete(sql = "UPDATE nota SET fechaBaja = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "fechaBaja IS NULL")
public class Nota extends DeletableBaseEntity {
    private Date fecha;

    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "elaboracion_id")
    private Elaboracion elaboracion;

    public Nota() {
        super();
    }

    public Nota(Usuario autor, String descripcion, Elaboracion elaboracion) {
        this.autor = autor;
        this.fecha = new Date();
        this.elaboracion = elaboracion;
        this.descripcion = descripcion;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
                + ", \"autorId\":" + autor.getId()
                + ", \"fecha\":" + fecha
                + ", \"descripcion\":\"" + descripcion + "\""
                + ", \"elaboracionId\":" + elaboracion.getId()
                + "}";
    }
}
