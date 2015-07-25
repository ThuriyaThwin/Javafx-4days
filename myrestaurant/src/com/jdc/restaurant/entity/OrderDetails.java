package com.jdc.restaurant.entity;

public class OrderDetails {
	
	private int count;
	private MenuItem menu;
	private Order order;
	
	public String getInsertSql() {
		return "insert into order_details (menu_item_id, order_id, count) values (?, ?, ?)";
	}
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
		
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public MenuItem getMenu() {
		return menu;
	}
	public void setMenu(MenuItem menu) {
		this.menu = menu;
	}
	
	public OrderDetails(int count, MenuItem menu) {
		super();
		this.count = count;
		this.menu = menu;
	}

}
