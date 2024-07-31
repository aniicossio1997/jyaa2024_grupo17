package com.app.viewModels;

import com.app.models.enums.EstadoMateriaPrimaEnum;

public class EstadoIngresoMateriaPrimaCreateViewModel {
    protected Long autorId;
    public EstadoMateriaPrimaEnum estado;
    public Long ingresoMateriaPrimaId;
    private  Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
