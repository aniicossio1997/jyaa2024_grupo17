package com.app.services.interfaces;

import com.app.viewModels.NotaCreateViewModel;
import com.app.viewModels.NotaViewModel;
import org.jvnet.hk2.annotations.Contract;

@Contract
public interface INotaService {

    NotaViewModel create(Long usuarioId, NotaCreateViewModel view);

    boolean delete(Long notaId);
}
