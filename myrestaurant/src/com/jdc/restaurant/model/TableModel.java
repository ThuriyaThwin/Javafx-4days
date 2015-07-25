package com.jdc.restaurant.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdc.restaurant.entity.Table;

public class TableModel implements Model<Table> {

	@Override
	public int create(Table t) {
		try(Connection conn = ConnectionManager.getConnection();
				Statement stmt = conn.createStatement()) {
			return stmt.executeUpdate(t.getInsertSql());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Table find(Object id) {
		String sql = String.format("select * from rtable where id = %d", id);
		
		try(Connection conn = ConnectionManager.getConnection();
				Statement stmt = conn.createStatement()) {
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
				return map(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private Table map(ResultSet rs) throws SQLException {
		Table table = new Table();
		table.setId(rs.getInt(1));
		table.setTableNumber(rs.getString(2));
		return table;
	}

	@Override
	public List<Table> getAll() {
		
		List<Table> list = new ArrayList<Table>();
		String sql = "select * from rtable";
		
		try(Connection conn = ConnectionManager.getConnection();
				Statement stmt = conn.createStatement()) {
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
				list.add(map(rs));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void update(Table t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		
	}

}
