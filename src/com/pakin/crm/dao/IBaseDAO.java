package com.pakin.crm.dao;

import java.util.List;

public interface IBaseDAO<T> {
	void save(T t);

	void update(T t);

	void delete(T t);

	List queryAll();

	T get(Long id);

}
