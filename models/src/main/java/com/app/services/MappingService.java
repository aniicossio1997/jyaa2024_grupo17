package com.app.services;

import com.app.models.IngredienteReceta;
import com.app.models.Insumo;
import com.app.models.Receta;
import com.app.models.Usuario;
import com.app.utils.ListUtils;
import com.app.viewModels.*;
import org.jvnet.hk2.annotations.Service;

import java.util.Optional;

@Service
public class MappingService {

    private UsuarioViewModel toViewModel(Usuario usuario) {
        return new UsuarioViewModel(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getRol(),
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.isBlocked()
        );
    }

    public IngredienteRecetaViewModel toViewModel(IngredienteReceta ingrediente) {
        return new IngredienteRecetaViewModel(
                ingrediente.getId(),
                ingrediente.getCantidad(),
                Optional.ofNullable(ingrediente.getInsumo()).map(this::toViewModel).orElse(null),
                null
        );
    }

    public RecetaDetalleViewModel toDetalleViewModel(Receta receta) {
        return new RecetaDetalleViewModel(
                receta.getId(), receta.getNombre(),
                receta.getDescripcion(), this.toViewModel(receta.getAutor()),
                ListUtils.mapList(receta.getIngredientes(), this::toViewModel)
        );
    }

    public RecetaViewModel toViewModel(Receta receta) {
        return new RecetaViewModel(
                receta.getId(),
                receta.getNombre(),
                receta.getDescripcion(),
                Optional.ofNullable(receta.getAutor()).map(Usuario::getUsername).orElse(null),
                receta.getIngredientes().size(),
                receta.getElaboraciones().size()
        );
    }

    public InsumoViewModel toViewModel(Insumo insumo) {
        return new InsumoViewModel(
                insumo.getId(),
                insumo.getNombre(),
                insumo.getCantidadDisponible(),
                insumo.getUnidadMedida(),
                insumo.getDescripcion()

        );
    }
}
