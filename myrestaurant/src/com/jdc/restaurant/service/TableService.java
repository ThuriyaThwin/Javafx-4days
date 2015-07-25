package com.jdc.restaurant.service;

import java.util.List;

import com.jdc.restaurant.entity.Table;
import com.jdc.restaurant.model.TableModel;

public class TableService {
	
	private TableModel model;
	
	public TableService() {
		model = new TableModel();
	}
	
	public List<Table> getAllTable() {
		return model.getAll();
	}

}
