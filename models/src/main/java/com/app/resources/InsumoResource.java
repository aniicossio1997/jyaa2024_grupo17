package com.app.resources;

import com.app.services.interfaces.IInsumoService;
import com.app.services.interfaces.IMateriaPrimaService;
import com.app.viewModels.FamiliaProductoraPostViewModel;
import com.app.viewModels.InsumoCreateViewModel;
import com.app.viewModels.InsumoViewModel;
import com.app.viewModels.base.NameableViewModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Tag(name = "Insumos")
@Path("/insumos")
public class InsumoResource {
    @Inject
    private IInsumoService insumoServicio;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<NameableViewModel> getByFilters() {
        return this.insumoServicio.getAll();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public InsumoViewModel getByFilters(@Valid InsumoCreateViewModel entityToAdd) {
        return this.insumoServicio.create(entityToAdd);
    }

}
