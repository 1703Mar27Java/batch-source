package com.revature.controller;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.revature.dao.*;
import com.revature.domain.*;
import com.revature.exception.NotFoundException;
import com.revature.util.ConnectionUtil;

public class Bank_AccountController {
	
	Connection connection = null;
	Bank_AccountDAO bank_AccountDAO = null;
	
	public Bank_AccountController() throws SQLException, IOException {
		connection = ConnectionUtil.getConnection();
		bank_AccountDAO = new Bank_AccountDAOImpl();
	}
	
	public List<Bank_Account> getAllAccounts(Bank_Account acc) throws SQLException {
		try {
			return bank_AccountDAO.loadAll(connection, acc);
		} catch (SQLException e) {
			throw new SQLException("User ID Error");
		}		
	}
	
	public Bank_Account getAccount(int acc_id) throws NotFoundException, SQLException {
		try {
			Bank_Account acc = null;
			acc = bank_AccountDAO.getObject(connection, acc_id);
			return acc;
		} catch (NotFoundException e) {
			throw new NotFoundException("User Not Found");
		} catch (SQLException e) {
			throw new SQLException("User ID Error");
		}
	}

}
