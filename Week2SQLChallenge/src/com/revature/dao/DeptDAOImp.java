package com.revature.dao;

import java.sql.*;
import java.util.*;

import com.revature.domain.Department;
import com.revature.util.ConnectionUtil;

public class DeptDAOImp implements DeptDAO {

	@Override
	public List<Department> retrieveDept() {
		List<Department> depts = new ArrayList<>();
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			String sql = "SELECT * FROM DEPARTMENT";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int deptId = rs.getInt("DEPARTMENT_ID");
				String deptName = rs.getString("DEPARTMENT_NAME");
				depts.add(new Department(deptId, deptName));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return depts;
	}

	@Override
	public String retrieveDeptName(int deptId) {
		String deptName = "";
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			String sql = "SELECT DEPARTMENT_NAME FROM DEPARTMENT WHERE DEPARTMENT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				deptName = rs.getString("DEPARTMENT_NAME");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return deptName;
	}
}
