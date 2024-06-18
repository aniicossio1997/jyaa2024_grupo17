package com.app.resources;


import com.app.models.Administrador;
import com.app.models.Usuario;
import com.app.services.interfaces.IUsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
public class UsuariosResource {
    @Inject
    private IUsuarioService usuarioService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getUsuarios() {
        return usuarioService.getAll();
    }
}
