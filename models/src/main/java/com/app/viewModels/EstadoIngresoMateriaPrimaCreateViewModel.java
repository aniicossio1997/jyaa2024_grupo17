package com.app.viewModels;

import com.app.models.enums.EstadoMateriaPrimaEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class EstadoIngresoMateriaPrimaCreateViewModel {
    protected Long autorId;
    public EstadoMateriaPrimaEnum estado;
    public Long ingresoMateriaPrimaId;
    @JsonIgnore
    public  Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
