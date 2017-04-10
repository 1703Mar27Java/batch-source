package com.pbjbank.util;

import java.io.*;
import java.sql.*;
import java.util.Properties;



public class ConnectionUtil {
	
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@pbjbank.ctct7rg6v32d.us-west-2.rds.amazonaws.com:1521:ORCL";
		String username = "Admin";
		String password = "siLLyboy";
		return DriverManager.getConnection(url,username,password);
	}
	
	
	public static Connection getConnectionFromFile() throws IOException, SQLException {
		
		Properties prop = new Properties();
		FileInputStream in = new FileInputStream("PB&J_Bank_Assignment/src/properties");
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url,username,password);
	}
}
