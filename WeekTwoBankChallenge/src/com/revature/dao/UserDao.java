package com.revature.dao;

import java.util.List;

import com.revature.domain.User;

public interface UserDao {
	public void createUser(User user);
	public User retrieveUserByLoginInfo(String un, String pw);
	public User retrieveUserById(int userId);
	public List<User> retrieveAllUser();
	public void updateUser(User user);
	public void deleteUser(int id);
	public void createUserPS(User user);
}

