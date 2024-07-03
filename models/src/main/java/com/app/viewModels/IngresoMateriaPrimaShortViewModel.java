package com.app.viewModels;

import com.app.models.EstadoMateriaPrima;
import com.app.models.MateriaPrima;
import com.app.models.enums.EstadoMateriaPrimaEnum;
import com.app.viewModels.base.IdentifiableViewModel;
import com.app.viewModels.base.NameableViewModel;

import java.util.Date;
import java.util.List;

public class IngresoMateriaPrimaShortViewModel extends IngresoMateriaPrimaViewModel {



    public IngresoMateriaPrimaShortViewModel(Long id, double valorCompra, MateriaPrima materiaPrima, Date fecha, NameableViewModel familiaPrima, String descripcion, String codigo, double cantidad, EstadoMateriaPrima estado, List<EstadoViewModel> estados) {
        super(id, valorCompra, materiaPrima, fecha, familiaPrima, descripcion, codigo, cantidad, estado);

    }

}
