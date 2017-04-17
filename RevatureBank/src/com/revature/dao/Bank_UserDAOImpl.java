package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import com.revature.bean.Bank_User;
import com.revature.util.ConnectionUtil;

public class Bank_UserDAOImpl implements Bank_UserDAO {

	@Override
	public int getUser(String userName, String userPassword) throws SQLException, IOException {

		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANK_USER WHERE BANK_USER_NAME = ? AND BANK_USER_PASSWORD = ?";
			PreparedStatement stmt = null;
			ResultSet result = null;
			int userId;

			stmt = connection.prepareStatement(sql);
			stmt.setString(1, userName);
			stmt.setString(2, userPassword);
			result = stmt.executeQuery();
			result.next();
			userId = result.getInt("BANK_USER_ID");
			return userId;

		} finally {
			
		}
	}

	@Override
	public List<Bank_User> getAllUsers() throws SQLException, IOException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Bank_User> searchResults = new ArrayList<>();

		try {
			String sql = "SELECT * FROM BANK_USER ORDER BY BANK_USER_ID ASC ";
			stmt = connection.prepareStatement(sql);
			result = stmt.executeQuery();

			while (result.next()) {
				Bank_User temp = new Bank_User();

				temp.setBANK_USER_ID(result.getInt("BANK_USER_ID"));
				temp.setBANK_USER_NAME(result.getString("BANK_USER_NAME"));
				temp.setBANK_USER_PASSWORD(result.getString("BANK_USER_PASSWORD"));

				searchResults.add(temp);
			}
			return searchResults;
		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}

	}

	@SuppressWarnings("unused")
	@Override
	public void createUser(Bank_User valueObject) throws SQLException, IOException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			sql = "INSERT INTO BANK_USER ( BANK_USER_ID, BANK_USER_NAME, BANK_USER_PASSWORD) " + "VALUES (?, ?, ?) ";
			stmt = connection.prepareStatement(sql);

			stmt.setInt(1, valueObject.getBANK_USER_ID());
			stmt.setString(2, valueObject.getBANK_USER_NAME());
			stmt.setString(3, valueObject.getBANK_USER_PASSWORD());

			stmt.executeUpdate();

		} finally {
			if (stmt != null)
				stmt.close();
		}
	}

	@Override
	public void updateUser(Bank_User valueObject) throws SQLException, IOException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "UPDATE BANK_USER SET BANK_USER_NAME = ?, " + "BANK_USER_PASSWORD = ? WHERE (BANK_USER_ID = ? ) ";
		PreparedStatement stmt = null;

		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, valueObject.getBANK_USER_NAME());
			stmt.setString(2, valueObject.getBANK_USER_PASSWORD());

			stmt.setInt(3, valueObject.getBANK_USER_ID());

			stmt.executeUpdate();
		} finally {
			if (stmt != null)
				stmt.close();
		}
	}

	@Override
	public void deleteUser(Bank_User valueObject) throws SQLException, IOException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "DELETE FROM BANK_USER WHERE (BANK_USER_ID = ? ) ";
		PreparedStatement stmt = null;

		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, valueObject.getBANK_USER_ID());

			stmt.executeUpdate();

		} finally {
			if (stmt != null)
				stmt.close();
		}
	}

	@SuppressWarnings("unused")
	@Override
	public void deleteAllUsers() throws SQLException, IOException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "DELETE FROM BANK_USER";
		PreparedStatement stmt = null;

		try {
			stmt = connection.prepareStatement(sql);
			int rowcount = stmt.executeUpdate();
		} finally {
			if (stmt != null)
				stmt.close();
		}
	}
}
