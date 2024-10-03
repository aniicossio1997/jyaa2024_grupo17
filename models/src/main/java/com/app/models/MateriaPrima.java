package com.app.models;

import com.app.models.enums.UnidadMedidaEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "materia_prima")
public class MateriaPrima extends Recurso {
    @OneToMany(mappedBy = "materiaPrima", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<IngresoMateriaPrima> ingresos = new ArrayList<>();

    @OneToMany(mappedBy = "materiaPrima", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ConsumoMateriaPrima> consumos = new ArrayList<>();

    public MateriaPrima(String nombre, UnidadMedidaEnum unidadMedida,
                        String descripcion)  {
        super(nombre,  unidadMedida, descripcion);

    }
    public MateriaPrima(String nombre, UnidadMedidaEnum unidadMedida,
                        Double cantidadDisponible, String descripcion,
                        List<IngresoMateriaPrima> ingresos) {
        super(cantidadDisponible, descripcion, nombre, unidadMedida);
        this.ingresos = ingresos;
    }

    public  MateriaPrima(){
        super();
    }
    public MateriaPrima(
             String nombre, String descripcion,UnidadMedidaEnum unidadMedida,
            Double cantidadDisponible) {
        super(cantidadDisponible, descripcion, nombre, unidadMedida);
    }

    public void addIngreso(IngresoMateriaPrima ingresoMateriaPrima) {
        this.ingresos.add(ingresoMateriaPrima);
    }

    @Override
    public String toString() {
        return "Materia Prima" + super.toString();
    }

    public List<IngresoMateriaPrima> getIngresos() {
        return ingresos.stream()
                .filter(ingreso -> ingreso.getFechaBaja() == null)
                .sorted((i1, i2) -> i2.getId().compareTo(i1.getId()))
                .collect(Collectors.toList());
    }
    public List<IngresoMateriaPrima> getIngresosConBajas() {
        return ingresos;
    }

    public double getCantidadIngresos() {
        double ingresos = this.getIngresos().stream()
                .mapToDouble(IngresoMateriaPrima::getCantidad)
                .sum();

        double egresos = consumos.stream()
                .mapToDouble(ConsumoMateriaPrima::getCantidad)
                .sum();

        return ingresos - egresos;
    }
    public double getTotalValorDeCompra() {
        return this.getIngresos().stream()
                .mapToDouble(IngresoMateriaPrima::getValorCompra)
                .sum();
    }
}
