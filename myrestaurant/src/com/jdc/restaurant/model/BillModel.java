package com.jdc.restaurant.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.jdc.restaurant.entity.Bill;
import com.jdc.restaurant.entity.Bill.Status;

public class BillModel implements Model<Bill> {
	
	private TableModel tableModel;
	
	public BillModel() {
		tableModel = new TableModel();
	}

	@Override
	public int create(Bill t) {
		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(t.getInsertSql())) {
			stmt.setDate(2, Date.valueOf(t.getbDate()));
			stmt.setInt(3, t.getTable().getId());
			stmt.setInt(4, t.getStatus().value());
			stmt.setTimestamp(5, Timestamp.valueOf(t.getCreation()));
			stmt.setTimestamp(6, Timestamp.valueOf(t.getModification()));
			
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Bill find(Object id) {
		
		String sql = "select * from bill where id = ?";
		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setInt(1, Integer.valueOf(id.toString()));
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
				return map(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	private Bill map(ResultSet rs) throws SQLException {
		
		Bill bill = new Bill();
		
		bill.setId(rs.getInt(1));
		bill.setbDate(rs.getDate(2).toLocalDate());
		bill.setTable(tableModel.find(rs.getInt(3)));
		bill.setStatus(Status.getStatus(rs.getInt(4)));
		bill.setCreation(rs.getTimestamp(5).toLocalDateTime());
		bill.setModification(rs.getTimestamp(6).toLocalDateTime());
		
		return bill;
	}

	@Override
	public List<Bill> getAll() {
		
		List<Bill> list = new ArrayList<Bill>();
		String sql = "select * from bill";
		try(Connection conn = ConnectionManager.getConnection();
				Statement stmt = conn.createStatement()) {
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(map(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return list;
	}

	@Override
	public void update(Bill t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		
	}

}
