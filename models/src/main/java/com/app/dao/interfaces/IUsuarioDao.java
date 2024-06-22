package com.app.dao.interfaces;

import com.app.models.Usuario;
import com.app.models.enums.RolUsuario;
import org.hibernate.exception.ConstraintViolationException;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IUsuarioDao {

    void save(Usuario usuario) throws ConstraintViolationException;

    Usuario getById(Long id);

    List<Usuario> getAll(boolean includeBlocked);
}
