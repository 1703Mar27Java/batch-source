package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException{
		/*
		 * CREATE USER challenge
			IDENTIFIED BY p4ssw0rd
			DEFAULT TABLESPACE users
		TEMPORARY TABLESPACE temp
		QUOTA 10M ON users;
		conn challenge/p4ssw0rd
		 * 
		 */
	
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "challenge";
		String password = "p4ssw0rd";
		return DriverManager.getConnection(url, username, password);
	}
}
