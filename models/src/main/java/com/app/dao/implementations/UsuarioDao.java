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

@Service
public class UsuarioDao extends BaseDao<Usuario> implements IUsuarioDao {

    public List<Usuario> getAll(boolean includeBlocked) {
        String query = "FROM " + this.getGenericClass().getName() + " i";
        if (!includeBlocked) query += " WHERE i.blocked = false";
        TypedQuery<Usuario> q = em.createQuery(query, this.getGenericClass());
        return q.getResultList();
    }
}
