package com.revature.util;

import java.sql.*;
import oracle.jdbc.OracleDriver;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException {
		//String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String url = "jdbc:oracle:thin:@ers.czlai49eatz0.us-west-2.rds.amazonaws.com:1521:ORCL";
		String username = "ersdb";
		String password = "p4ss";
		OracleDriver driver = new OracleDriver();
		DriverManager.registerDriver(driver);
		return DriverManager.getConnection(url, username, password);
	}
}