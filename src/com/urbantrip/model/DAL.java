package com.urbantrip.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DAL {
	Connection conn;
	Statement stsm;
	
	public DAL () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/urbantrip", "root", "kyphong1997");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public ResultSet getData(String sql) {
		stsm = null;
		System.out.println(" ever been there");
		try {
			stsm = conn.createStatement();
			System.out.println(stsm.executeQuery(sql) + "");
			return stsm.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateData(String sql) {
		stsm = null;
		try {
			stsm = conn.createStatement();
			return stsm.executeUpdate(sql) > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}