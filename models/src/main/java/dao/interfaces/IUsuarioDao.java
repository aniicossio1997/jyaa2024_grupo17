package dao.interfaces;

import grupo17.Usuario;

import java.util.List;

public interface IUsuarioDao {

    void save(Usuario usuario);

    Usuario getById(Long id);

    List<Usuario> getAll();

   /* void delete(Long id); */
    
}
