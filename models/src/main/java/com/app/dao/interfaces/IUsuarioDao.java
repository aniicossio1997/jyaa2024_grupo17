package com.app.dao.interfaces;

import com.app.models.Usuario;
import com.app.models.enums.RolUsuario;
import org.hibernate.exception.ConstraintViolationException;

import java.util.List;

public interface IUsuarioDao {

    void save(Usuario usuario) throws ConstraintViolationException;

    Usuario getById(Long id);

    List<Usuario> getAll();

    void updateRol(Usuario usuario, RolUsuario rol);
    /* void delete(Long id); */

}
