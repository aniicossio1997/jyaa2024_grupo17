package com.app.viewModels;

import com.app.viewModels.base.IdentifiableViewModel;

public class ConsumoInsumoViewModel extends IdentifiableViewModel {
    public Double cantidad;
    public InsumoViewModel insumo;
    public Long elaboracionId;

    public ConsumoInsumoViewModel(Long id, Double cantidad, Long elaboracionId, InsumoViewModel insumo) {
        super(id);
        this.cantidad = cantidad;
        this.elaboracionId = elaboracionId;
        this.insumo = insumo;
    }
}

