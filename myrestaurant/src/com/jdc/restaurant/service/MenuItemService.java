package com.jdc.restaurant.service;

import java.util.List;

import com.jdc.restaurant.entity.Category;
import com.jdc.restaurant.entity.MenuItem;
import com.jdc.restaurant.model.MenuItemModel;

public class MenuItemService {
	
	private MenuItemModel model;
	
	public MenuItemService() {
		model = new MenuItemModel();
	}
	
	public List<MenuItem> getMenu(Category cat) {
		if(null == cat) {
			return model.getAll();
		}
		
		return model.findByCategory(cat);
	}

}
