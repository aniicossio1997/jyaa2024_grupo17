package com.app.viewModels;


import com.app.viewModels.base.IdentifiableViewModel;

import java.util.Date;

public class ElaboracionViewModel extends IdentifiableViewModel {

    public long cantidad;
    public String codigo;
    public Date fecha;
    public long recetaId;
    public EstadoViewModel estado;
    public UsuarioViewModel autor;
    public String receta;

    public ElaboracionViewModel() {
    }

    public ElaboracionViewModel(Long id, long cantidad, String codigo, EstadoViewModel estado, Date fecha, long recetaId, UsuarioViewModel autor, String receta) {
        super(id);
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.estado = estado;
        this.fecha = fecha;
        this.recetaId = recetaId;
        this.autor = autor;
        this.receta = receta;
    }
}

