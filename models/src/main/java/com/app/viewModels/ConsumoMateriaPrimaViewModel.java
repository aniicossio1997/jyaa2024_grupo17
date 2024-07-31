package com.app.viewModels;

import com.app.viewModels.base.IdentifiableViewModel;
import com.app.viewModels.base.NameableViewModel;

public class ConsumoMateriaPrimaViewModel extends IdentifiableViewModel {
    public Double cantidad;
    public RecursoViewModel materiaPrima;
    public Long elaboracionId;


    public ConsumoMateriaPrimaViewModel(Long id, Double cantidad, Long elaboracionId, RecursoViewModel materiaPrima) {
        super(id);
        this.cantidad = cantidad;
        this.elaboracionId = elaboracionId;
        this.materiaPrima = materiaPrima;
    }

}

