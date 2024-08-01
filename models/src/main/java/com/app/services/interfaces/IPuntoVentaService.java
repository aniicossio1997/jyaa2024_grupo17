package com.app.services.interfaces;

import com.app.models.FamiliaProductora;
import com.app.viewModels.FamiliaProductoraPostViewModel;
import com.app.viewModels.FamiliaProductoraViewModel;
import com.app.viewModels.PuntoVentaCreateViewModel;
import com.app.viewModels.PuntoVentaViewModel;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IPuntoVentaService {
    List<PuntoVentaViewModel> getAll();

    PuntoVentaViewModel save(PuntoVentaCreateViewModel entityToAdd);

    PuntoVentaViewModel update(Long id, PuntoVentaCreateViewModel entityToEdit);

    void delete(Long id);

    PuntoVentaViewModel getById(Long id);
}
