package com.app.services.interfaces;

import com.app.models.EntregaElaboracion;
import com.app.viewModels.EntregaElaboracionCreateViewModel;
import com.app.viewModels.EntregaElaboracionViewModel;
import com.app.viewModels.PuntoVentaCreateViewModel;
import com.app.viewModels.PuntoVentaViewModel;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IEntregaElaboracionService {
    List<EntregaElaboracionViewModel> getAll(Long elaboracionId, Long puntoVentaId);

    EntregaElaboracionViewModel create(EntregaElaboracionCreateViewModel entityToAdd);

    void delete(Long id);

    EntregaElaboracionViewModel getById(Long id);
}
