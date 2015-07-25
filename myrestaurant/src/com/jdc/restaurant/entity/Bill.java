package com.jdc.restaurant.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Bill {
	
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
	private LocalDateTime creation;
	private LocalDateTime modification;
	
	public String getInsertSql() {
		return "insert into bill (business_date, rtable_id, status, creation, modification) values (?, ?, ?, ?, ?)";
	}
	
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
}
