package com.jdc.restaurant.entity;

public class OrderDetails {
	
	private int menuId;
	private int count;
	private MenuItem menu;
	
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
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
		this.menuId = menu.getId();
	}

}
