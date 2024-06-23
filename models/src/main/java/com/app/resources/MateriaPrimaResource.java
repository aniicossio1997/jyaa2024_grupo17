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
    public RecursoViewModel editar(@PathParam("id") Long id, @Valid RecursoPostViewModel entityToEdit){

        return materiaPrimaService.update(id,entityToEdit);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RecursoViewModel getByFilterId(@PathParam("id") Long id){
        return this.materiaPrimaService.getById(id);
    }
}
