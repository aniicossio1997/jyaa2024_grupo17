package com.app.viewModels;

import com.app.models.enums.UnidadMedidaEnum;
import com.app.viewModels.base.NameableViewModel;

public class RecursoViewModel extends NameableViewModel {
    public UnidadMedidaEnum unidadMedida;
    public Double totalCantidadDisponible;
    public Double totalValorCompra;


    public RecursoViewModel(Long id, String nombre,  UnidadMedidaEnum unidadMedida , Double totalCantidadDisponible, Double totalValorCompra) {
        super(id, nombre);
        this.totalCantidadDisponible = totalCantidadDisponible;
        this.totalValorCompra = totalValorCompra;
        this.unidadMedida = unidadMedida;
    }
}
