package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.User;
import com.revature.util.ConnectionUtil;

public class UsersDaoImpl implements UsersDao {

	public void createEmp(User usr) {
		try(Connection con = ConnectionUtil.getConnection()){
			//we're autogenerating out pks u in the database because we're not barbarians
			int urID = usr.getUrID();//usr.getUrID();
			String un = usr.getUserName();
			String pw = usr.getPassword();
			String emailAddress = "email";//usr.getEmailAddress();
			
			String sql = "INSERT INTO ERS_USERS (U_USERNAME, U_PASSWORD, U_EMAIL, UR_ID) VALUES ('"+un+"', '"+pw+"', '"+emailAddress+"', '"+urID+"')";
			
			System.out.println("you's on da bluegrass 1!");
			
			Statement statement = con.createStatement();	//this is precompiled
			int numRowsAffected = statement.executeUpdate(sql);	//this argument is not precompiled as a paramater
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public User retrieveUserByLoginInfo(String un, String pw) {
		System.out.println("you's on da bluegrass 2!");
		PreparedStatement pstmt = null;
		User user = null;
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ERS_USERS WHERE U_USERNAME = '"+un+"' AND U_PASSWORD = '"+pw+"'";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("U_ID");
				int urID = rs.getInt("UR_ID");
				user = new User(un, pw);
				user.setUserID(id);
				user.setUrID(urID);
				
				//this might complicate things
				String fName = rs.getString("U_FIRSTNAME");
				String lName = rs.getString("U_LASTNAME");
				String email = rs.getString("U_EMAIL");
				user.setEmailAddress(email);
				user.setFirstName(fName);
				user.setLastName(lName);
				break;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if (pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}

	public User retrieveUserById(int id) {
		PreparedStatement pstmt = null;
		User user = null;
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ERS_USERS WHERE U_ID = '"+id+"'";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String un = rs.getString("U_USERNAME");
				String pw = rs.getString("U_PASSWORD");
				String fName = rs.getString("U_FIRSTNAME");
				String lName = rs.getString("U_LASTNAME");
				String email = rs.getString("U_EMAIL");
				int urID = rs.getInt("UR_ID");
				user = new User(un, pw);
				user.setUserID(id);
				user.setUrID(urID);
				user.setEmailAddress(email);
				user.setFirstName(fName);
				user.setLastName(lName);
				
				break;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if (pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;

	}

	public List<User> retrieveEmployees() {
		PreparedStatement pstmt = null;
		List<User> users = new ArrayList<>();
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ERS_USERS";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int uID = rs.getInt("U_ID");
				String name = rs.getString("U_USERNAME");
				String pw = rs.getString("U_PASSWORD");
				String fName = rs.getString("U_FIRSTNAME");
				String lName = rs.getString("U_LASTNAME");
				String email = rs.getString("U_EMAIL");
				int urID = rs.getInt("UR_ID");
				User u = new User(name, pw);
				u.setFirstName(fName);
				u.setLastName(lName);
				u.setEmailAddress(email);
				u.setUrID(urID);
				u.setUserID(uID);
				users.add(u);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if (pstmt!=null){try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
		}
		return users;
	}

	public List<User> retrieveManagers(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> retrieveAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateUser(User usr, String un, String fName, String lName, String email) {
		PreparedStatement pstmt = null;
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE ERS_USERS SET U_USERNAME = '" + un + "', U_FIRSTNAME = '" + fName + "', U_LASTNAME = '" + lName + "', U_EMAIL = '" + email + "' WHERE U_ID = + '" + usr.getUserID() +"'";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if (pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub

	}

	public void switchUser(int acctId, int usrId) {
		// TODO Auto-generated method stub

	}

}
