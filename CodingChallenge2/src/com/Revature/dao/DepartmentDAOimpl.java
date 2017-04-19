package com.Revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Revature.domain.Department;
import com.Revature.util.ConnectionUtil;

import oracle.jdbc.internal.OracleTypes;

public class DepartmentDAOimpl implements DepartmentDAO{

	@Override
	public List<Department> departmentSalary() {
		CallableStatement cs = null;
		List<Department> depts = new ArrayList<>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");){
			cs = con.prepareCall("{call SP_DEPARTMENT_SALARY(?)}");
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.executeUpdate();
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()){
				Department dept = new Department();
				dept.setId(rs.getInt("DEPARTMENT_ID"));
				dept.setName(rs.getString("DEPARTMENT_NAME"));
				dept.setSalary(rs.getDouble("AVGSALARY"));
				depts.add(dept);
			}
		}catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return depts;
	}

	@Override
	public void giveRaise(int id) {
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");){
			CallableStatement cs = con.prepareCall("{call SP_GIVE_RAISE(?,?,?)}");
			cs.setInt(1, id);
			cs.registerOutParameter(2, OracleTypes.DOUBLE);
			cs.registerOutParameter(3, OracleTypes.INTEGER);
			int numRowsAffected = cs.executeUpdate();
			//System.out.println("NumofRowsAffected: "+ numRowsAffected);
		}catch(SQLException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
