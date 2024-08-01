package com.app.viewModels;

import com.app.models.enums.EstadoElaboracionEnum;

import java.util.Date;

public class EstadoElaboracionCreateViewModel {
    public EstadoElaboracionEnum estado;
    public Date fecha = new Date();
    public Long elaboracionId;
    public Long usuarioId;

    public EstadoElaboracionCreateViewModel() {
    }
}
