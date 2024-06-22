package com.app.models;

import com.app.models.baseEntity.IdentifiableBaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "receta")
public class Receta extends IdentifiableBaseEntity {
    public String nombre;
    public String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    public Usuario autor;

    @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public List<IngredienteReceta> ingredientes = new ArrayList<>();

    @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public List<LoteProductoElaborado> elaboraciones = new ArrayList<>();

    public Receta() {
        super();
    }

    public Receta(String nombre, String descripcion, List<IngredienteReceta> ingredientes, Usuario autor) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.descripcion = descripcion;
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<LoteProductoElaborado> getElaboraciones() {
        return elaboraciones;
    }

    public void setElaboraciones(List<LoteProductoElaborado> elaboraciones) {
        this.elaboraciones = elaboraciones;
    }

    public List<IngredienteReceta> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteReceta> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void addIngrediente(IngredienteReceta ingrediente) {
        ingredientes.add(ingrediente);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Usuario getAutor() {
        return autor;
    }


    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "{"
                + "\"id\":\"" + id + "\""
                + ", \"descripcion\":\"" + descripcion + "\""
                + ", \"nombre\":\"" + nombre + "\""
                + ", \"ingredientes\":" + ingredientes
                + ", \"elaboraciones\":" + elaboraciones
                + "}";
    }
}
