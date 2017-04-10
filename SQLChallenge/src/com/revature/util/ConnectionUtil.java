package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionUtil {
	
	
	
	
	
	public static Connection getConnection() throws SQLException{
		
		
		
		

		Properties prop=new Properties();
		
		String url="";
		String username="";
		String password="";
		
		try {
			
			FileOutputStream output = new FileOutputStream("config.properties");
			prop.setProperty("url", "jdbc:oracle:thin:@localhost:1521:xe");
			prop.setProperty("username", "CODECHALLENGE");
			prop.setProperty("password", "password");
			
			prop.store(output,null);
			output.close();
			
			FileInputStream input=new FileInputStream("config.properties");
			prop.load(input);
			url=prop.getProperty(url);
			username=prop.getProperty(username);
			password=prop.getProperty(password);
			
			input.close();
			//System.out.println(prop.getProperty("SuperUserName"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return DriverManager.getConnection(url,username,password);
	}

}
