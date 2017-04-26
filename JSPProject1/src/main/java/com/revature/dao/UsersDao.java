package com.revature.dao;

import java.util.List;

import com.revature.domain.User;

public interface UsersDao {
	public void createEmp(User usr);
	public User retrieveUserByLoginInfo(String un, String pw);
	public User retrieveUserById(int id);
	public List<User> retrieveEmployees();	//eventually, add URID to check for clearence
	public List<User> retrieveManagers(int userId);
	public List<User> retrieveAllUsers();
	public void updateUser(User usr, String un, String fName, String lName, String email);
	public void deleteUser(int id);
	public void switchUser(int acctId, int usrId);
}
