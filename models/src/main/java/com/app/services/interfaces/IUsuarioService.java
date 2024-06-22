package com.app.services.interfaces;

import com.app.viewModels.UsuarioCreateViewModel;
import com.app.viewModels.UsuarioViewModel;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IUsuarioService {

    List<UsuarioViewModel> getAll(boolean includeBlocked);

    UsuarioViewModel create(UsuarioCreateViewModel usuario);

    UsuarioViewModel update(Long usuarioId, UsuarioCreateViewModel usuario);

}
