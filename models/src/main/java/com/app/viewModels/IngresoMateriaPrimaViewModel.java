package com.app.viewModels;

import com.app.models.EstadoMateriaPrima;
import com.app.models.MateriaPrima;
import com.app.utils.MappingUtils;
import com.app.viewModels.base.IdentifiableViewModel;
import com.app.viewModels.base.NameableViewModel;

import java.util.Date;

public class IngresoMateriaPrimaViewModel extends IdentifiableViewModel {
    public Date fecha;
    public String descripcion;
    public double cantidad;
    public String codigo;
    public double valorCompra;
    public NameableViewModel materiaPrima;
    public NameableViewModel familiaPrima;

    public NameableViewModel currentState;
    public IngresoMateriaPrimaViewModel(Long id) {
        super(id);
    }

    public IngresoMateriaPrimaViewModel(Long id, double valorCompra,
                                        MateriaPrima materiaPrima,
                                        Date fecha,
                                        NameableViewModel familiaPrima,
                                        String descripcion, String codigo, double cantidad, EstadoMateriaPrima estado) {
        super(id);
        this.valorCompra = valorCompra;
        this.materiaPrima = MappingUtils.toViewModel(materiaPrima);
        this.fecha = fecha;
        this.familiaPrima = familiaPrima;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.currentState= estado !=null ? (new NameableViewModel(estado.getId(),estado.getEstadoName())) : null;
    }
}
