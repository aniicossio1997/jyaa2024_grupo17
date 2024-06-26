package com.app.resources;

import com.app.services.interfaces.IMateriaPrimaService;
import com.app.viewModels.*;
import com.app.viewModels.base.NameableViewModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Tag(name = "MateriaPrimas")
@Path("/materiaPrimas")

public class MateriaPrimaResource extends BaseResource{
    @Inject
    private IMateriaPrimaService materiaPrimaService;

    @GET
    public List<RecursoViewModel> getByFilters() {
        return this.materiaPrimaService.getAll();
    }

    @GET
    @Path("{id}")
    public RecursoDetailViewModel getById(@PathParam("id") Long id){
        return this.materiaPrimaService.getById(id);
    }

    @POST

    public RecursoDetailViewModel save(@Valid RecursoPostViewModel entityToAdd) {
        return this.materiaPrimaService.create(entityToAdd);
    }

    @PUT
    @Path("{id}")
    public RecursoDetailViewModel editar(@PathParam("id") Long id, @Valid RecursoPostViewModel entityToEdit){

        return materiaPrimaService.update(id,entityToEdit);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){

        materiaPrimaService.delete(id);
        return Response.status(Response.Status.OK).build();
    }

}
