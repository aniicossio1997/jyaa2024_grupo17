package com.app.viewModels;

import com.app.models.enums.UnidadMedidaEnum;

import java.util.ArrayList;
import java.util.List;

public class MateriaPrimaDetailViewModel extends  RecursoDetailViewModel{
    public List<IngresoMateriaPrimaShortViewModel> ingresos=new ArrayList<>();

    public MateriaPrimaDetailViewModel(Long id, String nombre, UnidadMedidaEnum unidadMedida, String descripcion, Double totalCantidadDisponible, Double totalValorCompra,
                                       List<IngresoMateriaPrimaShortViewModel> ingresos) {
        super(id, nombre, unidadMedida, descripcion, totalCantidadDisponible, totalValorCompra);
        this.ingresos = ingresos;
    }
}
