package com.revature.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.revature.dao.DepartmentDaoImpl;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.util.ConnectionUtil;


public class Main {
	
	//Create a program in Java using JDBC and the DAO pattern to connect to your database.
	//Store your database credentials in a properties file. 


	public static void main(String[] args) {
		EmployeeDaoImpl empDao = new EmployeeDaoImpl();
		DepartmentDaoImpl deptDao = new DepartmentDaoImpl();
		
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			System.out.println(con.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Write a prepared statement which prints each department's name and average salary to the console
		//in STS. 
		PreparedStatement pstmt = 
				con.prepareStatement(“SELECT SALARY, NAME FROM DEPARTMENT”);
		ResultSet rs = pstmt.executeQuery();
		System.out.println(rs.toString());
	}

}
