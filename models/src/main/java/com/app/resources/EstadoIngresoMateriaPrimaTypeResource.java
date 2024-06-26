package com.app.resources;

import com.app.services.interfaces.IEstadoIngresoMateriaPrimaTypesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Tag(name = "EstadoIngresoMateriaPrimaTypes")
@Path("/estadoIngresoMateriaPrimaTypes")
public class EstadoIngresoMateriaPrimaTypeResource {

    @Inject
    private IEstadoIngresoMateriaPrimaTypesService ingresoMateriaPrimaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getByFilter() {
        return this.ingresoMateriaPrimaService.getAll();
    }
}
