package com.app.services;

import com.app.models.*;
import com.app.utils.ListUtils;
import com.app.viewModels.*;
import org.jvnet.hk2.annotations.Service;

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

    public LoteProductoElaboradoViewModel toViewModel(LoteProductoElaborado lote) {
        return new LoteProductoElaboradoViewModel(
                lote.getId(),
                lote.getCantidad(),
                lote.getCodigo(),
                lote.getEstados().stream().findFirst().orElse(null),
                lote.getFecha(),
                lote.getReceta().getId()
        );
    }

    public LoteProductoElaboradoDetalleViewModel toDetalleViewModel(LoteProductoElaborado lote) {
        return new LoteProductoElaboradoDetalleViewModel(
                lote.getId(),
                lote.getCantidad(),
                lote.getCodigo(),
                lote.getEstados().stream().findFirst().orElse(null),
                lote.getEstados(),
                lote.getFecha(),
                this.toViewModel(lote.getReceta())
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



    public RecursoViewModel toViewModel(Recurso entity) {
        return new RecursoViewModel(
                entity.getId(),
                entity.getNombre(),
                entity.getUnidadMedida(),
                entity.getCantidadIngresos(),
                entity.getTotalValorDeCompra()
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
