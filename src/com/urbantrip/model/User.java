package com.urbantrip.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class User {
	DAL dal;
	
	public User () {
		dal = new DAL();
	}
	
	public ResultSet getListUser() {
		return dal.getData("select * from urbantrip.user");
		
	} 
	
	}
