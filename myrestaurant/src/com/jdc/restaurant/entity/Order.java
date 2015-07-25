package com.jdc.restaurant.entity;

import java.util.Date;

public class Order {
	
	private int id;
	private Date odTime;
	private Bill bill;
	
	public String getInsertSql() {
		return "insert into order (bill_id, od_time) values (?, ?)";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getOdTime() {
		return odTime;
	}
	public void setOdTime(Date odTime) {
		this.odTime = odTime;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Order(Bill bill) {
		super();
		this.bill = bill;
		odTime = new Date();
	}
	
	public Order() {
		odTime = new Date();
	}
	
}
