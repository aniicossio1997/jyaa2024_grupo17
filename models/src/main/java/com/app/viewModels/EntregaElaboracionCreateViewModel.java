package com.app.viewModels;


import com.app.viewModels.base.IdentifiableViewModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class EntregaElaboracionCreateViewModel {

    public long cantidad;
    public Long elaboracionId;
    public Long puntoVentaId;
    public Date fecha;
    public boolean updateState;
    @JsonIgnore
    public Long usuarioId;


    public EntregaElaboracionCreateViewModel() {
    }

    public EntregaElaboracionCreateViewModel(long cantidad, Long elaboracionId, Date fecha, Long puntoVentaId) {
        this.cantidad = cantidad;
        this.elaboracionId = elaboracionId;
        this.fecha = fecha;
        this.puntoVentaId = puntoVentaId;
    }

}

