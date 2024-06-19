package com.app.dao.implementations;

import com.app.dao.BaseDao;
import com.app.dao.interfaces.IUsuarioDao;
import com.app.models.FamiliaProductora;
import com.app.models.IngredienteReceta;
import com.app.models.Usuario;
import com.app.models.enums.RolUsuario;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class UsuarioDao extends BaseDao<Usuario> implements IUsuarioDao {


    @Override
    public void updateRol(Usuario usuario, RolUsuario rol) {
        Session session = em.unwrap(Session.class);
        Query q = session.createNativeQuery("UPDATE " + this.getGenericClass().getName() + " SET rol = :rol WHERE id = :userId");
        q.setParameter("rol", rol.getValue());
        q.setParameter("userId", usuario.getId());
        q.executeUpdate();
        em.refresh(usuario);
    }
}
