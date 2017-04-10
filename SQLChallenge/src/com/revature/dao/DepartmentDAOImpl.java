package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.domain.Department;
import com.revature.util.ConnectionUtil;

public class DepartmentDAOImpl implements DepartmentDAO {

	@Override
	public void Create(Department department) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update(Department department) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Delete(Department department) {
		// TODO Auto-generated method stub

	}

	@Override
	public void RetrieveNameAndAvgSalary(Department department) {
		String sql="SELECT DEPARTMENT_NAME,AVG(SALARY) FROM DEPARTMENT,EMPLOYEE WHERE DEPARTMENT.DEPARMENT_ID=EMPLOYEE.EMPLOYEE_ID AND DEPARTMENT.DEPARTMENT_ID=?";

		
		Connection con;
		
		try {
			con = ConnectionUtil.getConnection();
			PreparedStatement pstmt;
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, department.getId());
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
