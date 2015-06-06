package com.jdc.fx.day2.ex1;

public class Contact {
	
	private String name;
	private String mobile;
	private String home;
	private String office;
	private String address;
	
	public Contact() {}
	
	public Contact(String line) {
		super();
		
		String [] strs = line.split("\t");
 		
		if(strs.length > 0)
			this.name = strs[0];
		
		if(strs.length > 1)
			this.mobile = strs[1];
		if(strs.length > 2)
			this.home = strs[2];
		if(strs.length > 3)
			this.office = strs[3];
		if(strs.length > 4)
			this.address = strs[4];
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toLine() {
		StringBuilder sb = new StringBuilder();
		sb.append(name).append("\t");
		sb.append(mobile).append("\t");
		sb.append(home).append("\t");
		sb.append(office).append("\t");
		sb.append(address);

		return sb.toString();
	}

}
