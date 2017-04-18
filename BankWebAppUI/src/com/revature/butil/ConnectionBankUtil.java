package com.revature.butil;

import java.sql.*;
import java.util.Properties;

public class ConnectionBankUtil {
	public static Connection getConnection() throws SQLException {
		Properties prop = new Properties();
		String url = "jdbc:oracle:thin:@dbtest.comzg99kksc7.us-west-2.rds.amazonaws.com:1521:ORCL";
		String username = "master";
		String password = "password";
		return DriverManager.getConnection(url,username,password);
	}
}
