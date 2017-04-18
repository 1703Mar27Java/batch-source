package com.revature.util;

import java.sql.*;

//gabesdb.cjtggskfwx5n.us-west-2.rds.amazonaws.com

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException{
		String url = "jdbc:oracle:thin:@gabesdb.cjtggskfwx5n.us-west-2.rds.amazonaws.com:1521:ORCL";
		String username = "Master";
		String password = "bErtenjourney7";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DriverManager.getConnection(url, username, password);
	}
}
