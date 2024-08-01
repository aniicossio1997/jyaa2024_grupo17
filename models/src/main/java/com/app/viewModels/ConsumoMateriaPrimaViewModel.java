package com.app.viewModels;

import com.app.models.enums.UnidadMedidaEnum;
import com.app.viewModels.base.IdentifiableViewModel;
import com.app.viewModels.base.NameableViewModel;

public class ConsumoMateriaPrimaViewModel extends IdentifiableViewModel {
    public Double cantidad;
    public UnidadMedidaEnum unidadMedida;
    public IngresoMateriaPrimaViewModel ingresoMateriaPrima;
    public Long elaboracionId;


    public ConsumoMateriaPrimaViewModel(Long id, Double cantidad, Long elaboracionId, IngresoMateriaPrimaViewModel ingresoMateriaPrima, UnidadMedidaEnum unidadMedida) {
        super(id);
        this.cantidad = cantidad;
        this.elaboracionId = elaboracionId;
        this.ingresoMateriaPrima = ingresoMateriaPrima;
        this.unidadMedida = unidadMedida;
    }

}

