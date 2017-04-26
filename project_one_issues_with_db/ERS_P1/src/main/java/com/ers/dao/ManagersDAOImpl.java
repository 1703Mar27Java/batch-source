package com.ers.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ers.domain.Employee;
import com.ers.domain.Login;
import com.ers.util.ERSUtil;

public class ManagersDAOImpl implements ManagersDAO {

	public void createEmpUser(Login login) {

		try{
			Connection con = ERSUtil.getConnectionFromFile();
			 int lid = login.getLid();
			 String role = login.getRole();
				
			String sql = "INSERT INTO ERS_USER_ROLES VALUES (?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, lid);
			pstmt.setString(2, role);
			
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected);
			
		}catch(SQLException | IOException e){
			e.printStackTrace();
		}

	}
	//manager would have ability to create emp accounts
	public void createEmpAcct(Employee emp){
		try{
			Connection con = ERSUtil.getConnectionFromFile();
			 String un = emp.getUn();
			 String pw = emp.getPw();
			 String fn = emp.getFn();
			 String ln = emp.getFn();
			 String email = emp.getEmail();
			
			String sql = "INSERT INTO ERS_USERS VALUES (?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, un);
			pstmt.setString(2, pw);
			pstmt.setString(3,fn);
			pstmt.setString(4,ln);
			pstmt.setString(5, email);	
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected);
			
		}catch(SQLException|IOException  e){
			e.printStackTrace();
			
		}	
		
	}

	public void retrieveEmpInfo(String un){
		try{
			Connection con = ERSUtil.getConnectionFromFile();		
			String sql = "SELECT U_USERNAME FROM ERS_USERS WHERE U_USERNAME = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String name = rs.getString("U_USERNAME");
				System.out.print(name);		
			}
		}catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
			//plans to replace this with a view and call-able statement
	public List<Employee> retrieveAllEmployees() {
		PreparedStatement pstmt = null;
		List<Employee> users = new ArrayList<>();
		try{
			Connection con = ERSUtil.getConnectionFromFile();
			String sql = "SELECT * FROM ERS_USERS";//EVENTUALLY REPLACE WITH A VIEW
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("U_ID");
				String un = rs.getString("U_USERNAME");
				String pw = rs.getString("U_PASSWORD");
				String fname = rs.getString("U_FIRSTNAME");
				String lname = rs.getString("U_LASTNAME");
				String email = rs.getString("U_EMAIL");
				int ur = rs.getInt("UR_ID");
				Employee e = new Employee (id,un,pw,fname,lname,email,ur);
				users.add(e);
			}
		}catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
				//TRYING TO SET UP A CALLABLE STATEMENT TO GET A 
				//STORED PROCEDURE INSTEAD OF THIS
	public void updateEmpInfo(Employee emp) {

		try{
			Connection con = ERSUtil.getConnectionFromFile();		
			String sql = "UPDATE ERS_USERS"
					+ " U_USERNAME=:new.U_USERNAME, U_PASSWORD=:new.U_PASSWORD, "
					+ "U_FIRSTNAME=:new.U_FIRSTNAME, "
					+ "U_LASTNAME=:new.U_LASTNAME, USER_EMAIL=:new.USER_EMAIL";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("U_ID");
				System.out.print(id);		
			}
		}catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	
	}
	
	
	//call-able statement to retrieve corresponding view
	public void retrievePending(String un){
		
		
	}
	//call-able statement to retrieve corresponding view
	public void retrieveResolved(String un){
		
	}

	@Override
	public void deleteEmpAccount(int uid) {
		// TODO Auto-generated method stub
		
	}
	

	


}
