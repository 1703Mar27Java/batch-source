package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.revature.util.ConnectionUtil;

public class DAOImpl implements DAO 
{
	public static final String filename = "connection.properties";
	
	@Override
	public void printAllDeptAndAvgSal() 
	{
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) 
		{
			String sql = "SELECT AVG(SALARY) AS SALARY, DEPARTMENT.DEPARTMENT_NAME AS DEPARTMENT FROM EMPLOYEE, DEPARTMENT WHERE EMPLOYEE.DEPARTMENT_ID = DEPARTMENT.DEPARTMENT_ID GROUP BY DEPARTMENT.DEPARTMENT_NAME";
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet results = pstmt.executeQuery();


			while (results.next())
			{
				System.out.print(results.getString(1) + " ");
				System.out.println(results.getString(2));
			}
			System.out.println();
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}

	}

	@Override
	public void callable() 
	{
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) 
		{
			int number = 0;
			int salary = 0;
			String valid = null;
			String sql = "SP_GIVE_RAISE("+ number + ","+salary+ ","+ valid +")";
			CallableStatement pstmt = con.prepareCall(sql);
			
		} 
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
