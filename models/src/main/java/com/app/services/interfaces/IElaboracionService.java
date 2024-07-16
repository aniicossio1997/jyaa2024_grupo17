package com.app.services.interfaces;

import com.app.viewModels.*;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IElaboracionService {

    List<ElaboracionViewModel> getAll(Long recetaId);

    ElaboracionDetalleViewModel getById(Long id);

    ElaboracionDetalleViewModel create(ElaboracionCreateViewModel view);

    boolean delete(Long id);

    ElaboracionDetalleViewModel update(Long id, ElaboracionCreateViewModel view);

}
