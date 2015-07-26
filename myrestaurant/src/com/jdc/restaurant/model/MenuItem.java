package com.jdc.restaurant.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuItem implements Entity{

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

	@Override
	public String toString() {
		return menu;
	}

	@Override
	public String insertSql() {
		return "insert into menu_item (menu, price, category_id) values (?, ?, ?)";
	}

	@Override
	public void setParam(PreparedStatement stmt) throws SQLException {
		stmt.setString(1, menu);
		stmt.setInt(2, price);
		stmt.setInt(3, category_id);
	}
	
	public static MenuItem map(ResultSet rs) {
		
		try {
			MenuItem m = new MenuItem();
			m.setId(rs.getInt(1));
			m.setMenu(rs.getString(2));
			m.setPrice(rs.getInt(3));
			m.setCategory_id(rs.getInt(4));
			return m;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Model<MenuItem> getModel() {
		return BaseModel.getModel("menu_item", MenuItem::map);
	}

}
