package com.app.viewModels;


import com.app.viewModels.base.IdentifiableViewModel;

import java.util.Date;

public class NotaCreateViewModel  {
    public String descripcion;
    public Long elaboracionId;

    public NotaCreateViewModel(String descripcion, Long elaboracionId) {
        this.descripcion = descripcion;
        this.elaboracionId = elaboracionId;
    }

    public NotaCreateViewModel() {
    }
}

