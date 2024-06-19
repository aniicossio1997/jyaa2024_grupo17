package com.app.resources;

import com.app.models.FamiliaProductora;
import com.app.services.interfaces.IFamiliaProductoraService;
import com.app.viewModels.FamiliaProductoraPostViewModel;
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
    public List<FamiliaProductora> getByList() {
        return this.familiaProductoraService.getByFilter();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createFamiliaProductora(@Valid FamiliaProductoraPostViewModel familiaProductora) {

        try {
            FamiliaProductora createdFamiliaProductora = familiaProductoraService.save(familiaProductora);
            // Devolver una respuesta 201 CREATED con el objeto creado
            return Response.status(Response.Status.CREATED).entity(createdFamiliaProductora).build();
        } catch (Exception e) {
            // Manejar la excepción y devolver una respuesta de error 400 Bad Request
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }

    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@PathParam("id") Long id,@Valid FamiliaProductoraPostViewModel entityToEdit){
        try {
            FamiliaProductora createdFamiliaProductora = familiaProductoraService.update(id,entityToEdit);
            // Devolver una respuesta 201 CREATED con el objeto creado
            return Response.status(Response.Status.CREATED).entity(createdFamiliaProductora).build();
        } catch (Exception e) {
            // Manejar la excepción y devolver una respuesta de error 400 Bad Request
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }


}
