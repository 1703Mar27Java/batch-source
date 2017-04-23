package com.revature.dao;

import java.sql.*;
import java.util.*;

import com.revature.domain.Employee;
import com.revature.util.ConnectionUtil;

public class EmpDAOImp implements EmpDAO {
	
	@Override
	public List<Employee> retrieveEmp() {
		List<Employee> emps = new ArrayList<>();
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			String sql = "SELECT * FROM EMPLOYEE";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int empId = rs.getInt("EMPLOYEE_ID");
				String fName = rs.getString("EMP_FIRSTNAME");
				String lName = rs.getString("EMP_LASTNAME");
				int deptId = rs.getInt("DEPARTMENT_ID");
				int salary = rs.getInt("SALARY");
				String email = rs.getString("EMP_EMAIL");
				emps.add(new Employee(empId, fName, lName, deptId, salary, email));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return emps;
	}

	@Override
	public float avgSalary(int deptId) {
		float avg = 0;
		PreparedStatement pstmt = null;
		try{
			int sum = 0;
			int counter = 0;
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			String sql = "SELECT * FROM EMPLOYEE WHERE DEPARTMENT_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				sum += rs.getInt("SALARY");
				counter++;
			}
			avg = sum/counter;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (pstmt!=null){try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
		}
		return avg;
	}

	@Override
	public void giveRaise(int deptId, float raise) {
		CallableStatement cs = null;
		try{
			Connection con = ConnectionUtil.getConnection();
			cs = con.prepareCall("{CALL SP_GIVE_RAISE(?, ?, ?, ?)}");
			cs.setInt(1, deptId);
			cs.setFloat(2, raise);
			cs.execute();
			float avg = cs.getFloat(3);
			Boolean valid = cs.getBoolean(4);
			
			if (valid) {
				System.out.println("New Avg Salary: $" + avg);
			} else {
				System.out.println("Failed to give raises!");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (cs != null) {
				try {
					cs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
