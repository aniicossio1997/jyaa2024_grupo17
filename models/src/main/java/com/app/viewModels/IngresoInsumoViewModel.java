package com.app.viewModels;

import com.app.models.Insumo;
import com.app.models.MateriaPrima;
import com.app.models.enums.UnidadMedidaEnum;
import com.app.utils.MappingUtils;
import com.app.viewModels.base.IdentifiableViewModel;
import com.app.viewModels.base.NameableViewModel;

import java.util.Date;

public class IngresoInsumoViewModel extends IdentifiableViewModel {
    public Date fecha;
    public String descripcion;
    public double cantidad;
    public String codigo;
    public double valorCompra;
    public NameableViewModel insumo;
    public UnidadMedidaEnum unidadMedida;

    public IngresoInsumoViewModel(Long id) {
        super(id);
    }

    public IngresoInsumoViewModel(Long id, double valorCompra,
                                  Date fecha, Insumo insumo, String descripcion, String codigo,
                                  double cantidad, UnidadMedidaEnum unidadMedida) {
        super(id);
        this.valorCompra = valorCompra;
        this.insumo = MappingUtils.toViewModel(insumo);
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.unidadMedida=unidadMedida;
    }
}
