package com.revature.BankAssignment.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException{
		
		
		Properties prop=new Properties();
		FileOutputStream output = null;
		try {
			output = new FileOutputStream("config.properties");
			String url= "jdbc:oracle:thin:@localhost:1521:xe";
			String username="BankAssignment";
			String password="BankAssignment";
			prop.setProperty("Databaseurl", url);
			prop.setProperty("Databaseusername", username);
			prop.setProperty("Databasepassword", password);
			prop.setProperty("SuperUserName", "SuperUser");
			prop.setProperty("SuperUserPassword", "SuperUser");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		try {
			prop.store(output,null);
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		FileInputStream input;
		try {
			input = new FileInputStream("config.properties");
			prop.load(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return DriverManager.getConnection(prop.getProperty("Databaseurl"),prop.getProperty("Databaseusername"),prop.getProperty("Databasepassword"));
	}
}
