package com.app.viewModels;


import com.app.viewModels.base.IdentifiableViewModel;

import java.util.Date;
import java.util.List;

public class ElaboracionDetalleViewModel extends IdentifiableViewModel {
    public Date fecha;
    public String codigo;
    public long cantidad;
    public List<EstadoViewModel> estados;
    public EstadoViewModel estado;
    public RecetaViewModel receta;

    public ElaboracionDetalleViewModel(Long id, long cantidad, String codigo, EstadoViewModel estado, List<EstadoViewModel> estados, Date fecha, RecetaViewModel receta) {
        super(id);
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.estado = estado;
        this.estados = estados;
        this.fecha = fecha;
        this.receta = receta;
    }

    public ElaboracionDetalleViewModel() {
    }
}

