package com.revature.util;

import java.sql.*;

//gabesdb.cjtggskfwx5n.us-west-2.rds.amazonaws.com

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException{
		String url = "jdbc:oracle:thin:@gabesdb.cjtggskfwx5n.us-west-2.rds.amazonaws.com:1521:orcl";
		String username = "Master";
		String password = "bErtenjourney7";
		return DriverManager.getConnection(url, username, password);
	}
}
