package com.revature.main;

import java.util.Scanner;

import com.revature.dao.EmployeeDAOImpl;

public class Main {

	public static void main(String[] args) {
Scanner scanner=new Scanner(System.in);

System.out.println("Enter a department number to give a raise to");
int id= scanner.nextInt();
System.out.println("Enter a percentage amount for the raise");
int percentage=scanner.nextInt();

EmployeeDAOImpl empDAO=new EmployeeDAOImpl();
empDAO.GiveRaise(id, percentage);

	}

}
