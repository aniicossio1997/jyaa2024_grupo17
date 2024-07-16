package com.app.resources;


import com.app.services.interfaces.IIngredienteRecetaService;
import com.app.services.interfaces.IElaboracionService;
import com.app.viewModels.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/elaboraciones")
@Tag(name = "Elaboraciones")
public class ElaboracionResource extends BaseResource {

    @Inject
    private IElaboracionService elaboracionService;

    @Inject
    private IIngredienteRecetaService ingredienteRecetaService;

    @GET

    public List<ElaboracionViewModel> getAll(@PathParam("recetaId") Long recetaId) {
        return elaboracionService.getAll(recetaId);
    }

    @Path("{id}")
    @GET
    public ElaboracionDetalleViewModel getDetail(@PathParam("id") Long id) {
        return elaboracionService.getById(id);
    }

    @POST
    public ElaboracionDetalleViewModel create(ElaboracionCreateViewModel viewModel) {
        return elaboracionService.create(viewModel);
    }

    @PUT
    @Path("{id}")
    public ElaboracionDetalleViewModel update(@PathParam("id") Long id, ElaboracionCreateViewModel viewModel) {
        return elaboracionService.update(id, viewModel);
    }
}
