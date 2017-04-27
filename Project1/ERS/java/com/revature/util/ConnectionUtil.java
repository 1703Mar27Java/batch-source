package com.revature.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionUtil {

	public static Connection getConnection() throws SQLException{
		Properties prop = new Properties();
		InputStream input = null;
		String conString = null;
		String username = null;
		String password = null;
		String driver = null;
		
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			input = classLoader.getResourceAsStream("ers.properties");
			prop.load(input);		
			conString = prop.getProperty("connection");
			username = prop.getProperty("conUsername");
			password = prop.getProperty("conPassword");
			driver = prop.getProperty("driver");
			Class.forName(driver);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(conString, username, password);
	}
	
	
}
