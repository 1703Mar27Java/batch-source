package com.revature.dao;

import com.revature.domain.Department;
import com.revature.domain.Employee;

public interface EmployeeDAO {

	public void Create(Employee employee);
	public void Update (Employee employee);
	public void Delete(Employee employee);
	public void GiveRaise(int departmentID,int percentage);
	
	
}
