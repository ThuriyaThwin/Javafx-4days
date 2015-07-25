package com.jdc.restaurant.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdc.restaurant.entity.Category;
import com.jdc.restaurant.entity.MenuItem;

public class MenuItemModel implements Model<MenuItem> {

	@Override
	public int create(MenuItem t) {
		try (Connection conn = ConnectionManager.getConnection();
				Statement stmt = conn.createStatement()) {
			return stmt.executeUpdate(t.getInsertSql());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public MenuItem find(Object id) {
		String sql = String.format("select * from menu_item where id = %d", id);
		try (Connection conn = ConnectionManager.getConnection();
				Statement stmt = conn.createStatement()) {
			ResultSet r = stmt.executeQuery(sql);

			while (r.next())
				return this.map(r);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private MenuItem map(ResultSet r) throws SQLException {
		MenuItem item = new MenuItem();
		item.setId(r.getInt(1));
		item.setMenu(r.getString(2));
		item.setPrice(r.getInt(3));
		item.setCategory_id(r.getInt(4));
		return item;
	}

	@Override
	public List<MenuItem> getAll() {
		List<MenuItem> list = new ArrayList<MenuItem>();
		String sql = "select * from menu_item";
		try (Connection conn = ConnectionManager.getConnection();
				Statement stmt = conn.createStatement()) {
			ResultSet r = stmt.executeQuery(sql);

			while (r.next()) {
				list.add(map(r));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void update(MenuItem t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub

	}
	
	public List<MenuItem> findByCategory(Category cat) {
		List<MenuItem> list = new ArrayList<MenuItem>();
		String sql = String.format("select * from menu_item where category_id = %d", cat.getId());
		try (Connection conn = ConnectionManager.getConnection();
				Statement stmt = conn.createStatement()) {
			ResultSet r = stmt.executeQuery(sql);

			while (r.next()) {
				list.add(map(r));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;		
	}

}
