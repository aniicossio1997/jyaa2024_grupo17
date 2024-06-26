package com.app.resources;

import com.app.services.interfaces.IInfoTypesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Tag(name = "InfoTypes")
@Path("/infoTypes")
public class InfoTypesResource extends BaseResource {

    @Inject
    private IInfoTypesService service;

    @GET
    @Path("EstadoIngresoTypes")
    public List<String> GetAll() {
        return this.service.getAllEstadoMateriaPrima();
    }
    @GET
    @Path("UnidadMedidaTypes")
    public List<String> GetAllUnidades() {
        return this.service.getAllUnidadMedida();
    }
    @GET
    @Path("EstadoLoteTypes")
    public List<String> GetAllEstadoLoteTypes() {
        return this.service.getAllEstadoLote();
    }
    @GET
    @Path("RolUsuarioTypes")
    public List<String> GetAllRoles() {
        return this.service.getAllRoles();
    }
}
