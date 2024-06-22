package com.app.viewModels;


import com.app.viewModels.base.NameableViewModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecetaViewModel extends NameableViewModel {
    public String descripcion;
    public String autor;
    public int ingredientes;
    public int elaboraciones;

    public RecetaViewModel(Long id, String nombre, String descripcion, String autor, int ingredientes, int elaboraciones) {
        super(id, nombre);
        this.descripcion = descripcion;
        this.ingredientes = ingredientes;
        this.autor = autor;
        this.elaboraciones = elaboraciones;
    }

}

