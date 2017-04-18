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

public class UserDaoImpl implements UserDao{
	@Override
	public void createUser(User user) {
		try(Connection con = ConnectionUtil.getConnection()){
			//we're autogenerating out pks u in the database because we're not barbarians
			String userName = user.getUserName();
			String passWord = user.getPassword();
			
			String sql = "INSERT INTO BANKUSER (USERNAME, PASSWORD) VALUES ('"+userName+"', '"+passWord+"')";
			
			Statement statement = con.createStatement();	//this is precompiled
			int numRowsAffected = statement.executeUpdate(sql);	//this argument is not precompiled as a paramater
			System.out.println("hi");							//use prepared statements to prevent sql injections by users
			
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public User retrieveUserByLoginInfo(String un, String pw) {
		PreparedStatement pstmt = null;
		User user = null;
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANKUSER WHERE USERNAME = '" + un +"' AND PASSWORD = '" + pw +"'";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("USERID");
				user = new User(un, pw);
				user.setUserID(id);
				break;
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
		return user;
	}
	
	public User retrieveUserById(int userId) {
		PreparedStatement pstmt = null;
		User user = null;
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANKUSER WHERE USERID = " + userId;
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("USERID");
				String name = rs.getString("USERNAME");
				String pw = rs.getString("PASSWORD");
				user = new User(name, pw);
				user.setUserID(id);
				break;
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
		return user;
	}

	@Override
	public List<User> retrieveAllUser() {
		PreparedStatement pstmt = null;
		List<User> users = new ArrayList<>();
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANKUSER";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("USERID");
				String name = rs.getString("USERNAME");
				String pw = rs.getString("PASSWORD");
				User u = new User(name, pw);
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

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUserPS(User user) {
		// TODO Auto-generated method stub
		
	}
	
}
