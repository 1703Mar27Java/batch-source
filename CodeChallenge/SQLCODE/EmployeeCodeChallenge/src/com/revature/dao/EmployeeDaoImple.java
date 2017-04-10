package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;

import com.revature.domain.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImple implements EmployeeDao {

	@Override
	public void printAverageSalary(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void giveRaise(Employee emp) {
		// TODO Auto-generated method stub
		CallableStatement cs = null;
		try{
			Connection con = ConnectionUtil.getConnection();
			cs = con.prepareCall("{call SP_GIVE_RAISE(?)");
			cs.registerOutParameter(1, java.sql.Types.VARCHAR);
			cs.execute();
			System.out.println(cs.getString(1));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	

}
