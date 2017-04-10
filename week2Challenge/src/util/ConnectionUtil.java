package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
		
		try {
			input = new FileInputStream("challenge.properties");
			prop.load(input);		
			conString = prop.getProperty("connection");
			username = prop.getProperty("conUsername");
			password = prop.getProperty("conPassword");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(conString, username, password);
	}
}
