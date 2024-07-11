package com.app.dao.interfaces;

import com.app.models.Usuario;
import com.app.models.enums.RolUsuario;
import org.hibernate.exception.ConstraintViolationException;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;
import java.util.Optional;

@Contract
public interface IUsuarioDao {

    void save(Usuario usuario) throws ConstraintViolationException;

    Usuario getById(Long id);

    Optional<Usuario> getByUsername(String username, boolean includeBlocked);

    List<Usuario> getAll(boolean includeBlocked);
}
