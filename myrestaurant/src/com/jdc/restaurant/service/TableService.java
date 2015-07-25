package com.jdc.restaurant.service;

import java.util.ArrayList;
import java.util.List;

import com.jdc.restaurant.model.Model;
import com.jdc.restaurant.model.OrderDetails;
import com.jdc.restaurant.model.Table;

public class TableService {
	
	private Model<Table> model;
	
	public TableService() {
		model = Table.getModel();
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
