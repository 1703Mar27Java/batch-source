package com.revature.dao;

import java.sql.*;
import java.util.List;

import com.revature.domain.Bank_User;
import com.revature.exception.NotFoundException;

public interface Bank_UserDAO {
	public Bank_User createValueObject();
	public Bank_User getObject(Connection conn, int USER_ID) throws NotFoundException, SQLException;
	public void load(Connection conn, Bank_User valueObject) throws NotFoundException, SQLException;
	public List<Bank_User> loadAll(Connection conn) throws SQLException;
	public void create(Connection conn, Bank_User valueObject) throws SQLException;
	public void save(Connection conn, Bank_User valueObject) throws NotFoundException, SQLException;
	public void delete(Connection conn, Bank_User valueObject) throws NotFoundException, SQLException;
	public void deleteAll(Connection conn) throws SQLException;
	public int countAll(Connection conn) throws SQLException;
	public List<Bank_User> searchMatching(Connection conn, Bank_User valueObject) throws SQLException;
	public int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException;
	public void singleQuery(Connection conn, PreparedStatement stmt, Bank_User valueObject) 
			throws NotFoundException, SQLException;
	public List<Bank_User> listQuery(Connection conn, PreparedStatement stmt) throws SQLException;
}
