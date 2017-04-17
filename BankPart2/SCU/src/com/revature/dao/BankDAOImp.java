package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.domain.Account;
import com.revature.domain.Transaction;
import com.revature.domain.User;
import com.revature.util.ConnectionUtil;

public class BankDAOImp implements BankDAO {

	@Override
	public void createUser(String username, String password) {
		try (Connection con = ConnectionUtil.getConnection()) {
			String userQuery = "INSERT INTO B_USER (USER_NAME, PASSWORD)" + "VALUES (?, ?)";

			PreparedStatement pstmt = con.prepareStatement(userQuery);
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean userExists(String username) {
		try (Connection con = ConnectionUtil.getConnection()) {
			String userQuery = "SELECT USER_ID FROM B_USER WHERE USER_NAME = ?";

			PreparedStatement pstmt = con.prepareStatement(userQuery);
			pstmt.setString(1, username);

			ResultSet result = pstmt.executeQuery();

			if (result.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUser(String username, String password) {
		User user = null;
		try (Connection con = ConnectionUtil.getConnection()) {
			String userQuery = "SELECT USER_ID FROM B_USER WHERE USER_NAME = ? AND PASSWORD = ?";

			PreparedStatement pstmt = con.prepareStatement(userQuery);
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet result = pstmt.executeQuery();

			if (result.next()) {
				user = new User(username, password, result.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void getAccounts(User user) {
		ArrayList<Account> accounts = new ArrayList<Account>();
		try (Connection con = ConnectionUtil.getConnection()) {
			int id = user.getuId();
			String accountQuery = "SELECT BANK_ACCOUNT_NAME, BANK_ACCOUNT_BALANCE, BANK_ACCOUNT_ID "
					+ "FROM B_ACCOUNT WHERE USER_ID = ?";

			PreparedStatement pstmt = con.prepareStatement(accountQuery);
			pstmt.setInt(1, id);

			ResultSet result = pstmt.executeQuery();

			while (result.next()) {
				accounts.add(new Account(result.getString(1), result.getInt(2), result.getInt(3)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		user.setAccounts(accounts);
	}

	@Override
	public void createAccount(User user, Account account) {
		try (Connection con = ConnectionUtil.getConnection()) {
			int id = user.getuId();
			String name = account.getName();

			String accountCreate = "INSERT INTO B_ACCOUNT (USER_ID, BANK_ACCOUNT_NAME, BANK_ACCOUNT_BALANCE)"
					+ "VALUES (?, ?, ?)";

			PreparedStatement pstmt = con.prepareStatement(accountCreate);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, 0);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAccount(User user, Account account) {
		try (Connection con = ConnectionUtil.getConnection()) {
			int id = user.getuId();
			String accountName = account.getName();

			String accountDelete = "DELETE FROM B_ACCOUNT WHERE USER_ID = ? AND BANK_ACCOUNT_NAME = ?";

			PreparedStatement pstmt = con.prepareStatement(accountDelete);
			pstmt.setInt(1, id);
			pstmt.setString(2, accountName);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void depositAccount(Account account, int deposit) {
		try (Connection con = ConnectionUtil.getConnection()) {
			;
			int aId = account.getId();

			String depositCall = "{CALL SP_DEPOSIT (?, ?)}";

			CallableStatement cstmt = con.prepareCall(depositCall);
			cstmt.setInt(1, aId);
			cstmt.setInt(2, deposit);
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void withdrawAccount(Account account, int withdraw) {
		try (Connection con = ConnectionUtil.getConnection()) {
			;
			int aId = account.getId();
			String withdrawCall = "{CALL SP_WITHDRAW (?, ?)}";
			CallableStatement cstmt = con.prepareCall(withdrawCall);
			cstmt.setInt(1, aId);
			cstmt.setInt(2, withdraw);
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Transaction> getTransaction(Account account) {
		ArrayList<Transaction> trans = new ArrayList<Transaction>();
		try (Connection con = ConnectionUtil.getConnection()) {
			int aId = account.getId();
			String transactionQuery = "SELECT TRANSACTION_TYPE, TRANSACTION_DATE, TRANSACTION_AMOUNT "
					+ "FROM B_TRANSACTION WHERE B_ACCOUNT_ID = ? ORDER BY TRANSACTION_DATE DESC";

			PreparedStatement pstmt = con.prepareStatement(transactionQuery);
			pstmt.setInt(1, aId);

			ResultSet result = pstmt.executeQuery();

			while (result.next()) {
				trans.add(new Transaction(result.getInt(3), result.getString(2), result.getString(1)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trans;
	}

	@Override
	public ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<User>();
		try (Connection con = ConnectionUtil.getConnection()) {
			String userQuery = "SELECT * FROM B_USER ORDER BY USER_NAME";

			PreparedStatement pstmt = con.prepareStatement(userQuery);

			ResultSet result = pstmt.executeQuery();

			while (result.next()) {
				users.add(new User(result.getString(2), result.getString(3), result.getInt(1)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public void deleteUser(String username) {
		try (Connection con = ConnectionUtil.getConnection()) {

			String deleteStatement = "DELETE FROM B_USER WHERE USER_NAME = ?";

			PreparedStatement pstmt = con.prepareStatement(deleteStatement);
			pstmt.setString(1, username);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(String username, String newUsername, String newPassword) {
		try (Connection con = ConnectionUtil.getConnection()) {
			String updateStatement = "UPDATE B_USER SET USER_NAME = ?, PASSWORD = ? WHERE USER_NAME = ?";

			PreparedStatement pstmt = con.prepareStatement(updateStatement);

			pstmt.setString(1, newUsername);
			pstmt.setString(2, newPassword);
			pstmt.setString(3, username);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}