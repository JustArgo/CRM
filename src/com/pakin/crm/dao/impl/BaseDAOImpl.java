package com.pakin.crm.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pakin.crm.dao.IBaseDAO;

public class BaseDAOImpl<T> implements IBaseDAO<T> {
	@PersistenceContext
	EntityManager em;
	Class<T> targetClass;
	public BaseDAOImpl(){
		//获取类型
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		targetClass = (Class<T>) type.getActualTypeArguments()[0];
	}
	@Override
	public void save(T t) {
		em.persist(t);
	}

	@Override
	public void update(T t) {
		em.merge(t);
	}

	@Override
	public void delete(T t) {
		em.remove(t);
	}

	@Override
	public List queryAll() {
		Query query = em.createQuery("FROM "+targetClass.getSimpleName());
		return query.getResultList();
	}

	@Override
	public T get(Long id) {
		return em.find(targetClass, id);
	}

}