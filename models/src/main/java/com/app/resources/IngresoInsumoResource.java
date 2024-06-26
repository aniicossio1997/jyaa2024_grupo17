package com.app.resources;

import com.app.services.IngresoInsumoService;
import com.app.services.interfaces.IIngresoInsumoService;
import com.app.viewModels.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Tag(name = "IngresoInsumos")
@Path("/ingresoInsumo")
public class IngresoInsumoResource extends BaseResource{
    @Inject
    private IIngresoInsumoService service;

    @GET
    public List<IngresoInsumoViewModel> getByFilter() {
        return this.service.getByFilters();
    }
    @POST
    public IngresoInsumoViewModel create(@Valid IngresoInsumoCreateViewModel entityToAdd) {
        return this.service.create(entityToAdd);
    }

    @GET
    @Path("{id}")
    public IngresoInsumoViewModel getId(@PathParam("id") Long id) {
        return this.service.getById(id);
    }

    @PUT
    @Path("{id}")
    public IngresoInsumoViewModel update(@PathParam("id") Long id, IngresoInsumoCreateViewModel entityToEdit){
        return this.service.update(id, entityToEdit);
    }
}
