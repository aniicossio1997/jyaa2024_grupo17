package com.app.viewModels;

import com.app.models.Insumo;
import com.app.models.MateriaPrima;
import com.app.models.Receta;
import com.app.viewModels.base.IdentifiableViewModel;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class IngredienteRecetaViewModel extends IdentifiableViewModel {
    Double cantidad;
    InsumoViewModel insumo;
    RecursoViewModel materiaPrima;

    public IngredienteRecetaViewModel(Long id, Double cantidad, InsumoViewModel insumo, RecursoViewModel materiaPrima) {
        super(id);
        this.cantidad = cantidad;
        this.insumo = insumo;
        this.materiaPrima = materiaPrima;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public InsumoViewModel getInsumo() {
        return insumo;
    }

    public void setInsumo(InsumoViewModel insumo) {
        this.insumo = insumo;
    }

    public RecursoViewModel getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(RecursoViewModel materiaPrima) {
        this.materiaPrima = materiaPrima;
    }
}
