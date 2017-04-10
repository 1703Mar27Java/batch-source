package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;
import com.revature.domain.Department;
import com.revature.domain.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void Create(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Delete(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void GiveRaise(int departmentID, int percentage) {
		
		Connection con;
		
			try {
				con = ConnectionUtil.getConnection();
				PreparedStatement pstmt;
				String sql="DECLARE"
						+ "AVG_SALARY SYS_REFCURSOR;"
						+ "VALID BOOLEAN;"
						+ "BEGIN"
						+ "SP_GIVE_RAISE(?,?,?,?);"
						+ "END;";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, departmentID);
				pstmt.setInt(2, percentage);
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

}
