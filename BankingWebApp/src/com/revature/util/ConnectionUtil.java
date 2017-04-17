package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException {
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			
		}catch(ClassNotFoundException c)
		{
			c.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "bankmaster";
		String password = "bank1234";
		return DriverManager.getConnection(url,username,password);
		
	}
	
	public static Connection getConnectionFromFile(String filename) throws IOException, SQLException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url,username,password);
	}

}
