package com.jdc.restaurant.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.jdc.restaurant.model.BaseModel.Param;

public class Order implements Entity{
	
	private int id;
	private LocalDateTime odTime;
	private Bill bill;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		odTime = LocalDateTime.now();
	}
	
	public LocalDateTime getOdTime() {
		return odTime;
	}
	public void setOdTime(LocalDateTime odTime) {
		this.odTime = odTime;
	}
	public Order() {
		odTime = LocalDateTime.now();
	}

	@Override
	public String insertSql() {
		return "insert into `order` (bill_id, od_time) values (?, ?)";
	}

	@Override
	public void setParam(PreparedStatement stmt) throws SQLException {
		stmt.setInt(1, bill.getId());
		stmt.setTimestamp(2, Timestamp.valueOf(odTime));;
	}
	
	public static Order map(ResultSet rs) {
		try {
			Order o = new Order();
			o.setId(rs.getInt(1));
			o.setBill(Bill.getModel().find(Param.param("id", rs.getInt(2))));
			o.setOdTime(rs.getTimestamp(3).toLocalDateTime());
			
			return o;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Model<Order> getModel() {
		return BaseModel.getModel("`order`", Order::map);
	}
	
}
