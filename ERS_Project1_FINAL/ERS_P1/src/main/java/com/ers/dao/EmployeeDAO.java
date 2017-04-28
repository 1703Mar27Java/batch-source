package com.ers.dao;

import com.ers.domain.Employee;


import java.util.*;


public interface EmployeeDAO {


	public void createEmpAcct(Employee emp);
	public void retrieveEmpInfo(String un);
	public void retrievePending(String un);
	public void retrieveResolved(String un);
	public List<Employee> retrieveAllEmployees();
	public void updateEmpInfo(Employee emp);
	//public void delete(int bankID);

	
}
