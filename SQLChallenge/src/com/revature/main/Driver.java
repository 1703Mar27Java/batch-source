package com.revature.main;

import com.revature.dao.DAOImpl;

public class Driver 
{

	public static void main(String[] args) 
	{
		DAOImpl dao = new DAOImpl();
		dao.printAllDeptAndAvgSal();
		dao.callable();
		System.out.println();
		
		dao.printAllDeptAndAvgSal();
	}

}
