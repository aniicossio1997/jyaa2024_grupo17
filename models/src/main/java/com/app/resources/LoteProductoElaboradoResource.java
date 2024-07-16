package com.app.resources;


import com.app.services.interfaces.IIngredienteRecetaService;
import com.app.services.interfaces.ILoteProductoElaboradoService;
import com.app.viewModels.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/elaboraciones")
@Tag(name = "Elaboraciones")
public class LoteProductoElaboradoResource extends BaseResource {

    @Inject
    private ILoteProductoElaboradoService loteProductoElaboradoService;

    @Inject
    private IIngredienteRecetaService ingredienteRecetaService;

    @GET
    public List<LoteProductoElaboradoViewModel> getAll() {
        return loteProductoElaboradoService.getAll();
    }

    @Path("{id}")
    @GET
    public LoteProductoElaboradoDetalleViewModel getDetail(@PathParam("id") Long id) {
        return loteProductoElaboradoService.getById(id);
    }

    @POST
    public LoteProductoElaboradoDetalleViewModel create(LoteProductoElaboradoCreateViewModel viewModel) {
        return loteProductoElaboradoService.create(viewModel);
    }

    @PUT
    @Path("{id}")
    public LoteProductoElaboradoDetalleViewModel update(@PathParam("id") Long id, LoteProductoElaboradoCreateViewModel viewModel) {
        return loteProductoElaboradoService.update(id, viewModel);
    }
}
