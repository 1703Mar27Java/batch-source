package com.ers.dao;

import java.util.List;

import com.ers.domain.Employee;
import com.ers.domain.Login;

public interface ManagersDAO {

	public void createEmpUser(Login login);
	public void createEmpAcct(Employee emp);
	public void retrieveEmpInfo(String un);
	public void retrievePending(String un);
	public void retrieveResolved(String un);
	public List<Employee> retrieveAllEmployees();
	public void updateEmpInfo(Employee emp);
	public void deleteEmpAccount(int uid);


}
