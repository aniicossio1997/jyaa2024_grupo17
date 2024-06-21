package com.app.dao.implementations;

import com.app.dao.BaseDao;
import com.app.dao.interfaces.IUsuarioDao;
import com.app.models.Usuario;
import com.app.models.enums.RolUsuario;
import org.hibernate.Session;
import org.jvnet.hk2.annotations.Service;

import javax.persistence.Query;

@Service
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
