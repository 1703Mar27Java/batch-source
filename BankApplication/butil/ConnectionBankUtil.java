package com.revature.butil;

import java.sql.*;

public class ConnectionBankUtil {
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@dbtest.comzg99kksc7.us-west-2.rds.amazonaws.com:1521:ORCL";
		String username = "master";
		String password = "password";
		return DriverManager.getConnection(url,username,password);
	}
}
