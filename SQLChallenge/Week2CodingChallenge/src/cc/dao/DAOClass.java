package cc.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.pbjbank.util.UtilityClass;

import cc.domain.*;
import cc.util.*;


public class DAOClass implements DAOInterface {

	public DAOClass() {
	}

	@Override
	public void createNewEmployeePS(Employee Employee) {
		try{
			Connection con = UtilityClass.getConnectionFromFile();
			int a = employee.getBankID();
			int u = employee.getUserID();
			String n = employee.getBaName();
			double b = employee.getBal();
			String n = employee.getBaName();
			double b = employee.getBal();
			
			String sql = "INSERT INTO EMPLOYEE (EMPLOYEE_ID,EMP_FIRSTNAME,EMP_LASTNAME,DEPARTMENT_ID,SALARY,EMP_EMAIL) VALUES (?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(0, a);
			pstmt.setInt(0, u);
			pstmt.setString(1, n);
			pstmt.setDouble(2, b);
			pstmt.setString(1, n);
			pstmt.setDouble(2, b);
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected);
		}catch(SQLException | IOException e){
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public Employee retrieveEmployee(String Employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> retrieveEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployee(Employee Employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(String employee) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
}
