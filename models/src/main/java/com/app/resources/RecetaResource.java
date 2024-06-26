package com.app.resources;


import com.app.services.interfaces.IIngredienteRecetaService;
import com.app.services.interfaces.IRecetaService;
import com.app.viewModels.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/recetas")
@Tag(name = "Recetas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RecetaResource {

    @Inject
    private IRecetaService recetaService;

    @Inject
    private IIngredienteRecetaService ingredienteRecetaService;

    @GET
    public List<RecetaViewModel> getAll() {
        return recetaService.getAll();
    }

    @Path("{id}")
    @GET
    public RecetaDetalleViewModel getDetail(@PathParam("id") Long id) {
        return recetaService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RecetaDetalleViewModel create(RecetaCreateViewModel viewModel) {
        return recetaService.create(viewModel);
    }

    @PUT
    @Path("{id}")
    public RecetaDetalleViewModel update(@PathParam("id") Long id, RecetaCreateViewModel viewModel) {
        return recetaService.update(id, viewModel);
    }

    @GET
    @Path("{id}/ingredientes")
    public List<IngredienteRecetaViewModel> getIngredientes(@PathParam("id") Long recetaId) {
        return ingredienteRecetaService.getAllByReceta(recetaId);
    }

}
