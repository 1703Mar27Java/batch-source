package com.revature.main;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//In your main class, use these statements to print average department salaries before and after
		//a particular department is given a raise. 
		EmployeeDaoImpl eDao = new EmployeeDaoImpl();
		employee emp = new employee("temp",  "temp", 2, 10000, "tt@gmail.com");
		eDao.DisplayEmployee(emp);
	}

}
