package com.app.resources;


import com.app.services.interfaces.IUsuarioService;
import com.app.viewModels.UsuarioCreateViewModel;
import com.app.viewModels.UsuarioViewModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

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


    @POST
    public UsuarioViewModel create(UsuarioCreateViewModel usuarioCreateViewModel) {
        return usuarioService.create(usuarioCreateViewModel);
    }

    @PATCH
    @Path("{id}")
    public UsuarioViewModel update(@PathParam("id") Long id, UsuarioCreateViewModel usuarioCreateViewModel) {
        return usuarioService.update(id, usuarioCreateViewModel);
    }

}
