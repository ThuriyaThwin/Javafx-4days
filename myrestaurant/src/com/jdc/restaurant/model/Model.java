package com.jdc.restaurant.model;

import java.util.List;

public interface Model<T> {
	int create(T t);
	T find(Object id);
	List<T> getAll();
	void update(T t);
	void delete(Object id);
}
