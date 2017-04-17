package com.revature.dao;

import java.io.*;
import java.sql.*;
import java.util.List;

import com.revature.bean.Bank_User;

public interface Bank_UserDAO {
	public int getUser(String userName, String userPassword) throws SQLException, IOException;
	public List<Bank_User> getAllUsers() throws SQLException, IOException;
	public void createUser(Bank_User valueObject) throws SQLException, IOException;
	public void updateUser(Bank_User valueObject) throws SQLException, IOException;
	public void deleteUser(Bank_User valueObject) throws SQLException, IOException;
	public void deleteAllUsers() throws SQLException, IOException;
}
