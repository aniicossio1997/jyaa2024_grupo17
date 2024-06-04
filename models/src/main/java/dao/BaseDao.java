package dao;

import java.lang.annotation.ElementType;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public abstract class BaseDao<T> {
    protected EntityManager em;


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
        em.persist(item);
        etx.commit();
    }

    public T getById(Long id) {
        //JPAQL
        TypedQuery<T> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i WHERE i.id = :id", this.getGenericClass());
        q.setParameter("id", id);
        return q.getSingleResult();
    }

    public List<T> getAll() {
        TypedQuery<T> q = em.createQuery("FROM " + this.getGenericClass().getName() + " i", this.getGenericClass());
        return q.getResultList();
    }

}
