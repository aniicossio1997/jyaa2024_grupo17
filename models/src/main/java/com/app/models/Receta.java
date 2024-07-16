package com.app.models;

import com.app.models.baseEntity.DeletableBaseEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "receta")
@SQLDelete(sql = "UPDATE receta SET fechaBaja = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "fechaBaja IS NULL")
public class Receta extends DeletableBaseEntity {
    public String nombre;
    public String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    public Usuario autor;

    @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public List<IngredienteReceta> ingredientes = new ArrayList<>();

    @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public List<Elaboracion> elaboraciones = new ArrayList<>();

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

    public List<Elaboracion> getElaboraciones() {
        return elaboraciones;
    }

    public void setElaboraciones(List<Elaboracion> elaboraciones) {
        this.elaboraciones = elaboraciones;
    }

    public List<IngredienteReceta> getIngredientes() {
        return ingredientes.stream()
                .filter(ingreso -> ingreso.getFechaBaja() == null)
                .sorted((i1, i2) -> i2.getId().compareTo(i1.getId()))
                .collect(Collectors.toList());
    }

    public List<IngredienteReceta> getMateriasPrimas() {
        return ingredientes.stream()
                .filter(i -> i.getFechaBaja() == null && i.getMateriaPrima() != null)
                .collect(Collectors.toList());
    }

    public List<IngredienteReceta> getInsumos() {
        return ingredientes.stream()
                .filter(i -> i.getFechaBaja() == null && i.getInsumo() != null)
                .collect(Collectors.toList());
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
