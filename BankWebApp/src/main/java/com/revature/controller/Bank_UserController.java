package com.revature.controller;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.revature.dao.*;
import com.revature.domain.Bank_User;
import com.revature.exception.NotFoundException;
import com.revature.util.ConnectionUtil;

public class Bank_UserController {

	Connection connection = null;
	Bank_UserDAO bank_UserDAO = null;

	public Bank_UserController() throws SQLException, IOException {
		connection = ConnectionUtil.getConnection();
		bank_UserDAO = new Bank_UserDAOImpl();
	}

	public List<Bank_User> getAllUsers() throws SQLException {
		try {
			return bank_UserDAO.loadAll(connection);
		} catch (SQLException e) {
			throw new SQLException("User ID Error");
		}
	}

	public Bank_User getUser(int user_id) throws NotFoundException, SQLException {
		try {
			Bank_User user = null;
			user = bank_UserDAO.getObject(connection, user_id);
			return user;
		} catch (NotFoundException e) {
			throw new NotFoundException("User Not Found");
		} catch (SQLException e) {
			throw new SQLException("User ID Error");
		}
	}
	
	public void createUser(Bank_User user) throws SQLException {
		try {
			bank_UserDAO.create(connection, user);
			connection.commit();
			
		} catch (SQLException e) {
			throw new SQLException("User ID Error");
		}
	}
	
	public void updateUser(Bank_User user) throws NotFoundException, SQLException {
		try {
			bank_UserDAO.save(connection, user);
			connection.commit();
			
		} catch (NotFoundException e) {
			throw new NotFoundException("User Not Found");
		} catch (SQLException e) {
			throw new SQLException("User ID Error");
		}
	}

}
