package com.app.resources;

import com.app.annotations.Secured;
import com.app.models.FamiliaProductora;
import com.app.services.interfaces.IFamiliaProductoraService;
import com.app.viewModels.FamiliaProductoraPostViewModel;
import com.app.viewModels.FamiliaProductoraViewModel;
import com.app.viewModels.base.NameableViewModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Tag(name = "FamiliaProductoras")
@Path("/familiaProductoras")
public class FamiliaProductoraResource extends BaseResource {



    @Inject
    private IFamiliaProductoraService familiaProductoraService;

    @GET
    public List<FamiliaProductoraViewModel> getByList() {
        Long id = this.getUsuarioId();
        return this.familiaProductoraService.getByFilter();
    }

    @POST
    public Response createFamiliaProductora(@Valid FamiliaProductoraPostViewModel familiaProductora) {
        FamiliaProductora createdFamiliaProductora = familiaProductoraService.save(familiaProductora);
        return Response.status(Response.Status.CREATED).entity(createdFamiliaProductora).build();
    }

    @PUT
    @Path("{id}")
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
    public FamiliaProductora getById(@PathParam("id") Long id) {

        return this.familiaProductoraService.getById(id);
    }

}
