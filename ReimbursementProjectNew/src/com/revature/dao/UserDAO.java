package com.revature.dao;

import java.util.List;

import com.revature.domain.UserBackBean;

public interface UserDAO 
{
	public boolean createUser(UserBackBean user, String filename);
	public UserBackBean getUser(int userID, String filename);
	public int getUserID(String username, String filename);
	public List<UserBackBean> getUsers(int role, String filename);
	public boolean updateUser(UserBackBean user, String filename);
	public boolean deleteUser(int userID, String filename);
	public String getRole(UserBackBean user, String filename);
	public UserBackBean getUserByID(int userID, String filename);
	public int getRoleID(String role, String filename);
}
