package com.app.resources;

import com.app.services.interfaces.IEstadoElaboracionService;
import com.app.viewModels.EstadoElaboracionCreateViewModel;
import com.app.viewModels.EstadoViewModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Tag(name = "EstadoEaboracion")
@Path("/estadoelaboracion")
public class EstadoElaboracionResource extends BaseResource {

    @Inject
    private IEstadoElaboracionService service;

    @POST
    public EstadoViewModel create(EstadoElaboracionCreateViewModel entityToAdd) {
        entityToAdd.usuarioId = getUsuarioId();
        return this.service.create(entityToAdd);
    }
}
