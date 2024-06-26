package com.app.resources;

import com.app.services.interfaces.IInsumoService;
import com.app.services.interfaces.IMateriaPrimaService;
import com.app.viewModels.*;
import com.app.viewModels.base.NameableViewModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Tag(name = "Insumos")
@Path("/insumos")
public class InsumoResource extends BaseResource {


    @Inject
    private IInsumoService insumoServicio;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<NameableViewModel> getByFilters() {
        return this.insumoServicio.getAll();
    }
    @POST
    public InsumoViewModel getByFilters(@Valid InsumoCreateViewModel entityToAdd) {
        return this.insumoServicio.create(entityToAdd);
    }

    @GET
    @Path("{id}")
    public InsumoViewModel getById(@PathParam("id") Long id) {
        return this.insumoServicio.getById(id);
    }

    @PUT
    @Path("{id}")
    public InsumoViewModel editar(@PathParam("id") Long id, @Valid RecursoPostViewModel entityToEdit){
        return insumoServicio.update(id,entityToEdit);
    }
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){

        insumoServicio.delete(id);
        return Response.status(Response.Status.OK).build();
    }

}
