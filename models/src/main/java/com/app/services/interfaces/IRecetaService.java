package com.app.services.interfaces;

import com.app.viewModels.*;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IRecetaService {

    List<RecetaViewModel> getAll();

    RecetaDetalleViewModel getById(Long recetaId);

    RecetaDetalleViewModel create(RecetaCreateViewModel view);

    RecetaDetalleViewModel update(Long recetaId, RecetaCreateViewModel view);

}
