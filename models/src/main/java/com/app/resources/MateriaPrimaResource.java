package com.app.resources;

import com.app.services.interfaces.IFamiliaProductoraService;
import com.app.services.interfaces.IMateriaPrimaService;
import com.app.viewModels.UsuarioViewModel;
import com.app.viewModels.base.NameableViewModel;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/materiaPrimas")
public class MateriaPrimaResource {
    @Inject
    private IMateriaPrimaService materiaPrimaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<NameableViewModel> getByFilters() {
        return this.materiaPrimaService.getAll();
    }
}
