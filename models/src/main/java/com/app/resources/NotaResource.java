package com.app.resources;


import com.app.services.interfaces.INotaService;
import com.app.viewModels.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/notas")
@Tag(name = "Notas")
public class NotaResource extends BaseResource {

    @Inject
    private INotaService notaService;

    @POST
    public NotaViewModel create(NotaCreateViewModel viewModel) {
        return notaService.create(this.getUsuarioId(), viewModel);
    }


    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){
        notaService.delete(id);
        return Response.status(Response.Status.OK).build();
    }
}
