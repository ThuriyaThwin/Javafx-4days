package com.jdc.fx.day2.ep2;

public class Browser {
	
	private String name;
	private String imgPath;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public Browser(String name, String imgPath) {
		super();
		this.name = name;
		this.imgPath = imgPath;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
