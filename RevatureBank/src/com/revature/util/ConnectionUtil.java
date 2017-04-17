package com.revature.util;

import java.io.*;
import java.sql.*;
//import java.util.*;

public class ConnectionUtil {
	public static Connection getConnection() throws IOException, SQLException {
		//Properties prop = new Properties();
		//InputStream in = new FileInputStream("connection.properties");
		try {
			//prop.load(in);
			//String url = prop.getProperty("url");
			//String username = prop.getProperty("username");
			//String password = prop.getProperty("password");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="BankDB";
			String password="p4ssw0rd";
			return DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
	        return null;
	    }
	}
}