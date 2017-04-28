package com.ers.dao;

import java.util.List;

import com.ers.domain.Employee;
import com.ers.domain.Login;
import com.ers.domain.Managers;

public interface ManagersDAO {

	public void createNewUser(Login login);
	public void createMgrAcct(Managers mgr);
	public void retrieveMgrInfo(String un);
	public void retrieveEmpInfo(String un);
	public void retrievePending(String un);
	public void retrieveResolved(String un);
	public List<Employee> retrieveAllEmployees();
	public void updateEmpInfo(Managers mgr);
	public void deleteEmpAccount(int uid);


}
