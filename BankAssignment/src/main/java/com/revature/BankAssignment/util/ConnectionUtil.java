package com.revature.BankAssignment.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException{
		String url= "jdbc:oracle:thin:@localhost:1521:xe";
		String username="BankAssignment";
		String password="BankAssignment";
		return DriverManager.getConnection(url,username,password);
	}
}
