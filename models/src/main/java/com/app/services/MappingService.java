package com.app.services;

import com.app.models.*;
import com.app.utils.ListUtils;
import com.app.utils.MappingUtils;
import com.app.viewModels.*;
import org.jvnet.hk2.annotations.Service;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

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
                this.toViewModel(elaboracion.getEstadoActual()),
                elaboracion.getFecha(),
                elaboracion.getReceta().getId(),
                this.toViewModel(elaboracion.getAutor()),
                elaboracion.getReceta().getNombre()
        );
    }

    public ElaboracionDetalleViewModel toDetalleViewModel(Elaboracion elaboracion) {


        return new ElaboracionDetalleViewModel(
                elaboracion.getId(),
                elaboracion.getCantidad(),
                elaboracion.getCodigo(),
                this.toViewModel(elaboracion.getEstadoActual()),
                elaboracion.getEstados().stream().sorted(Comparator.comparing(EstadoElaboracion::getFecha).reversed()).map(this::toViewModel).collect(Collectors.toList()),
                elaboracion.getFecha(),
                this.toViewModel(elaboracion.getReceta()),
                ListUtils.mapList(elaboracion.getNotas(), this::toViewModel),
                ListUtils.mapList(elaboracion.getConsumoMateriasPrimas(), this::toViewModel),
                ListUtils.mapList(elaboracion.getConsumoInsumos(), this::toViewModel),
                ListUtils.mapList(elaboracion.getEntregas(), this::toViewModel)
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
                entity.getId(), entity.getCantidad(), entity.getElaboracion().getId(), toViewModel(entity.getIngreso()), entity.getMateriaPrima().getUnidadMedida()
        );
    }

    public ConsumoInsumoViewModel toViewModel(ConsumoInsumo entity) {
        return new ConsumoInsumoViewModel(
                entity.getId(), entity.getCantidad(), entity.getElaboracion().getId(), toViewModelInsumo(entity.getInsumo())
        );
    }

    public IngresoMateriaPrimaViewModel toViewModel(IngresoMateriaPrima imp) {
        return new IngresoMateriaPrimaViewModel(
                imp.getId(), imp.getValorCompra(),
                imp.getMateriaPrima(), imp.getFecha(),
                MappingUtils.toViewModel(imp.getProductor()),
                imp.getDescripcion(), imp.getCodigo(), imp.getCantidad(),
                imp.getEstadoActual()
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

    public PuntoVentaViewModel toViewModel(PuntoVenta entity) {
        return new PuntoVentaViewModel(
                entity.getId(),
                entity.getNombre(),
                entity.getDescripcion()
        );
    }

    public EntregaElaboracionViewModel toViewModel(EntregaElaboracion entregaElaboracion) {
        return new EntregaElaboracionViewModel(
                entregaElaboracion.getId(),
                entregaElaboracion.getCantidad(),
                this.toViewModel(entregaElaboracion.getElaboracion()), entregaElaboracion.getFecha(),
                this.toViewModel(entregaElaboracion.getPuntoVenta()),
                this.toViewModel(entregaElaboracion.getAutor())
        );
    }
}
