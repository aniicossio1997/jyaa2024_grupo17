package com.app.models;

import com.app.models.baseEntity.DeletableBaseEntity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "elaboracion")
public class Elaboracion extends DeletableBaseEntity {
    private Date fecha;
    private String codigo;
    private int cantidad;

    @OneToMany(mappedBy = "elaboracion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EstadoElaboracion> estados = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receta_id")
    private Receta receta;

    @OneToMany(mappedBy = "elaboracion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ConsumoInsumo> consumoInsumos = new ArrayList<>();

    @OneToMany(mappedBy = "elaboracion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ConsumoMateriaPrima> consumoMateriasPrimas = new ArrayList<>();

    @OneToMany(mappedBy = "elaboracion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Nota> notas = new ArrayList<>();

    @OneToMany(mappedBy = "elaboracion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EntregaProducto> entregas = new ArrayList<>();

    public Elaboracion() {
        super();
    }

    public Elaboracion(int cantidad, String codigo, Date fecha, Receta receta) {
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.fecha = fecha;
        this.receta = receta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<ConsumoInsumo> getConsumoInsumos() {
        return consumoInsumos;
    }

    public void setConsumoInsumos(List<ConsumoInsumo> consumos) {
        this.consumoInsumos = consumos;
    }

    public List<ConsumoMateriaPrima> getConsumoMateriasPrimas() {
        return consumoMateriasPrimas;
    }

    public void setConsumoMateriasPrimas(List<ConsumoMateriaPrima> consumoMateriasPrimas) {
        this.consumoMateriasPrimas = consumoMateriasPrimas;
    }

    public List<EntregaProducto> getEntregas() {
        return entregas;
    }

    public void setEntregas(List<EntregaProducto> entregas) {
        this.entregas = entregas;
    }

    public List<EstadoElaboracion> getEstados() {
        return estados;
    }

    public EstadoElaboracion getEstadoActual() {
        return estados.stream()
                .max(Comparator.comparing(EstadoElaboracion::getFecha)).orElse(null);
    }

    public Usuario getAutor() {
        return Optional.ofNullable(estados.get(0)).map(EstadoBase::getAutor).orElse(null);
    }

    public void updateEstado(EstadoElaboracion estado) {
        this.estados.add(estado);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    @Override
    public String toString() {
        return "{"
                + "\"id\":\"" + id + "\""
                + ", \"cantidad\":\"" + cantidad + "\""
                + ", \"fecha\":" + fecha
                + ", \"codigo\":\"" + codigo + "\""
                + ", \"estados\":" + estados
                + ", \"recetaId\":" + receta.getId()
                + ", \"consumosInsumos\":" + consumoInsumos
                + ", \"notas\":" + notas
                + ", \"entregas\":" + entregas
                + "}";
    }
}
