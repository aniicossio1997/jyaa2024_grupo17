package com.app.services;

import com.app.models.*;
import com.app.utils.ListUtils;
import com.app.viewModels.*;
import org.jvnet.hk2.annotations.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MappingService {

    public UsuarioViewModel toViewModel(Usuario usuario) {
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
                Optional.ofNullable(ingrediente.getInsumo()).map(this::toViewModelInsumo).orElse(null),
                Optional.ofNullable(ingrediente.getMateriaPrima()).map(this::toViewModel).orElse(null)
        );
    }

    public RecetaDetalleViewModel toDetalleViewModel(Receta receta) {
        return new RecetaDetalleViewModel(
                receta.getId(), receta.getNombre(),
                receta.getDescripcion(),
                Optional.ofNullable(receta.getAutor()).map(this::toViewModel).orElse(null),
                ListUtils.mapList(receta.getIngredientes(), this::toViewModel),
                ListUtils.mapList(receta.getElaboraciones(), this::toViewModel)
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

    public ElaboracionViewModel toViewModel(Elaboracion elaboracion) {
        return new ElaboracionViewModel(
                elaboracion.getId(),
                elaboracion.getCantidad(),
                elaboracion.getCodigo(),
                elaboracion.getEstados().stream().findFirst().map(this::toViewModel).orElse(null),
                elaboracion.getFecha(),
                elaboracion.getReceta().getId(),
                Optional.ofNullable(elaboracion.getEstados().get(0)).map(e -> this.toViewModel(e.getAutor())).orElse(null),
                elaboracion.getReceta().getNombre()
        );
    }

    public ElaboracionDetalleViewModel toDetalleViewModel(Elaboracion elaboracion) {
        return new ElaboracionDetalleViewModel(
                elaboracion.getId(),
                elaboracion.getCantidad(),
                elaboracion.getCodigo(),
                elaboracion.getEstados().stream().findFirst().map(this::toViewModel).orElse(null),
                ListUtils.mapList(elaboracion.getEstados(), this::toViewModel),
                elaboracion.getFecha(),
                this.toViewModel(elaboracion.getReceta()),
                ListUtils.mapList(elaboracion.getNotas(), this::toViewModel),
                ListUtils.mapList(elaboracion.getConsumoMateriasPrimas(), this::toViewModel)
        );
    }

    public InsumoViewModel toViewModelInsumo(Insumo insumo) {
        return new InsumoViewModel(
                insumo.getId(),
                insumo.getNombre(),
                insumo.getCantidadIngresos(),
                insumo.getUnidadMedida(),
                insumo.getDescripcion()

        );
    }

    public ConsumoMateriaPrimaViewModel toViewModel(ConsumoMateriaPrima entity) {
        return new ConsumoMateriaPrimaViewModel(
                entity.getId(), entity.getCantidad(), entity.getElaboracion().getId(), toViewModel(entity.getMateriaPrima())
        );
    }


    public EstadoViewModel toViewModel(EstadoElaboracion estadoElaboracion) {
        return new EstadoViewModel(estadoElaboracion.getId(), this.toViewModel(estadoElaboracion.getAutor()), estadoElaboracion.getEstado().getValue(), estadoElaboracion.getFecha());
    }

    public RecursoViewModel toViewModel(Recurso entity) {
        return new RecursoViewModel(
                entity.getId(),
                entity.getNombre(),
                entity.getUnidadMedida(),
                entity.getCantidadIngresos(),
                entity.getTotalValorDeCompra()
        );
    }

    public NotaViewModel toViewModel(Nota entity) {
        return new NotaViewModel(
                entity.getId(),
                toViewModel(entity.getAutor()),
                entity.getDescripcion(),
                entity.getFecha()
        );
    }

    public RecursoDetailViewModel toViewModelDetail(Recurso entity) {
        return new RecursoDetailViewModel(
                entity.getId(),
                entity.getNombre(),
                entity.getUnidadMedida(),
                entity.getDescripcion(),
                entity.getCantidadIngresos(),
                entity.getTotalValorDeCompra()

        );
    }


}
