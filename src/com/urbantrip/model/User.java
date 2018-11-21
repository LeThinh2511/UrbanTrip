package com.urbantrip.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class User {
	String email;
	String password;

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public User() {
	}
}
