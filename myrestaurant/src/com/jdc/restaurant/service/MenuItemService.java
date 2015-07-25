package com.jdc.restaurant.service;

import java.util.List;

import com.jdc.restaurant.model.Category;
import com.jdc.restaurant.model.MenuItem;
import com.jdc.restaurant.model.MenuItemModel;

public class MenuItemService {
	
	private MenuItemModel model;
	
	public MenuItemService() {
		model = MenuItemModel.getModel();
	}
	
	public List<MenuItem> getMenu(Category cat) {
		if(null == cat) {
			return model.getAll();
		}
		
		return model.findByCategory(cat);
	}

}
