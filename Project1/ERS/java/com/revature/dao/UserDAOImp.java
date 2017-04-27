package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.domain.User;
import com.revature.util.ConnectionUtil;

public class UserDAOImp implements UserDAO {
		
	public void createUser(User user) {
		try (Connection con = ConnectionUtil.getConnection()) {
			String createCall = "{CALL SP_CREATE_USER (?, ?, ?, ?, ?, ?)}";
			CallableStatement cstmt = con.prepareCall(createCall);

			cstmt.setString(1, user.getUsername());
			cstmt.setString(2, user.getPassword());
			cstmt.setString(3, user.getFirstName());
			cstmt.setString(4, user.getLastName());
			cstmt.setString(5, user.getEmail());
			cstmt.setInt(6, encodeRole(user.getRole()));
			cstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean userExists(String username) {
		try (Connection con = ConnectionUtil.getConnection()) {
			String userQuery = "SELECT U_ID FROM USERS WHERE U_USERNAME = ?";

			PreparedStatement pstmt = con.prepareStatement(userQuery);
			pstmt.setString(1, username);

			ResultSet result = pstmt.executeQuery();

			if (result.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean emailExists(String email) {
		try (Connection con = ConnectionUtil.getConnection()) {
			String userQuery = "SELECT U_ID FROM USERS WHERE U_EMAIL = ?";

			PreparedStatement pstmt = con.prepareStatement(userQuery);
			pstmt.setString(1, email);

			ResultSet result = pstmt.executeQuery();

			if (result.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean deleteUserByUsername(String username) {
		int removed = 0;
		try (Connection con = ConnectionUtil.getConnection()) {
			String deleteUpdate = "DELETE FROM USERS WHERE U_USERNAME = ?";
			PreparedStatement pstmt = con.prepareCall(deleteUpdate);

			pstmt.setString(1, username);
			removed = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (removed > 0);
	}

	
	public User getUserByUsername(String username) {
		User user = null;
		try (Connection con = ConnectionUtil.getConnection()) {
			String userQuery = "SELECT * FROM USERS INNER JOIN USER_ROLES ON USERS.UR_ID = USER_ROLES.UR_ID WHERE U_USERNAME = ?";
			PreparedStatement pstmt = con.prepareStatement(userQuery);
			pstmt.setString(1, username);

			ResultSet result = pstmt.executeQuery();

			if (result.next()) {
				user = new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),
						result.getString(5), result.getString(6), result.getString(9));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	public ArrayList<User> getUsers(){
		ArrayList<User> users = new ArrayList<User>();
		try (Connection con = ConnectionUtil.getConnection()) {
			String userQuery = "SELECT * FROM USERS INNER JOIN USER_ROLES ON USERS.UR_ID = USER_ROLES.UR_ID ORDER BY USERS.U_USERNAME";
			PreparedStatement pstmt = con.prepareStatement(userQuery);
			ResultSet result = pstmt.executeQuery();

			while(result.next()) {
				users.add(new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),
						result.getString(5), result.getString(6), result.getString(9)));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	
	public void updateUser(User user) {
		try (Connection con = ConnectionUtil.getConnection()) {
			String createCall = "{CALL SP_UPDATE_EMPLOYEE (?, ?, ?, ?, ?)}";
			CallableStatement cstmt = con.prepareCall(createCall);

			cstmt.setInt(1, user.getId());
			cstmt.setString(2, user.getPassword());
			cstmt.setString(3, user.getFirstName());
			cstmt.setString(4, user.getLastName());
			cstmt.setString(5, user.getEmail());
			cstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
		
	private int encodeRole(String role){
		int id = 0;
		
		switch(role){
		case "ASSOCIATE":
			id = 0;
			break;
		case "MANAGER":
			id = 1;
			break;
		case "ADMIN":
			id = 2;
			break;
		}	
		
		return id;
	}
	
}
