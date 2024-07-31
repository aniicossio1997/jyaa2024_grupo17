package com.app.viewModels;

import com.app.models.enums.EstadoMateriaPrimaEnum;

import java.util.Date;

public class IngresoMateriaPrimaUpdateViewModel {
    public String descripcion;
    public double cantidad;
    public String codigo;
    public double valorCompra;
    public Long materiaPrimaId;
    public Long familiaPrimaId;
    public EstadoMateriaPrimaEnum estado;
    public Date fecha;

    private Long usuarioId;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
