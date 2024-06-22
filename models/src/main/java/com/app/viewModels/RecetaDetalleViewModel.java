package com.app.viewModels;


import com.app.viewModels.base.NameableViewModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecetaDetalleViewModel extends NameableViewModel {
    public String descripcion;
    public UsuarioViewModel autor;
    public List<IngredienteRecetaViewModel> ingredientes;

    public RecetaDetalleViewModel(Long id, String nombre, String descripcion, UsuarioViewModel autor, List<IngredienteRecetaViewModel> ingredientes) {
        super(id, nombre);
        this.autor = autor;
        this.descripcion = descripcion;
        this.ingredientes = ingredientes;
    }

}
