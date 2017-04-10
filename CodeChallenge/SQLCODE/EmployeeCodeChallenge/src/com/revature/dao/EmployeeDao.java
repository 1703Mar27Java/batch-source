package com.revature.dao;
import com.revature.domain.Employee;
public interface EmployeeDao {
	
	public void printAverageSalary(Employee emp);
	public void giveRaise(Employee emp);

}
