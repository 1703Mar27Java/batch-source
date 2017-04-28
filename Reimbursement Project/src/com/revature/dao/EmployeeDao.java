package com.revature.dao;

import com.revature.domain.Employee;

public interface EmployeeDao {

	public Boolean login(Employee employee);
	public void ViewInfo(Employee employee);
	public boolean UpdateInfo(Employee employee);
	public void UploadImage(Employee employee);
	public void ResetPassword(Employee employee);
	
	public void ChangeStatusRequest(Employee manager, Employee employee);
	public void ViewAllEmployees(Employee manager);
	public void ViewRequest(Employee manager, Employee employee);
	public void CreateEmployee(Employee manager);
}