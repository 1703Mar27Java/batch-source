package com.revature.dao;

import java.sql.*;
import java.util.List;

import com.revature.domain.Bank_Account;
import com.revature.exception.NotFoundException;

public interface Bank_AccountDAO {
	public Bank_Account createValueObject();
	public Bank_Account getObject(Connection conn, int BANK_ACCOUNT_ID) 
			throws NotFoundException, SQLException;
	public void load(Connection conn, Bank_Account valueObject) throws NotFoundException, SQLException;
	public List<Bank_Account> loadAll(Connection conn, Bank_Account valueObject) throws SQLException;
	public void create(Connection conn, Bank_Account valueObject) throws SQLException;
	public void transaction(Connection conn, Bank_Account valueObject, double amount) 
			throws NotFoundException, SQLException;
	public void save(Connection conn, Bank_Account valueObject) 
			throws NotFoundException, SQLException;
	public void delete(Connection conn, Bank_Account valueObject) 
			throws NotFoundException, SQLException;
	public void deleteAll(Connection conn) throws SQLException;
	public int countAll(Connection conn) throws SQLException;
	public List<Bank_Account> searchMatching(Connection conn, Bank_Account valueObject) 
			throws SQLException;
	public int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException;
	public int databaseUpdate(Connection conn, CallableStatement cs) throws SQLException;
	public void singleQuery(Connection conn, PreparedStatement stmt, Bank_Account valueObject) 
			throws NotFoundException, SQLException;
	public List<Bank_Account> listQuery(Connection conn, PreparedStatement stmt) throws SQLException;
}
