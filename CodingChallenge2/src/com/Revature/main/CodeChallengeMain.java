package com.Revature.main;

import java.util.List;
import java.util.Scanner;

import com.Revature.dao.DepartmentDAOimpl;
import com.Revature.domain.Department;

public class CodeChallengeMain {
	public static void main(String[] args) {
		DepartmentDAOimpl deptDAO = new DepartmentDAOimpl();
		System.out.println("Department salaries before raise");

		List<Department> depts = deptDAO.departmentSalary();
		System.out.println("ID\t\t\tName\t\t\tSalary");
		System.out.println("----\t\t\t----\t\t\t-----");
		for (Department ba : depts) {
			System.out.println(ba.getId() + "\t\t\t" + ba.getName() + "\t\t\t$" + ba.getSalary());
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("Select department for 10% raise: ");
		int id = scan.nextInt();

		deptDAO.giveRaise(id);

		System.out.println("Department salaries after raise");

		List<Department> depts2 = deptDAO.departmentSalary();
		System.out.println("ID\t\t\tName\t\t\tSalary");
		System.out.println("----\t\t\t----\t\t\t-----");
		for (Department ba : depts2) {
			System.out.println(ba.getId() + "\t\t\t" + ba.getName() + "\t\t\t$" + ba.getSalary());
		}
	}
}
