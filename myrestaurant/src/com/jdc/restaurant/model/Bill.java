package com.jdc.restaurant.model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jdc.restaurant.model.BaseModel.Param;


public class Bill implements Entity{
	
	public enum Status {
		
		ON(0), OFF(1);
		
		private int value;
		
		private Status(int value) {
			this.value = value;
		}
		
		public int value() {
			return value;
		}
		
		public static Status getStatus(int value) {
			Status [] data = Status.values();
			if(value < data.length) {
				return data[value];
			}
			
			return OFF;
		}
	}
	
	private int id;
	private LocalDate bDate;
	private Table table;
	private Status status;
	private int subTotal;
	private double tax;
	private double total;
	private LocalDateTime creation;
	private LocalDateTime modification;
	
	public Bill(Table table) {
		super();
		this.table = table;
		status = Status.ON;
		bDate = LocalDate.now();
		creation = LocalDateTime.now();
		modification = LocalDateTime.now();
	}

	public Bill() {
		status = Status.ON;
		bDate = LocalDate.now();
		creation = LocalDateTime.now();
		modification = LocalDateTime.now();
	}
	
	public int getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getbDate() {
		return bDate;
	}

	public void setbDate(LocalDate bDate) {
		this.bDate = bDate;
	}

	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getCreation() {
		return creation;
	}

	public void setCreation(LocalDateTime creation) {
		this.creation = creation;
	}

	public LocalDateTime getModification() {
		return modification;
	}

	public void setModification(LocalDateTime modification) {
		this.modification = modification;
	}

	@Override
	public String insertSql() {
		return "insert into bill (business_date, rtable_id, status, creation, modification) values (?, ?, ?, ?, ?)";
	}

	@Override
	public void setParam(PreparedStatement stmt) throws SQLException {
		stmt.setDate(1, Date.valueOf(bDate));
		stmt.setInt(2, table.getId());
		stmt.setInt(3, status.value());
		stmt.setTimestamp(4, Timestamp.valueOf(creation));
		stmt.setTimestamp(5, Timestamp.valueOf(modification));
	}
	
	public static Bill map(ResultSet rs) {
		
		try {
			Bill bill = new Bill();
			
			bill.setId(rs.getInt(1));
			bill.setbDate(rs.getDate(2).toLocalDate());
			bill.setTable(Table.getModel().find(Param.param("id", rs.getInt(3))));
			bill.setStatus(Status.getStatus(rs.getInt(4)));
			bill.setSubTotal(rs.getInt(5));
			bill.setTax(rs.getDouble(6));
			bill.setTotal(rs.getDouble(7));
			bill.setCreation(rs.getTimestamp(8).toLocalDateTime());
			bill.setModification(rs.getTimestamp(9).toLocalDateTime());
					
			return bill;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Model<Bill> getModel() {
		return BaseModel.getModel("bill", Bill::map);
	}
}
