package com.jdc.restaurant.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	
	private static String url = "jdbc:mysql://127.0.0.1:3306/myrest";
	private static String user = "restuser";
	private static String pass = "restuser";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}
	
	public static void truncate(String ... tables) {
		try(Connection conn = getConnection();
				Statement stmt = conn.createStatement()) {
			
			stmt.execute("SET FOREIGN_KEY_CHECKS=0");
			
			for(String s : tables) {
				stmt.execute(String.format("truncate table %s", s));
			}
			
			stmt.execute("SET FOREIGN_KEY_CHECKS=1");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
