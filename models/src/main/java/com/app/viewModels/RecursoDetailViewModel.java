package com.app.viewModels;

import com.app.models.enums.UnidadMedidaEnum;
import com.app.viewModels.base.NameableViewModel;

public class RecursoDetailViewModel extends NameableViewModel {
    public String descripcion;
    public UnidadMedidaEnum unidadMedida;
    public Double totalCantidadDisponible;
    public Double totalValorCompra;

    public RecursoDetailViewModel(Long id, String nombre) {
        super(id, nombre);
    }

    public RecursoDetailViewModel(Long id, String nombre,  UnidadMedidaEnum unidadMedida, String descripcion,
                                  Double totalCantidadDisponible, Double totalValorCompra) {
        super(id, nombre);
        this.totalCantidadDisponible = totalCantidadDisponible;
        this.unidadMedida = unidadMedida;
        this.descripcion = descripcion;
        this.totalValorCompra=totalValorCompra;
    }
}
