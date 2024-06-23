package com.app.models;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ingreso_materia_prima")
@SQLDelete(sql = "UPDATE ingreso_materia_prima SET fechaBaja = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "fechaBaja IS NULL")
public class IngresoMateriaPrima extends IngresoBase {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "familia_productora_id")
    private FamiliaProductora familiaProductora;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "materia_prima_id")
    private MateriaPrima materiaPrima;

    @OneToMany(mappedBy = "ingresoMateriaPrima", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public List<EstadoMateriaPrima> estados = new ArrayList<>();

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @OneToMany(mappedBy = "ingreso", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public List<ConsumoMateriaPrima> consumoMateriaPrimas = new ArrayList<>();

    public IngresoMateriaPrima() {
        super();
    }

    public List<ConsumoMateriaPrima> getConsumoMateriaPrimas() {
        return consumoMateriaPrimas;
    }

    public void setConsumoMateriaPrimas(List<ConsumoMateriaPrima> consumoMateriaPrimas) {
        this.consumoMateriaPrimas = consumoMateriaPrimas;
    }

    public IngresoMateriaPrima(double cantidad, String codigo, String descripcion, Date fecha, double valorCompra, List<EstadoMateriaPrima> estados, MateriaPrima materiaPrima, FamiliaProductora productor) {
        super(cantidad, codigo, descripcion, fecha, valorCompra);
        this.estados = estados;
        this.materiaPrima = materiaPrima;
        this.familiaProductora = productor;
        this.isDeleted = false;
    }

    public IngresoMateriaPrima(double cantidad, String codigo, String descripcion, Date fecha, double valorCompra,
                               MateriaPrima materiaPrima, FamiliaProductora productor) {
        super(cantidad, codigo, descripcion, fecha, valorCompra);
        this.materiaPrima = materiaPrima;
        this.familiaProductora = productor;
        this.isDeleted = false;

    }
    public IngresoMateriaPrima(double cantidad, String codigo, String descripcion, Date fecha, double valorCompra
                               ) {
        super(cantidad, codigo, descripcion, fecha, valorCompra);

        this.isDeleted = false;
    }
    public IngresoMateriaPrima(EstadoMateriaPrima estado,double cantidad, String codigo, String descripcion, Date fecha, double valorCompra
    ) {

        super(cantidad, codigo, descripcion, fecha, valorCompra);
        this.estados.add(estado);
        this.isDeleted = false;
    }


    public void updateEstado(EstadoMateriaPrima estado) {
        this.estados.add(estado);
    }

    public IngresoMateriaPrima(MateriaPrima materiaPrima, List<EstadoMateriaPrima> estados, FamiliaProductora productor) {
        super();
        this.materiaPrima = materiaPrima;
        this.estados = estados;
        this.familiaProductora = productor;
    }

    public List<EstadoMateriaPrima> getEstados() {
        return estados;
    }

    public EstadoMateriaPrima getEstadoActual() {
        return estados.stream()
                .max(Comparator.comparingLong(EstadoMateriaPrima::getId)).orElse(null);
    }

    public void setEstados(List<EstadoMateriaPrima> estados) {
        this.estados = estados;
    }

    public FamiliaProductora getProductor() {
        return this.familiaProductora;
    }

    public void setProductor(FamiliaProductora productor) {
        this.familiaProductora = productor;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "{"
                + "\"estado\":" + getEstadoActual()
                + ", \"familiaProductoraId\":" + familiaProductora.getId()
                + ", \"materiaPrimaId\":" + materiaPrima.getId()
                + ", \"cantidad\":\"" + cantidad + "\""
                + ", \"codigo\":\"" + codigo + "\""
                + ", \"descripcion\":\"" + descripcion + "\""
                + ", \"fecha\":" + fecha
                + ", \"valorCompra\":\"" + valorCompra + "\""
                + ", \"id\":\"" + id + "\""
                + "}";
    }
    public void addEstado(EstadoMateriaPrima estado) {
        this.estados.add(estado);
    }

}
