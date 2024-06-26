package com.app.resources;

import com.app.models.FamiliaProductora;
import com.app.services.interfaces.IFamiliaProductoraService;
import com.app.services.interfaces.IMateriaPrimaService;
import com.app.viewModels.*;
import com.app.viewModels.base.NameableViewModel;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/materiaPrimas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MateriaPrimaResource {
    @Inject
    private IMateriaPrimaService materiaPrimaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<NameableViewModel> getByFilters() {
        return this.materiaPrimaService.getAll();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RecursoViewModel getByFilters(@Valid RecursoPostViewModel entityToAdd) {
        return this.materiaPrimaService.create(entityToAdd);
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@PathParam("id") Long id, @Valid RecursoPostViewModel entityToEdit){
        RecursoViewModel entityNew = materiaPrimaService.update(id,entityToEdit);
        return Response.status(Response.Status.ACCEPTED).entity(entityNew).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RecursoViewModel getByFilterId(@PathParam("id") Long id){
        return this.materiaPrimaService.getById(id);
    }
}
