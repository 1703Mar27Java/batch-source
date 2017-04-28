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
import com.ers.domain.Managers;
import com.ers.util.ERSUtil;

public class ManagersDAOImpl implements ManagersDAO {

	public void createNewUser(Login login) {

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
	public void createMgrAcct(Managers mgr){
		try{
			Connection con = ERSUtil.getConnectionFromFile();
			int id = mgr.getUid();
			String un = mgr.getUn();
			 String pw = mgr.getPw();
			 String fn = mgr.getFn();
			 String ln = mgr.getFn();
			 String email = mgr.getEmail();
			 int urid = mgr.getUrid();
			 String admin = mgr.getAdmin();
			
			String sql = "INSERT INTO ERS_USERS VALUES (?,?,?,?,?,?.?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			pstmt.setString(2, un);
			pstmt.setString(3, pw);
			pstmt.setString(4,fn);
			pstmt.setString(5,ln);
			pstmt.setString(6, email);
			pstmt.setInt(7, urid);
			pstmt.setString(8, admin);
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected);
			
		}catch(SQLException|IOException  e){
			e.printStackTrace();
			
		}	
		
	}

	public void retrieveMgrInfo(String un){
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
	public void updateMgrInfo(Employee emp) {

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
	
	@Override
	public void updateEmpInfo(Managers mgr) {
		// TODO Auto-generated method stub
		
	}

	

	


}
