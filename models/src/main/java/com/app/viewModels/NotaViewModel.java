package com.app.viewModels;


import com.app.viewModels.base.IdentifiableViewModel;

import java.util.Date;

public class NotaViewModel extends IdentifiableViewModel {
    public Date fecha;
    public String descripcion;
    public UsuarioViewModel autor;

    public NotaViewModel(Long id, UsuarioViewModel autor, String descripcion, Date fecha) {
        super(id);
        this.autor = autor;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public NotaViewModel() {
    }
}

