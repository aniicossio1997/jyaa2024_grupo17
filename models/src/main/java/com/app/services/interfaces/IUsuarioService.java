package com.app.services.interfaces;

import com.app.models.Usuario;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IUsuarioService {

    List<Usuario> getAll();
}
