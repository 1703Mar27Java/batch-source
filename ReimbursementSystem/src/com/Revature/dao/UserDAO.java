package com.Revature.dao;

import java.util.List;

import com.Revature.domain.User;

public interface UserDAO {
	public User UserByLogin(String username, String password) throws IncorrectLoginException;
	public void createUser(User user) throws UsernameExistsException;
	public List<User> getAllUsers();
	public User getUserByID(int uid);
	public void editUser(int uid, User user);
}
