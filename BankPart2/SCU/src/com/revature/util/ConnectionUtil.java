package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException{
		Properties prop = new Properties();
		InputStream input = null;
		String conString = null;
		String username = null;
		String password = null;
		
		try {
			//input = new FileInputStream("D:\\Revature\\workspace\\SCU\\bank.properties");
			//prop.load(input);		
			//conString = prop.getProperty("connection");
			//username = prop.getProperty("conUsername");
			//password = prop.getProperty("conPassword");
			Class.forName("oracle.jdbc.OracleDriver");
		//} catch (FileNotFoundException e) {
		//	e.printStackTrace();
		//} catch (IOException e) {
		//	e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		conString = "jdbc:oracle:thin:@testdb.coppuy0gntmu.us-west-2.rds.amazonaws.com:1521:ORCL";
		username ="master"; 
		password = "password";
		return DriverManager.getConnection(conString, username, password);
	}

}
