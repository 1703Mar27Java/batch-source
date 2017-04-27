package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static final String conURL = "jdbc:oracle:thin:@testdb.ccr7b4olo7hr.us-west-2.rds.amazonaws.com:1521:ORCL";
	private static final String conName = "master";
	private static final String conPass = "p4ssw0rd";

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return DriverManager.getConnection(conURL, conName, conPass);

	}
}
