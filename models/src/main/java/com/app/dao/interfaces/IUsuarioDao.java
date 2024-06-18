package com.app.dao.interfaces;

import com.app.models.Usuario;

import java.util.List;

public interface IUsuarioDao {

    void save(Usuario usuario);

    Usuario getById(Long id);

    List<Usuario> getAll();

   /* void delete(Long id); */
    
}
