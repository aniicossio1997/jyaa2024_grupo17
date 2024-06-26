package com.app.resources;

import com.app.services.interfaces.IIngresoMateriaPrimaService;
import com.app.services.interfaces.IInsumoService;
import com.app.viewModels.*;
import com.app.viewModels.base.NameableViewModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Tag(name = "IngresoMateriaPrimas")
@Path("/ingresoMateriaPrima")
public class IngresoMateriaPrimaResource extends BaseResource {


    @Inject
    private IIngresoMateriaPrimaService ingresoMateriaPrimaService;

    @GET
    public List<IngresoMateriaPrimaViewModel> getByFilter() {
        return this.ingresoMateriaPrimaService.getByFilters();
    }
    @POST
    public IngresoMateriaPrimaViewModel create(@Valid IngresoMateriaPrimaCreateViewModel entityToAdd) {
        return this.ingresoMateriaPrimaService.create(entityToAdd);
    }

    @GET
    @Path("{id}")
    public IngresoMateriaPrimaDetailViewModel getId(@PathParam("id") Long id) {
        return this.ingresoMateriaPrimaService.getById(id);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){
        this.ingresoMateriaPrimaService.delete(id);
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Path("{id}")
    public IngresoMateriaPrimaDetailViewModel update(@PathParam("id") Long id, IngresoMateriaPrimaUpdateViewModel entityToEdit){

        return this.ingresoMateriaPrimaService.update(id, entityToEdit);

    }
}
