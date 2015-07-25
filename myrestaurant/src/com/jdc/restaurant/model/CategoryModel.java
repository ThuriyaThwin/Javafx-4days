package com.jdc.restaurant.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdc.restaurant.entity.Category;

public class CategoryModel implements Model<Category> {

	@Override
	public int create(Category t) {
		String sql = t.getInsertSql();

		try (Connection conn = ConnectionManager.getConnection();
				Statement stmt = conn.createStatement()) {

			return stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Category find(Object id) {
		String sql = String.format("select * from category where id = %d", id);

		try (Connection conn = ConnectionManager.getConnection();
				Statement stmt = conn.createStatement()) {

			ResultSet res = stmt.executeQuery(sql);

			while (res.next())
				return this.map(res);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Category map(ResultSet res) throws SQLException {
		Category cat = new Category();
		cat.setId(res.getInt(1));
		cat.setName(res.getString(2));
		return cat;
	}

	@Override
	public List<Category> getAll() {

		List<Category> list = new ArrayList<Category>();

		// define sql
		String sql = "select * from category";

		// get connection and crete statement
		try (Connection conn = ConnectionManager.getConnection();
				Statement stmt = conn.createStatement()) {
			// execute query
			ResultSet res = stmt.executeQuery(sql);
			
			// get data from result set
			while(res.next())
				list.add(this.map(res));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void update(Category t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub

	}

}
