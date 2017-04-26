package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.domain.User;
import com.revature.domain.UserRoles;
import com.revature.util.ConnectionUtil;

public class UserRolesDaoImpl implements UserRolesDao {

	public void newUserRole(UserRoles role) {
		try(Connection con = ConnectionUtil.getConnection()){
			String ur_role = role.getUrRole();
		
			String sql = "INSERT INTO ERS_USER_ROLES (UR_ROLE) VALUES ('"+ur_role+"')";
		
			Statement statement = con.createStatement();	//this is precompiled
			int numRowsAffected = statement.executeUpdate(sql);	//this argument is not precompiled as a paramater
			
			
			
		}catch (SQLException e){
			e.printStackTrace();
		}

	}
	
	public int getCurrentUserID(){
		int currentUserRoleID = 0;	//this will default to zero if nothing happens
		
		try(Connection con = ConnectionUtil.getConnection()){
			//used to call the rowCountRoles(row out number) stored procedure in our ERSProject1.sql file
			PreparedStatement pstmt = null;
			try {
			   String sql = "SELECT UR_ID FROM ERS_USER_ROLES";
			   pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				//this is a slow way of having the returned userRoleID that of the last one created. This is
				//necessary for mapping the UR_ID to the created user
				while(rs.next()){
					currentUserRoleID = rs.getInt("UR_ID");
				}
			}
			catch (SQLException e) {
			  e.printStackTrace();
			}
		}catch (SQLException e){
			e.printStackTrace();
		}

		return currentUserRoleID;
	}

	public UserRoles retrieveUserRoleByID(int ur_id) {
		PreparedStatement pstmt = null;
		UserRoles userRole = null;
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ERS_USER_ROLES WHERE UR_ID = " + ur_id;
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int urid = rs.getInt("UR_ID");
				String ur_role = rs.getString("UR_ROLE");
				userRole = new UserRoles(ur_role);
				userRole.setUrID(urid);
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
		return userRole;
	}

	public List<User> retrieveEmployees(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> retrieveManagers(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateUserRole(User usr, String role) {
		// TODO Auto-generated method stub

	}

	public void deleteUserID(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User retrieveUserByRole(String role) {
		// TODO Auto-generated method stub
		return null;
	}

}
