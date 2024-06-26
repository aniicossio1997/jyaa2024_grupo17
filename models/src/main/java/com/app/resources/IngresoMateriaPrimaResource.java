package com.app.resources;

import com.app.services.interfaces.IIngresoMateriaPrimaService;
import com.app.services.interfaces.IInsumoService;
import com.app.viewModels.IngresoMateriaPrimaCreateViewModel;
import com.app.viewModels.IngresoMateriaPrimaViewModel;
import com.app.viewModels.InsumoCreateViewModel;
import com.app.viewModels.InsumoViewModel;
import com.app.viewModels.base.NameableViewModel;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/ingresoMateriaPrima")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IngresoMateriaPrimaResource {


    @Inject
    private IIngresoMateriaPrimaService ingresoMateriaPrimaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<IngresoMateriaPrimaViewModel> getByFilter() {
        return this.ingresoMateriaPrimaService.getByFilters();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public IngresoMateriaPrimaViewModel create(@Valid IngresoMateriaPrimaCreateViewModel entityToAdd) {
        return this.ingresoMateriaPrimaService.create(entityToAdd);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public IngresoMateriaPrimaViewModel getId(@PathParam("id") Long id) {
        return this.ingresoMateriaPrimaService.getById(id);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){
        this.ingresoMateriaPrimaService.delete(id);
        return Response.status(Response.Status.OK).build();
    }
}
