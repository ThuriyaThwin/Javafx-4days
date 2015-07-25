package com.jdc.restaurant.service;

import java.util.List;

import com.jdc.restaurant.model.Category;
import com.jdc.restaurant.model.Model;

public class CategoryService {
	
	private Model<Category> model;
	
	public CategoryService() {
		model = Category.getModel();
	}
	
	public List<Category> getAllCategory() {
		return model.getAll();
	}

}
