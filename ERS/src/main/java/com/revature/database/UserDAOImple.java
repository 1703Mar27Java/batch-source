package com.revature.database;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.beans.User;

public class UserDAOImple implements UserDAO {
	private Connection conn;
	public UserDAOImple(Connection conn){
		this.conn = conn;
	}

	public User getUserbyID(int userID) throws SQLException {
		User user = new User();
		
		String sql = "SELECT U.ERS_USERS_ID, U.ERS_USERNAME, U.ERS_PASSWORD, U.USER_FIRST_NAME, "
				   + "U.USER_LAST_NAME, U.USER_EMAIL, U.USER_ROLE_ID, R.USER_ROLE FROM ERS_USERS U "
				   + "INNER JOIN ERS_USER_ROLES R "
				   + "ON U.USER_ROLE_ID = R.ERS_USER_ROLE_ID "
				   + "WHERE U.ERS_USERS_ID = ?";
		
		PreparedStatement pstmt;
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, userID);
		pstmt.executeQuery();
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			user.setUserID(rs.getInt("ERS_USERS_ID"));
			user.setUserName(rs.getString("ERS_USERNAME"));
			user.setPassword(rs.getString("ERS_PASSWORD"));
			user.setFirstName(rs.getString("USER_FIRST_NAME"));
			user.setLastName(rs.getString("USER_LAST_NAME"));
			user.setEmail(rs.getString("USER_EMAIL"));
			user.setUserRoleID(rs.getInt("USER_ROLE_ID"));
			user.setUserRole(rs.getInt("USER_ROLE_ID"),rs.getString("USER_ROLE"));
		}
		
		return user;
	}

	public User getUserByName(String userName) throws SQLException {
			User user = new User();
		
			String sql = "SELECT U.ERS_USERS_ID, U.ERS_USERNAME, U.ERS_PASSWORD, U.USER_FIRST_NAME, "
						+ "U.USER_LAST_NAME, U.USER_EMAIL, U.USER_ROLE_ID, R.USER_ROLE FROM ERS_USERS U "
						+ "INNER JOIN ERS_USER_ROLES R "
						+ "ON U.USER_ROLE_ID = R.ERS_USER_ROLE_ID "
						+ "WHERE U.ERS_USERNAME = ?";
			
			PreparedStatement pstmt;
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userName);
			pstmt.executeQuery();
		
			ResultSet rs = pstmt.executeQuery();
		
			while(rs.next()){
				user.setUserID(rs.getInt("ERS_USERS_ID"));
				user.setUserName(rs.getString("ERS_USERNAME"));
				user.setPassword(rs.getString("ERS_PASSWORD"));
				user.setFirstName(rs.getString("USER_FIRST_NAME"));
				user.setLastName(rs.getString("USER_LAST_NAME"));
				user.setEmail(rs.getString("USER_EMAIL"));
				user.setUserRole(rs.getInt("USER_ROLE_ID"),
				rs.getString("USER_ROLE"));
				}
		
		return user;
		
	}

	public String getUserPassword(String username) throws SQLException {
		String password = null;

		String sql = "SELECT ERS_PASSWORD FROM ERS_USERS WHERE ERS_USERNAME = ?";

		PreparedStatement stmt;
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, username);
		stmt.executeQuery();

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			password = rs.getString("ERS_PASSWORD");
		}

		return password;
	}

}
