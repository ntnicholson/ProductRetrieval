package com.dal;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {

	Connection conn = null;
	
	public DBCon()
	{
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			System.out.println("Connection established");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		System.out.println("Connection returned");
		return conn;
	}
	
}
