package com.revature.Dao;

import java.io.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.Domain.Bank;
import com.revature.Domain.User;
import com.revature.Main.Main;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public void loginUser(User user) {

		try {
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");

			String sql = "SELECT * FROM BANK_USER ORDER BY BANK_USER_ID";
			PreparedStatement pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			// pstmt.setInt(1, user.getUserID());

			ResultSet rs = pstmt.executeQuery();
			int successfulLogin = 0;

			while (rs.next()) {

				String userName = rs.getString(2);
				String passWord = rs.getString(3);
				String superUser = rs.getString(4);

				if (user.userName.contentEquals(userName) & user.Password.contentEquals(passWord)) {
					user.setUserID(rs.getInt(1));
					if (superUser.charAt(0) == 'y')
						user.setSuperUser(true);
					else
						user.setSuperUser(false);
					System.out.println("Logged in as: " + user.getUserName());
					successfulLogin = 1;
					break;
				}
			}

			if (successfulLogin == 0) {
				System.out.println("\n\nIncorrect Username or Password\n\n");
				Main.main(null);
			}
			else
				Main.onceLoggedIn(user);

		} catch (SQLException | IOException e) {
			e.printStackTrace();

		}

	}

	@Override
	public void logOut() {
		Main.main(null);
	}

	@Override
	public void createUser(User user) {

		try {
		
			//List<User> users = retrieveAll();

			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");

			String sql = "SELECT * FROM BANK_USER ORDER BY BANK_USER_ID";
			PreparedStatement pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int Id = rs.getInt(1);
				String userName = rs.getString(2);
				String passWord = rs.getString(3);
				String superUser = rs.getString(4);
				Boolean status;
				if(superUser.charAt(0) =='y')
					status = true;
				else
					status = false;

				if (user.userName.contentEquals(userName) & user.Password.contentEquals(passWord)) {
					System.out.println("That account already exist....\nLogging in now...");
					User temp = new User(Id, userName, passWord, status);
					loginUser(temp);
				}
			}

			String name = user.getUserName();
			String pass = user.getPassword();
			String sql2 = "INSERT INTO BANK_USER (BANK_USERNAME,BANK_PASSWORD, USER_SUPER_STATUS) VALUES (?,?,?)";
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			if (user.getSuperUser())
				pstmt.setString(3, "y");
			else
				pstmt.setString(3, "n");

			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected);

		} catch (SQLException | IOException e) {
			e.printStackTrace();

		}

	}

	@Override
	public List<User> retrieveAll() {
		List<User> users = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");

			String sql = "SELECT * FROM BANK_USER";
			PreparedStatement pstmt = con.prepareStatement(sql);

			int count = 0;
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				count++;
				int id = rs.getInt("BANK_USER_ID");
				String name = rs.getString("BANK_USERNAME");
				String pass = rs.getString("BANK_PASSWORD");
				String status = rs.getString("USER_SUPER_STATUS");
				Boolean superU = false;
				if (status.charAt(0) == 'y')
					superU = true;
				User c = new User(id, name, pass, superU);
				users.add(c);

				
				System.out.println(
						count + ") " + "UserName: " + name + "\tPassword: " + pass + "\t\tSuperUser: " + superU);
			}
			if (count < 1)
				System.out.println("You have no Bank Accounts yet");

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public void uppdateUser(User user) {

		System.out.println("Which account would you like to Update....");
		List<User> users = retrieveAll();

		Scanner sc = new Scanner(System.in);

		int choiceForUser = sc.nextInt();
		User chosenUser = users.get(choiceForUser - 1);

		System.out.println("What would you like to Update?");
		System.out.println("1) Username");
		System.out.println("2) Password");
		System.out.println("3) SuperStatus");

		int choiceForAction = sc.nextInt();

		switch (choiceForAction) {
		case 1:
			System.out.println("What would you like the Username to be changed to?");
			String newName = sc.next();

			try {
				Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");

				String sql = "UPDATE BANK_USER SET BANK_USERNAME = (?) WHERE BANK_USER_ID = (?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, newName);
				pstmt.setInt(2, chosenUser.getUserID());
				chosenUser.setUserName(newName);
				pstmt.executeUpdate();
				System.out.println("Username changed");

			} catch (SQLException | IOException e) {
				e.printStackTrace();

			}
			break;
		case 2:
			System.out.println("What would you like the Passwprd to be changed to?");
			String newPass = sc.next();

			try {
				Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");

				String sql = "UPDATE BANK_USER SET BANK_PASSWORD = (?) WHERE BANK_USER_ID = (?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, newPass);
				pstmt.setInt(2, chosenUser.getUserID());
				chosenUser.setPassword(newPass);
				pstmt.executeUpdate();
				System.out.println("Password changed");

			} catch (SQLException | IOException e) {
				e.printStackTrace();

			}
			break;
		case 3:
			try {
				Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");

				String sql = "UPDATE BANK_USER SET USER_SUPER_STATUS = (?) WHERE BANK_USER_ID = (?)";
				PreparedStatement pstmt = con.prepareStatement(sql);

				String temp = String.valueOf('n');
				String temp2 = String.valueOf('y');

				if (chosenUser.getSuperUser())
					pstmt.setString(1, temp);
				else
					pstmt.setString(1, temp2);

				pstmt.setInt(2, chosenUser.getUserID());

				chosenUser.setSuperUser(!chosenUser.getSuperUser());

				pstmt.executeUpdate();
				System.out.println("Super Status changed");

			} catch (SQLException | IOException e) {
				e.printStackTrace();

			}
			break;
		default:
			uppdateUser(user);
		}

		retrieveAll();
		Main.onceLoggedIn(user);

	}

	@Override
	public void deleteAll() {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");

			String sql = "DELETE FROM BANK_ACCOUNT";
			PreparedStatement pstmt = con.prepareStatement(sql);
			int numRowsAffected = pstmt.executeUpdate();

			String sql2 = "DELETE FROM BANK_USER";
			pstmt = con.prepareStatement(sql2);
			pstmt.executeUpdate();

		} catch (SQLException | IOException e) {
			e.printStackTrace();

		}
		Main.main(null);
		;
	}

	@Override
	public void Display() {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");

			String sql = "CREATE OR REPLACE PROCEDURE GETUSER (USERID IN NUMBER, USERNAME OUT VARCHAR) AS BEGIN SELECT BANK_USERdNAME INTO USERNAME FROM BANK_USER WHERE USERID = BANK_USER_ID; END";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();

			String results = "";
			CallableStatement cStmt;
			cStmt = con.prepareCall("{call GETUSER(?, ?)}");
			cStmt.setInt(1, 1);

			cStmt.registerOutParameter(2, Types.VARCHAR);
			cStmt.registerOutParameter(results, Types.VARCHAR);

			cStmt.executeQuery();
			System.out.println(results);
		} catch (SQLException | IOException e) {
			e.printStackTrace();

		}

	}

}
