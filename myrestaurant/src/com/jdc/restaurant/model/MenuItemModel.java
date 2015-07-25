package com.jdc.restaurant.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MenuItemModel extends BaseModel<MenuItem> {

	private MenuItemModel(String tableName,
			Function<ResultSet, MenuItem> mapper) {
		super(tableName, mapper);
	}
	
	public static MenuItemModel getModel() {
		return new MenuItemModel("menu_item", MenuItem::map);
	}
	
	public List<MenuItem> findByCategory(Category cat) {
		
		List<MenuItem> list = new ArrayList<>();
		
		String sql = "select * from menu_item where category_id = ?";
		
		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, cat.getId());
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
				list.add(mapper.apply(rs));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
