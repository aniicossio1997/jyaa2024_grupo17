package com.app.resources;

import com.app.services.interfaces.IInsumoService;
import com.app.services.interfaces.IMateriaPrimaService;
import com.app.viewModels.base.NameableViewModel;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/insumos")
public class InsumoResource {
    @Inject
    private IInsumoService insumoServicio;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<NameableViewModel> getByFilters() {
        return this.insumoServicio.getAll();
    }
}
