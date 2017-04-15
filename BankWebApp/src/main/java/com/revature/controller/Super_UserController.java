package com.revature.controller;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.revature.dao.*;
import com.revature.domain.*;
import com.revature.exception.NotFoundException;
import com.revature.util.ConnectionUtil;

public class Super_UserController {
	
	Connection connection = null;
	Bank_UserDAO bank_UserDAO = null;
	Bank_AccountDAO bank_AccountDAO = null;

	public Super_UserController() throws SQLException, IOException {
		connection = ConnectionUtil.getConnection();
		bank_UserDAO = new Bank_UserDAOImpl();
		bank_AccountDAO = new Bank_AccountDAOImpl();
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
	
	public void deleteUser(Bank_User user) throws NotFoundException, SQLException {
		try {
			bank_UserDAO.delete(connection, user);
		} catch (NotFoundException e) {
			throw new NotFoundException("User Not Found");
		} catch (SQLException e) {
			throw new SQLException("User ID Error");
		}
	}
	
	public void deleteAll() throws SQLException {
		try {
			bank_UserDAO.deleteAll(connection);
		} catch (SQLException e) {
			throw new SQLException("User ID Error");
		}
	}

}
