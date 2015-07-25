package com.jdc.restaurant.model;

import java.util.List;

import com.jdc.restaurant.model.BaseModel.Param;

public interface Model<T extends Entity> {
	int create(T t);
	T find(Param id);
	List<T> getAll();
	void update(String set, String where, List<Object> param);
	void delete(Param param);
}
