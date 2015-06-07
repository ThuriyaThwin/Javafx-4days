package com.jdc.contact;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdc.jdbc.GeneratedEntity;
import com.jdc.jdbc.Param;

public class Contact implements GeneratedEntity {
	
	private long id;
	private String name;
	private String mobile;
	private String phone;
	private String address;

	@Override
	public Param id() {
		return Param.instance("id", id);
	}

	@Override
	public Param insert() {
		return Param.instance("name", name)
				.put("mobile", mobile)
				.put("phone", phone)
				.put("address", address);
	}

	@Override
	public void setId(long arg0) {
		this.id = arg0;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getId() {
		return id;
	}
	
	public static Contact map(ResultSet rs) {
		Contact c = new Contact();
		
		try {
			c.setId(rs.getLong("id"));
			c.setName(rs.getString("name"));
			c.setMobile(rs.getString("mobile"));
			c.setPhone(rs.getString("phone"));
			c.setAddress(rs.getString("address"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

}
