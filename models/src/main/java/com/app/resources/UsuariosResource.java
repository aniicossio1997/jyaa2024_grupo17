package com.app.resources;


import com.app.services.interfaces.IUsuarioService;
import com.app.viewModels.UsuarioCreateViewModel;
import com.app.viewModels.UsuarioViewModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Tag(name = "Usuarios")
@Path("/usuarios")
public class UsuariosResource extends BaseResource {
    @Inject
    private IUsuarioService usuarioService;


    @GET
    public List<UsuarioViewModel> getUsuarios(@QueryParam("includeBlocked") boolean includeBlocked) {
        return usuarioService.getAll(includeBlocked);
    }


    @GET
    @Path("{id}")
    public UsuarioViewModel getById(@PathParam("id") Long id) {
        return usuarioService.getById(id);
    }

    @POST
    public UsuarioViewModel create(UsuarioCreateViewModel usuarioCreateViewModel) {
        return usuarioService.create(usuarioCreateViewModel);
    }

    @PUT
    @Path("{id}")
    public UsuarioViewModel update(@PathParam("id") Long id, UsuarioCreateViewModel usuarioCreateViewModel) {
        return usuarioService.update(id, usuarioCreateViewModel);
    }

    @DELETE
    @Path("{id}")
    public Response block(@PathParam("id") Long id) {
        usuarioService.delete(id);
        return Response.status(Response.Status.OK).build();
    }

}
