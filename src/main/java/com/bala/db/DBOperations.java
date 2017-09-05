package com.bala.db;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bala.db.model.User;


@Repository
public class DBOperations {

	//private final Class<T> persistentClass;

	@PersistenceContext
	private EntityManager entityManager;
//
//	@SuppressWarnings("unchecked")
//	public DBOperations(){
//		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
//	}

	public EntityManager getEntityManager(){
		return this.entityManager;
	}

	public User getByKey(int key) {
		return (User) entityManager.find(User.class, key);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void persist(User entity) {
		entityManager.persist(entity);
	}

//	@Transactional
//	public void update(User entity) {
//		entityManager.merge(entity);
//	}
//
//	@Transactional
//	public void delete(User entity) {
//		entityManager.remove(entity);
//	}


}
