package com.revature.dao;

import java.util.List;

import com.revature.domain.User;
import com.revature.domain.UserRoles;


public interface UserRolesDao {
	public void newUserRole(UserRoles role);
	public int getCurrentUserID();
	public User retrieveUserByRole(String role);
	public List<User> retrieveEmployees(int userId);
	public List<User> retrieveManagers(int userId);
	public void updateUserRole(User usr, String role);
	public void deleteUserID(int id);
}
