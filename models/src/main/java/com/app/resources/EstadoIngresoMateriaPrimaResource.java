package com.app.resources;

import com.app.services.interfaces.IEstadoIngresoMateriaPrimaService;
import com.app.services.interfaces.IEstadoIngresoMateriaPrimaTypesService;
import com.app.viewModels.EstadoIngresoMateriaPrimaCreateViewModel;
import com.app.viewModels.EstadoViewModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Tag(name = "EstadoIngresoMateriaPrima")
@Path("/estadoIngresoMateriaPrima")
public class EstadoIngresoMateriaPrimaResource {

    @Inject
    private IEstadoIngresoMateriaPrimaService service;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public EstadoViewModel create(EstadoIngresoMateriaPrimaCreateViewModel entityToAdd) {

        return this.service.create(entityToAdd);
    }
}
