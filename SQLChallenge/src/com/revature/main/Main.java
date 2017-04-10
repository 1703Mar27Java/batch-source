package com.revature.main;

import java.util.*;

import com.revature.domain.*;
import com.revature.dao.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Department> depts;
		List<Employee> emps;
		DeptDAOImp dDAO = new DeptDAOImp();
		EmpDAOImp eDAO = new EmpDAOImp();
		depts = dDAO.retrieveDept();
		emps = eDAO.retrieveEmp();
		
		System.out.println("Average Salary of Sales: $ " + eDAO.avgSalary(1));
		System.out.println("Average Salary of Finance: $ " + eDAO.avgSalary(2));
		System.out.println("Average Salary of Marketing: $ " + eDAO.avgSalary(3));
		
		eDAO.giveRaise(1, 1.1f);
		eDAO.giveRaise(2, 1.1f);
		eDAO.giveRaise(3, 1.1f);
	
		System.out.println("Average Salary of Sales: $ " + eDAO.avgSalary(1));
		System.out.println("Average Salary of Finance: $ " + eDAO.avgSalary(2));
		System.out.println("Average Salary of Marketing: $ " + eDAO.avgSalary(3));
		
		System.out.println("Enter Department to give raise:");
		System.out.println("Enter raise amount for Sales in decimal (i.e. 10% = 1.1)");
		float raise = sc.nextFloat();
		eDAO.giveRaise(1, raise);
	}

}
