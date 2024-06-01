package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public abstract class BaseDao<T > {
	private EntityManager em;


	public BaseDao() {
		super();
		this.em = DBConnection.getInstance().getEntityManager();
		
	}

	public void save( T item)
	{
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		em.persist(item);
		etx.commit();
	}

	public T getById(Long id) {
		//JPAQL
		TypedQuery<T> q = em.createQuery("SELECT i FROM " + this.getClassType() + "i WHERE i.id = :id",this.getClassType());
		q.setParameter("id", id);
		return q.getSingleResult();
	}

	public List<T> getAll() {
		TypedQuery<T> q = em.createQuery("SELECT i FROM " + this.getClassType() + " i", this.getClassType());
		return q.getResultList();
	}
	 protected abstract Class<T> getClassType();
}
