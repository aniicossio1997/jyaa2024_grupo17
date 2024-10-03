package com.app.models;

import com.app.models.enums.UnidadMedidaEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "insumo")
public class Insumo extends Recurso {
    @OneToMany(mappedBy = "insumo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<IngresoInsumo> ingresos = new ArrayList<>();

    @OneToMany(mappedBy = "insumo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ConsumoInsumo> consumoInsumos = new ArrayList<>();

    public Insumo() {
        super();
    }

    public Insumo(String nombre, Double cantidadDisponible, String descripcion, UnidadMedidaEnum unidadMedida) {
        super(cantidadDisponible, descripcion, nombre, unidadMedida);
    }

    public Insumo(String nombre,  String descripcion, UnidadMedidaEnum unidadMedida) {
        super(0.0, descripcion, nombre, unidadMedida);
    }

    public List<IngresoInsumo> getIngresos() {
        return ingresos.stream()
                .filter(ingreso -> ingreso.getFechaBaja() == null)
                .sorted((i1, i2) -> i2.getId().compareTo(i1.getId()))
                .collect(Collectors.toList());
    }

    public void setIngresos(List<IngresoInsumo> ingresos) {
        this.ingresos = ingresos;
    }

    @Override
    public String toString() {
        return "{"
                + "\"id\":\"" + id + "\""
                + ", \"descripcion\":\"" + descripcion + "\""
                + ", \"unidadMedida\":\"" + unidadMedida + "\""
                + ", \"cantidadDisponible\":\"" + cantidadDisponible + "\""
                + ", \"nombre\":\"" + nombre + "\""
                + ", \"ingresos\":" + ingresos
                + "}";
    }
    public void addIngresoInsumo(IngresoInsumo entity){
        this.ingresos.add(entity);
    }

    public double getCantidadIngresos() {
        double ingresos = this.getIngresos().stream()
                .mapToDouble(IngresoInsumo::getCantidad)
                .sum();

        double egresos = consumoInsumos.stream()
                .mapToDouble(ConsumoInsumo::getCantidad)
                .sum();

        return ingresos - egresos;
    }
    public double getTotalValorDeCompra() {
        return getIngresos().stream()
                .mapToDouble(IngresoInsumo::getValorCompra)
                .sum();
    }
}
