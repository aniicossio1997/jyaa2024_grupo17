package com.app.dao;

import com.app.dao.interfaces.IBasicDao;
import jakarta.inject.Inject;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public abstract class BaseDao<T> implements IBasicDao<T> {

    @Inject
    protected EntityManager em;

    protected boolean getDeletable() {
        return false;
    }

    public BaseDao() {
        super();
        this.em = DBConnection.getInstance().getEntityManager();

    }

    @SuppressWarnings("unchecked")
    protected Class<T> getGenericClass() {
        return (Class<T>)
                ((ParameterizedType) getClass().getGenericSuperclass())
                        .getActualTypeArguments()[0];
    }

    public void save(T item) {
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        try {
            em.persist(item);
            etx.commit();
        } catch (Exception e) {
            etx.rollback();
            throw  e;
        }

    }

    public T getById(Long id) {
        //JPAQL
        String query = "FROM " + this.getGenericClass().getName() + " i WHERE i.id = :id";
        if (getDeletable()) query += " AND i.fechaBaja is NULL";
        TypedQuery<T> q = em.createQuery(query, this.getGenericClass());
        q.setParameter("id", id);
        return q.getSingleResult();
    }

    public List<T> getAll() {
        String query = "FROM " + this.getGenericClass().getName() + " i";
        if (getDeletable()) query += " WHERE i.fechaBaja is NULL";
        TypedQuery<T> q = em.createQuery(query, this.getGenericClass());
        return q.getResultList();
    }



    public List<T> getAll(boolean isActive) {

            String query = "FROM " + this.getGenericClass().getName() + " i";
            if (isActive) query += " WHERE i.fechaBaja is NULL";
            TypedQuery<T> q = em.createQuery(query, this.getGenericClass());
            return q.getResultList();

    }
    public T getById(Long id, boolean isActive) {
        //JPAQL
        String query = "FROM " + this.getGenericClass().getName() + " i";
        if (isActive) query += " WHERE i.fechaBaja is NULL and i.id = :id ";

        TypedQuery<T> q = em.createQuery(query, this.getGenericClass());

        q.setParameter("id", id);


        return q.getSingleResult();
    }

}
