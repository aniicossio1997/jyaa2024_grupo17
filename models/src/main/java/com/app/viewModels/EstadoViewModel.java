package com.app.viewModels;

import com.app.viewModels.base.IdentifiableViewModel;
import com.app.viewModels.base.NameableViewModel;

import java.util.Date;

public class EstadoViewModel extends IdentifiableViewModel {
    public Date fecha;
    public NameableViewModel autor;
    public String estado;



    public EstadoViewModel(Long id, NameableViewModel autor, String estado, Date fecha) {
        super(id);
        this.autor = autor;
        this.estado = estado;
        this.fecha = fecha;
    }
}
