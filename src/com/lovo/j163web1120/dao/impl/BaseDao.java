package com.lovo.j163web1120.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	
	protected Connection conn;

	protected PreparedStatement ps;
	
	protected ResultSet rs;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void openConnection(){
		try {
		this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/abc?characterEncoding=utf8", "root", "123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void close(){
		try {
			
			if (rs != null) {
				rs.close();
			}
			
			if (ps != null) {
				ps.close();
			}
			
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
