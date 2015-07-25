package com.jdc.restaurant.service;

import java.util.ArrayList;
import java.util.List;

import com.jdc.restaurant.entity.OrderDetails;
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
	
	public List<OrderDetails> getActiveOrdersForTable(Table t) {
		List<OrderDetails> list = new ArrayList<OrderDetails>();
		
		// TODO
		// get bill by table
		
		// get order by bill
		
		// get details by order
		
		return list;
	}

}
