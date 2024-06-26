package com.app.models;

import com.app.models.enums.UnidadMedidaEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "materia_prima")
public class MateriaPrima extends Recurso {
    @OneToMany(mappedBy = "materiaPrima", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<IngresoMateriaPrima> ingresos = new ArrayList<>();


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
        return ingresos;
    }

    public double getCantidadIngresos() {
        return ingresos.stream()
                .mapToDouble(IngresoMateriaPrima::getCantidad)
                .sum();
    }
    public double getTotalValorDeCompra() {
        return ingresos.stream()
                .mapToDouble(IngresoMateriaPrima::getValorCompra)
                .sum();
    }
}
