package com.app.services.interfaces;

import com.app.models.Usuario;
import com.app.viewModels.UsuarioPostViewModel;
import com.app.viewModels.UsuarioViewModel;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IUsuarioService {

    List<UsuarioViewModel> getAll();

    UsuarioViewModel create(UsuarioPostViewModel usuario);

}
