package com.jdc.restaurant.entity;

public class MenuItem {

	private int id;
	private String menu;
	private int price;
	private int category_id;

	public MenuItem() {
	}

	public MenuItem(String menu, int price, int category_id) {
		super();
		this.menu = menu;
		this.price = price;
		this.category_id = category_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getInsertSql() {
		return String
				.format("insert into menu_item (menu, price, category_id) values ('%s', %d, %d)",
						menu, price, category_id);
	}
	
	@Override
	public String toString() {
		return menu;
	}

}
