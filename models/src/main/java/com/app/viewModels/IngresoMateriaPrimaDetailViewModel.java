package com.app.viewModels;

import com.app.models.EstadoMateriaPrima;
import com.app.models.MateriaPrima;
import com.app.models.enums.UnidadMedidaEnum;
import com.app.viewModels.base.NameableViewModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IngresoMateriaPrimaDetailViewModel  extends IngresoMateriaPrimaViewModel{
    public List<EstadoViewModel> estados = new ArrayList<>();

    public UnidadMedidaEnum unidadMedida;


    public IngresoMateriaPrimaDetailViewModel(Long id, double valorCompra, MateriaPrima materiaPrima, Date fecha, NameableViewModel familiaPrima, String descripcion, String codigo, double cantidad, EstadoMateriaPrima estado) {
        super(id, valorCompra, materiaPrima, fecha, familiaPrima, descripcion, codigo, cantidad, estado);
    }



    public IngresoMateriaPrimaDetailViewModel(Long id, double valorCompra, MateriaPrima materiaPrima, Date fecha,
                                              NameableViewModel familiaPrima, String descripcion, String codigo,
                                              double cantidad, EstadoMateriaPrima estado,
                                              List<EstadoViewModel> estados,UnidadMedidaEnum unidadMedida) {
        super(id, valorCompra, materiaPrima, fecha, familiaPrima, descripcion, codigo, cantidad, estado);
        this.estados = estados;
        this.unidadMedida=unidadMedida;
    }

    public List<EstadoViewModel> getEstados() {
        return estados;
    }
}
