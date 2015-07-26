package com.jdc.restaurant.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;

public class BaseModel<T extends Entity> implements Model<T> {

	protected String tableName;
	protected Function<ResultSet, T> mapper;

	static <T extends Entity> BaseModel<T> getModel(String tableName,
			Function<ResultSet, T> mapper) {
		return new BaseModel<>(tableName, mapper);
	}

	protected BaseModel(String tableName, Function<ResultSet, T> mapper) {
		super();
		this.tableName = tableName;
		this.mapper = mapper;
	}

	@Override
	public int create(T t) {
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(t.insertSql())) {
			t.setParam(stmt);
			return stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public T find(Param param) {
		String sql = String.format("%s where %s", getSelectSql(), param.where());
		try(Connection conn = ConnectionManager.getConnection();
				Statement stmt = conn.createStatement()) {
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
				return mapper.apply(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public List<T> getAll() {
		List<T> list = new ArrayList<>();
 		String sql = this.getSelectSql();
		try(Connection conn = ConnectionManager.getConnection();
				Statement stmt = conn.createStatement()) {
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
				list.add(mapper.apply(rs));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return list;
	}

	private String getSelectSql() {
		return String.format("select * from %s", tableName);
	}

	@Override
	public void update(String set, String where, List<Object> param) {
		String sql = String.format("update %s set %s where %s", tableName, set, where);
		
		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			for(int i = 0; i < param.size(); i++) {
				stmt.setObject(i + 1, param.get(i));
			}
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Param param) {
		// TODO Auto-generated method stub
		
	}
	
	public static class Param {
		private HashMap<String, Object> param;

		private Param(String key, Object value) {
			param = new HashMap<String, Object>();
			param.put(key, value);
		}

		public static Param param(String key, Object value) {
			return new Param(key, value);
		}

		public Param put(String key, Object value) {
			param.put(key, value);
			return this;
		}

		public String where() {
			
			StringBuffer sb = new StringBuffer();
			List<Entry<String, Object>> list = new ArrayList<Entry<String,Object>>(param.entrySet());
			
			for(int i = 0; i < list.size(); i++) {
				Entry<String, Object> p = list.get(i);
				sb.append(p.getKey()).append(" = ");
				sb.append(getParamValue(p.getValue()));
				
				if(i < list.size() - 1) {
					sb.append("AND ");
				}
			}
			return sb.toString();
		}

		private Object getParamValue(Object value) {
			if(value instanceof String) {
				return "'"+value + "' ";
			}
			return String.valueOf(value) + " ";
		}
	}

	@Override
	public List<T> getWhere(String where, List<Object> param) {
		List<T> list = new ArrayList<>();
		String sql = String.format("%s where %s", this.getSelectSql(), where);
		
		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			// set parameter
			for(int i=0; i < param.size(); ) {
				Object obj = param.get(i);
				stmt.setObject(++i, obj);
			}
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				list.add(mapper.apply(rs));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}


}
