package com.app.resources;



import com.app.models.Administrador;
import com.app.models.Usuario;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
public class UsuariosResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getUsuarios() {
        return Arrays.asList(new Administrador("Ad", "Min", "admin", "asdasd123", "admin@test.com"));
    }
}
