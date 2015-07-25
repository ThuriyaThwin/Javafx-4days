package com.jdc.restaurant.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdc.restaurant.model.BaseModel.Param;

public class OrderDetails implements Entity{
	
	private int id;
	private int count;
	private MenuItem menu;
	private Order order;
	
	public OrderDetails() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
		
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public MenuItem getMenu() {
		return menu;
	}
	public void setMenu(MenuItem menu) {
		this.menu = menu;
	}
	
	public OrderDetails(int count, MenuItem menu) {
		super();
		this.count = count;
		this.menu = menu;
	}

	@Override
	public String insertSql() {
		return "insert into order_details (menu_item_id, order_id, count) values (?, ?, ?)";
	}

	@Override
	public void setParam(PreparedStatement stmt) throws SQLException {
		stmt.setInt(1, menu.getId());
		stmt.setInt(2, order.getId());
		stmt.setInt(3, count);
	}
	
	public static OrderDetails map(ResultSet rs) {
		
		try {
			OrderDetails o = new OrderDetails();
			o.setId(rs.getInt(1));
			o.setMenu(MenuItem.getModel().find(Param.param("id", rs.getInt(2))));
			o.setOrder(Order.getModel().find(Param.param("id", rs.getInt(3))));
			o.setCount(rs.getInt(4));
			return o;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Model<OrderDetails> getModel() {
		return BaseModel.getModel("order_details", OrderDetails::map);
	}

}
