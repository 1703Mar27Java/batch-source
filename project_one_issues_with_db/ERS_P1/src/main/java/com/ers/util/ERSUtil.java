package com.ers.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class ERSUtil {

	public static Connection getConnectionFromFile() throws IOException, SQLException{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop = new Properties();
		FileInputStream in = new FileInputStream("C:\\Users\\Amelia\\Documents\\workspace-sts-3.8.3.RELEASE\\ERS_P1\\properties.txt");
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url,username,password);
	}
}
	
