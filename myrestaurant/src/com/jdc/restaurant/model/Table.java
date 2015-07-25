package com.jdc.restaurant.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Table implements Entity{
	
	private int id;
	private String tableNumber;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	@Override
	public String toString() {
		return tableNumber;
	}
	
	public Table() {
	}
	
	public Table(String tableNumber) {
		super();
		this.tableNumber = tableNumber;
	}
	@Override
	public String insertSql() {
		return "insert into rtable (table_number) values (?)"; 
	}
	@Override
	public void setParam(PreparedStatement stmt) throws SQLException {
		stmt.setString(1,tableNumber);
	}
	
	public static Table map(ResultSet rs) {
		try {
			Table t = new Table();
			t.setId(rs.getInt(1));
			t.setTableNumber(rs.getString(2));
			return t;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Model<Table> getModel() {
		return BaseModel.getModel("rtable", Table::map);
	}

}
