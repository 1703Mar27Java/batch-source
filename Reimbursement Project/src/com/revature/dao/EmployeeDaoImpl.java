package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.domain.Employee;
import com.revature.domain.Roles;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Boolean login(Employee employee) {
		try {
			Connection con = ConnectionUtil.getConnection();

			String sql = "SELECT * FROM ERS_USERS ORDER BY U_ID";
			PreparedStatement pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int id = rs.getInt(1);
				String userName = rs.getString(2);
				String passWord = rs.getString(3);
				String firstName = rs.getString(4);
				String lastName = rs.getString(5);
				String email = rs.getString(6);
				int userRole = rs.getInt(7);

				if (employee.getEmployeeUsername().contentEquals(userName)
						& employee.getEmployeePassword().contentEquals(passWord)) {
					employee.setEmployeeID(id);
					employee.setEmployeeFirstname(firstName);
					employee.setEmployeeLastname(lastName);
					employee.setEmployeeEmail(email);
					if (userRole == 1)
						employee.setUserRoleID(Roles.Employee);
					else
						employee.setUserRoleID(Roles.Manager);
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void ViewInfo(Employee employee) {
		try {
			Connection con = ConnectionUtil.getConnection();

			String sql = "SELECT * FROM ERS_USER WHERE U_ID";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employee.getEmployeeID());

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				String user = rs.getString("U_USERNAME");
				String pass = rs.getString("U_PASSWORD");
				String first = rs.getString("U_FIRSTNAME");
				String last = rs.getString("U_LASTNAME");
				String email = rs.getString("U_EMAIL");
				int roleId = Integer.valueOf(rs.getString("UR_ID"));

				employee.setEmployeeUsername(user);
				employee.setEmployeePassword(pass);
				employee.setEmployeeFirstname(first);
				employee.setEmployeeLastname(last);
				employee.setEmployeeEmail(email);
				if (roleId == 1)
					employee.setUserRoleID(Roles.Employee);
				else
					employee.setUserRoleID(Roles.Manager);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean UpdateInfo(Employee employee) {

		try {
			Connection con = ConnectionUtil.getConnection();

			System.out.println(employee);
			
			String sql = "UPDATE ERS_USERS SET U_USERNAME = ?, U_PASSWORD = ?, U_FIRSTNAME = ?, U_LASTNAME = ?, U_EMAIL = ? WHERE U_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employee.getEmployeeUsername().toString());
			pstmt.setString(2, employee.getEmployeePassword().toString());
			pstmt.setString(3, employee.getEmployeeFirstname().toString());
			pstmt.setString(4, employee.getEmployeeLastname().toString());
			pstmt.setString(5, employee.getEmployeeEmail().toString());
			pstmt.setInt(6, employee.getEmployeeID());

			int numRows = pstmt.executeUpdate();
			if (numRows > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void UploadImage(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ResetPassword(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ChangeStatusRequest(Employee manager, Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ViewAllEmployees(Employee manager) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ViewRequest(Employee manager, Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void CreateEmployee(Employee manager) {
		try {

			Connection con = ConnectionUtil.getConnection();

			String sql = "INSERT INTO ERS_USERS (U_USERNAME,U_PASSWORD,U_FIRSTNAME,U_LASTNAME,U_EMAIL,UR_ID) VALUES (?,?,?,?,?,?)";

			PreparedStatement pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, manager.getEmployeeUsername());
			pstmt.setString(2, manager.getEmployeePassword());
			pstmt.setString(3, manager.getEmployeeFirstname());
			pstmt.setString(4, manager.getEmployeeLastname());
			pstmt.setString(5, manager.getEmployeeEmail());
			if (manager.getUserRoleID() == Roles.Employee)
				pstmt.setInt(6, 1);
			else
				pstmt.setInt(6, 2);

			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected);

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
}
