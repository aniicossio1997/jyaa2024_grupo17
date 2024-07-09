package com.app.viewModels;

import com.app.models.enums.UnidadMedidaEnum;

import java.util.ArrayList;
import java.util.List;

public class InsumoDetailViewModel extends   RecursoDetailViewModel{
    public List<IngresoInsumoViewModel> ingresos=new ArrayList<>();
    


    public InsumoDetailViewModel(Long id, String nombre, UnidadMedidaEnum unidadMedida, String descripcion, Double totalCantidadDisponible, Double totalValorCompra, List<IngresoInsumoViewModel> ingresos) {
        super(id, nombre, unidadMedida, descripcion, totalCantidadDisponible, totalValorCompra);
        this.ingresos = ingresos;
    }
}
