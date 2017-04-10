package codingChallenges.WeekTwo.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException {
		String url, username, password;
		String filename = "src/codingChallenges/WeekTwo/properties";
		try {
			// start by reading in data from file
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			url = br.readLine();
			username = br.readLine();
			password = br.readLine();
			br.close();
			fr.close();
			return DriverManager.getConnection(url, username, password);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}
