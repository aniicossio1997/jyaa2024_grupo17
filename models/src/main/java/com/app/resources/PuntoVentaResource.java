package com.app.resources;

import com.app.models.FamiliaProductora;
import com.app.services.interfaces.IPuntoVentaService;
import com.app.viewModels.FamiliaProductoraPostViewModel;
import com.app.viewModels.FamiliaProductoraViewModel;
import com.app.viewModels.PuntoVentaCreateViewModel;
import com.app.viewModels.PuntoVentaViewModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Tag(name = "PuntoDeVenta")
@Path("/puntosventa")
public class PuntoVentaResource extends BaseResource {

    @Inject
    private IPuntoVentaService puntoVentaService;

    @GET
    public List<PuntoVentaViewModel> getAll() {
        return this.puntoVentaService.getAll();
    }

    @POST
    public Response create(PuntoVentaCreateViewModel view) {
        PuntoVentaViewModel entity = puntoVentaService.save(view);
        return Response.status(Response.Status.CREATED).entity(entity).build();
    }

    @PUT
    @Path("{id}")
    public Response editar(@PathParam("id") Long id, @Valid PuntoVentaCreateViewModel entityToEdit) {
        PuntoVentaViewModel entity = puntoVentaService.update(id, entityToEdit);
        return Response.status(Response.Status.ACCEPTED).entity(entity).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        puntoVentaService.delete(id);
        return Response.status(Response.Status.OK).build();
    }


    @GET
    @Path("{id}")
    public PuntoVentaViewModel getById(@PathParam("id") Long id) {
        return this.puntoVentaService.getById(id);
    }

}
