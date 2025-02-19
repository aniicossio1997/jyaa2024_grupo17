package com.app.resources;


import com.app.exceptions.InvalidParameterException;
import com.app.services.interfaces.IIngredienteRecetaService;
import com.app.services.interfaces.IRecetaService;
import com.app.viewModels.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/ingredientes")
@Tag(name = "Ingredientes")
public class IngredienteRecetaResource extends BaseResource {

    @Inject
    private IIngredienteRecetaService ingredienteRecetaService;

    @Path("{id}")
    @GET
    public IngredienteRecetaViewModel getById(@PathParam("id") Long id) {
        return ingredienteRecetaService.getById(id);
    }

    @POST
    public IngredienteRecetaViewModel create(IngredienteRecetaCreateViewModel viewModel) {
        return ingredienteRecetaService.create(viewModel);
    }

    @PUT
    @Path("{id}")
    public IngredienteRecetaViewModel update(@PathParam("id") Long id, IngredienteRecetaCreateViewModel viewModel) {
        return ingredienteRecetaService.update(id, viewModel);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = ingredienteRecetaService.delete(id);
        if (deleted) return Response.ok().build();
        return  Response.status(400).build();
    }


}
