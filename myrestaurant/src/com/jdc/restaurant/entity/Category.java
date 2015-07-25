package com.jdc.restaurant.entity;

public class Category {

	private int id;
	private String name;

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	private static final String table = "category";

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

	public String getInsertSql() {
		String sql = "insert into %s (name) values ('%s')";
		sql = String.format(sql, table, name);
		return sql;
	}

	@Override
	public String toString() {
		return name;
	}

}
