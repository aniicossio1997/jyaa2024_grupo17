package com.app.resources;

import com.app.models.FamiliaProductora;
import com.app.services.interfaces.IFamiliaProductoraService;
import com.app.viewModels.FamiliaProductoraPostViewModel;
import com.app.viewModels.base.NameableViewModel;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/familiaProductoras")
@Produces(MediaType.APPLICATION_JSON)
public class FamiliaProductoraResource {

    @Inject
    private IFamiliaProductoraService familiaProductoraService;



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<NameableViewModel> getByList() {
        return this.familiaProductoraService.getByFilter();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createFamiliaProductora(@Valid FamiliaProductoraPostViewModel familiaProductora) {

        FamiliaProductora createdFamiliaProductora = familiaProductoraService.save(familiaProductora);
        return Response.status(Response.Status.CREATED).entity(createdFamiliaProductora).build();

    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@PathParam("id") Long id,@Valid FamiliaProductoraPostViewModel entityToEdit){
        FamiliaProductora createdFamiliaProductora = familiaProductoraService.update(id,entityToEdit);
        return Response.status(Response.Status.ACCEPTED).entity(createdFamiliaProductora).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){
        familiaProductoraService.delete(id);
        return Response.status(Response.Status.OK).build();
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public FamiliaProductora getById(@PathParam("id") Long id) {

        return this.familiaProductoraService.getById(id);
    }

}
