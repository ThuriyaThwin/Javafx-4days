package com.jdc.restaurant.service;

import java.util.Arrays;
import java.util.List;

import com.jdc.restaurant.model.Category;
import com.jdc.restaurant.model.MenuItem;
import com.jdc.restaurant.model.Model;

public class MenuItemService {

	private Model<MenuItem> model;

	public MenuItemService() {
		model = MenuItem.getModel();
	}

	public List<MenuItem> getMenu(Category cat) {
		if (null == cat) {
			return model.getAll();
		}

		return model.getWhere("category_id", Arrays.asList(cat.getId()));
	}

}
