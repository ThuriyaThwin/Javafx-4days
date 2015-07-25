package com.jdc.restaurant.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Category implements Entity{

	private int id;
	private String name;

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public String insertSql() {
		return "insert into category (name) values (?)";
	}

	@Override
	public void setParam(PreparedStatement stmt) throws SQLException {
		stmt.setString(1, name);
	}
	
	public static Category map(ResultSet res) {
		try {
			Category cat = new Category();
			cat.setId(res.getInt(1));
			cat.setName(res.getString(2));
			return cat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Model<Category> getModel() {
		return BaseModel.getModel("category", Category::map);
	}
}
