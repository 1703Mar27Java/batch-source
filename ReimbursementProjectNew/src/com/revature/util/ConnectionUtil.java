package com.revature.util;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@roberttestdb.czyviorekvlp.us-west-2.rds.amazonaws.com:1521:ORCL";
		String username = "master";
		String password = "p4ssw0rd";
		return DriverManager.getConnection(url,username,password);
	}
	public static Connection getConnectionFromFile(String filename) throws IOException, SQLException, ClassNotFoundException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection(url,username,password);
	}
}