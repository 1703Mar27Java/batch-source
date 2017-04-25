package com.Revature.util;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class ConnectionUtil {
	public static Connection getConnectionFromFile(String filename) throws IOException, SQLException {
		Properties prop = new Properties();
		//InputStream in = new FileInputStream(filename);
		InputStream in = new FileInputStream("C:\\Users\\jrene\\Desktop\\Training\\ReimbursementSystem\\connection.properties");
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(url,username,password);
	}
}