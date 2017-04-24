package com.Revature.dao;

import com.Revature.domain.User;

public interface UserDAO {
	public User UserByLogin(String username, String password) throws IncorrectLoginException;
	public void createUser(User user) throws UsernameExistsException;
}
