package com.app.viewModels;


import com.app.models.EstadoLote;
import com.app.viewModels.base.IdentifiableViewModel;
import com.app.viewModels.base.NameableViewModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class LoteProductoElaboradoViewModel extends IdentifiableViewModel {

    public long cantidad;
    public String codigo;
    public Date fecha;
    public long recetaId;
    public EstadoLote estado;

    public LoteProductoElaboradoViewModel() {
    }

    public LoteProductoElaboradoViewModel(Long id, long cantidad, String codigo, EstadoLote estado, Date fecha, long recetaId) {
        super(id);
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.estado = estado;
        this.fecha = fecha;
        this.recetaId = recetaId;
    }
}

