package com.jdc.restaurant.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public interface Entity {
	
	String insertSql();
	void setParam(PreparedStatement stmt) throws SQLException;

}
