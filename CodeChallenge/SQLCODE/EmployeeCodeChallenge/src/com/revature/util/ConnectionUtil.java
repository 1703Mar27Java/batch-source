package com.revature.util;

import java.sql.*;

public class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "code";
		String password = "p4ssw0rd";
		return DriverManager.getConnection(url,username,password);
		
	}

}

