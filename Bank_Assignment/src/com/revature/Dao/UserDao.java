package com.revature.Dao;

import java.util.List;

import com.revature.Domain.User;

public interface UserDao {
	
	public void loginUser(User user);
	public void logOut();
	
	public void createUser(User user);
	public List<User> retrieveAll();
	public void uppdateUser(User user);
	public void deleteAll();
	public void Display();
}
