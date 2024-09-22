package com.app.resources;

import com.app.services.interfaces.IEntregaElaboracionService;
import com.app.services.interfaces.IEstadoIngresoMateriaPrimaService;
import com.app.viewModels.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Tag(name = "Entrega Elaboracion")
@Path("/entregas")
public class EntregaElaboracionResource extends BaseResource {

    @Inject
    private IEntregaElaboracionService service;

    @GET
    public List<EntregaElaboracionViewModel> getAll(@QueryParam("elaboracionId") Long elaboracionId, @QueryParam("puntoVentaId") Long puntoVentaId) {
        return service.getAll(elaboracionId, puntoVentaId);
    }

    @POST
    public EntregaElaboracionViewModel create(EntregaElaboracionCreateViewModel entityToAdd) {
        entityToAdd.usuarioId = getUsuarioId();
        return this.service.create(entityToAdd);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.status(Response.Status.OK).build();
    }


    @GET
    @Path("{id}")
    public EntregaElaboracionViewModel getById(@PathParam("id") Long id) {
        return this.service.getById(id);
    }
}
