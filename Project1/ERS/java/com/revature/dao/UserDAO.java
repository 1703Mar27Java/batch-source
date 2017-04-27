package com.revature.dao;
import java.util.ArrayList;

import com.revature.domain.User;

public interface UserDAO {
	public void createUser(User user); 
	public boolean userExists(String username);
	public boolean emailExists(String email);
	public boolean deleteUserByUsername(String username); 
	public User getUserByUsername(String username);
	public ArrayList<User> getUsers();
	public void updateUser(User user);
}
