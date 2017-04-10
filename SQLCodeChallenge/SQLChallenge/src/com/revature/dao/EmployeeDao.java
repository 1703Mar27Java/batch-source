package com.revature.dao;

import java.util.List;

import com.revature.domain.Department;
import com.revature.domain.Employee;

public interface EmployeeDao {
	public void createEmployee(Employee dept);
	public Employee retrieveEmployeeById(int id);
	public List<Employee> retrieveAllEmployee();
}
