package com.jdc.restaurant.entity;

public class Table {
	
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
	
	public String getInsertSql() {
		return String.format("insert into rtable (table_number) values ('%s')", tableNumber); 
	}
	public Table(String tableNumber) {
		super();
		this.tableNumber = tableNumber;
	}

}
