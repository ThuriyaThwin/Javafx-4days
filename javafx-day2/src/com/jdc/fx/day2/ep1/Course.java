package com.jdc.fx.day2.ep1;

public class Course {
	
	private String name;
	private int price;
	private int duration;
	private String description;
	
	public Course(String line) {
		String [] strs = line.split("\t");
		if(strs.length == 4) {
			name = strs[0];
			price = Integer.parseInt(strs[1]);
			duration = Integer.parseInt(strs[2]);
			description = strs[3];
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Course(String name, int price, int duration, String description) {
		super();
		this.name = name;
		this.price = price;
		this.duration = duration;
		this.description = description;
	}
	
	public Course() {
		name = "Course of JDC";
	}
	
}
