package com.revature.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil  {
	public static final String url = "jdbc:oracle:thin:@testdb.c47gm5itniuf.us-west-2.rds.amazonaws.com:1521:ORCL";
	public static final String username = "master";
	public static final String password = "password";	

	public static Connection getConnection() throws Exception {
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection(url,username,password);
		conn.setAutoCommit(false);
		return conn;
		
	}

}
