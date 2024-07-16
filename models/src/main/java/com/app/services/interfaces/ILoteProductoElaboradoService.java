package com.app.services.interfaces;

import com.app.viewModels.*;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface ILoteProductoElaboradoService {

    List<LoteProductoElaboradoViewModel> getAll();

    LoteProductoElaboradoDetalleViewModel getById(Long recetaId);

    LoteProductoElaboradoDetalleViewModel create(LoteProductoElaboradoCreateViewModel view);

    boolean delete(Long id);

    LoteProductoElaboradoDetalleViewModel update(Long recetaId, LoteProductoElaboradoCreateViewModel view);

}
