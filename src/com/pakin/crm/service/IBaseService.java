package com.pakin.crm.service;
import java.util.List;

public interface IBaseService<T> {
	void save(T t);
	void update(T t);
	void delete(T t);
	List queryAll();
	T get(Long id);
}
