package com.app.dao.implementations;

import com.app.dao.BaseDao;
import com.app.dao.interfaces.IUsuarioDao;
import com.app.models.Usuario;
import com.app.models.enums.RolUsuario;
import org.hibernate.Session;
import org.jvnet.hk2.annotations.Service;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioDao extends BaseDao<Usuario> implements IUsuarioDao {

    @Override
    public Optional<Usuario> getByUsername(String username, boolean includeBlocked) {
        String query = "FROM " + this.getGenericClass().getName() + " i WHERE i.username = :username ";
        if (!includeBlocked) query += " and i.blocked = false";
        TypedQuery<Usuario> q = em.createQuery(query, this.getGenericClass());
        q.setParameter("username", username);
        return q.getResultList().stream().findFirst();
    }

    public List<Usuario> getAll(boolean includeBlocked) {
        String query = "FROM " + this.getGenericClass().getName() + " i";
        if (!includeBlocked) query += " WHERE i.blocked = false";
        query += " ORDER BY i.id DESC";
        TypedQuery<Usuario> q = em.createQuery(query, this.getGenericClass());
        return q.getResultList();
    }
}
