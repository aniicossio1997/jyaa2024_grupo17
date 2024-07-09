package com.app.utils;

import com.app.exceptions.InvalidParameterException;
import com.app.models.IngresoInsumo;
import com.app.models.IngresoMateriaPrima;
import com.app.models.baseEntity.NameableBaseEntity;
import com.app.viewModels.EstadoViewModel;
import com.app.viewModels.IngresoInsumoViewModel;
import com.app.viewModels.IngresoMateriaPrimaShortViewModel;
import com.app.viewModels.base.NameableViewModel;

import java.util.List;
import java.util.stream.Collectors;

public class MappingUtils {
    public  static NameableViewModel toViewModel(NameableBaseEntity nameableBaseEntity){
        return new NameableViewModel(nameableBaseEntity.getId(),nameableBaseEntity.getNombre());
    }
    public  static IngresoMateriaPrimaShortViewModel toViewModelDetails(IngresoMateriaPrima imp) {

        List<EstadoViewModel> estadoViewModels = imp.getEstadosOrderById().stream()
                .map(e -> {
                    if (e == null || e.getAutor() == null) {
                        throw new InvalidParameterException("Estado or its Autor cannot be null.");
                    }
                    return new EstadoViewModel(
                            e.getId(),
                            new NameableViewModel(e.getAutor().getId(), e.getAutor().getNombre() + " " + e.getAutor().getApellido()),
                            e.getEstadoName(),
                            e.getFecha()
                    );
                })
                .collect(Collectors.toList());

        IngresoMateriaPrimaShortViewModel entity = new IngresoMateriaPrimaShortViewModel(
                imp.getId(),
                imp.getValorCompra(),
                imp.getMateriaPrima(),
                imp.getFecha(),
                MappingUtils.toViewModel(imp.getProductor()),
                imp.getDescripcion(),
                imp.getCodigo(),
                imp.getCantidad(),
                imp.getEstadoActual(),
                estadoViewModels
        );

        return entity;
    }
    public  static IngresoInsumoViewModel toViewModelDetails(IngresoInsumo imp){
        IngresoInsumoViewModel entity = new IngresoInsumoViewModel(
                imp.getId(),imp.getValorCompra(),
                imp.getFecha(),imp.getInsumo(), imp.getDescripcion(),
                imp.getCodigo(), imp.getCantidad(),
                imp.getInsumo().getUnidadMedida()
        );

        return entity;
    }
}
