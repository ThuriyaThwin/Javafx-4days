package com.jdc.restaurant.service;

import java.util.List;

import com.jdc.restaurant.entity.Category;
import com.jdc.restaurant.model.CategoryModel;

public class CategoryService {
	
	private CategoryModel model;
	
	public CategoryService() {
		model = new CategoryModel();
	}
	
	public List<Category> getAllCategory() {
		return model.getAll();
	}

}
