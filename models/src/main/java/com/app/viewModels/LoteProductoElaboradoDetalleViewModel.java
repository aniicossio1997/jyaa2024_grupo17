package com.app.viewModels;


import com.app.models.EstadoLote;
import com.app.viewModels.base.IdentifiableViewModel;

import java.util.Date;
import java.util.List;

public class LoteProductoElaboradoDetalleViewModel extends IdentifiableViewModel {
    public Date fecha;
    public String codigo;
    public long cantidad;
    public List<EstadoLote> estados;
    public EstadoLote estado;
    public RecetaViewModel receta;

    public LoteProductoElaboradoDetalleViewModel(Long id, long cantidad, String codigo, EstadoLote estado, List<EstadoLote> estados, Date fecha, RecetaViewModel receta) {
        super(id);
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.estado = estado;
        this.estados = estados;
        this.fecha = fecha;
        this.receta = receta;
    }

    public LoteProductoElaboradoDetalleViewModel() {
    }
}

