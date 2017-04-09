package com.Revature.dao;

import java.sql.*;

import com.Revature.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO {

	// function to create a user
	@Override
	public String createUser(String name, String pass) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "BEGIN SP_CREATE_USER(?, ?, ?); END;";
			CallableStatement cstmt = con.prepareCall(sql);
			cstmt.setString(1, name);
			cstmt.setString(2, pass);
			cstmt.registerOutParameter(3, Types.INTEGER);
			cstmt.execute();
			int valid = cstmt.getInt(3);
			if (valid == 1)
				return name;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

	// function to check if entered user matches the password entered
	@Override
	public String logIn(String name, String pass) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "BEGIN SP_VALIDATE_USER(?, ?, ?); END;";
			CallableStatement cstmt = con.prepareCall(sql);
			cstmt.setString(1, name);
			cstmt.setString(2, pass);
			cstmt.registerOutParameter(3, Types.INTEGER);
			cstmt.execute();
			int valid = cstmt.getInt(3);
			if (valid == 1)
				return name;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "";
	}

	// function to add money to an account
	@Override
	public void addFunds(int bid, double money) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "BEGIN SP_ADD_FUNDS(?, ?, ?); END;";
			CallableStatement cstmt = con.prepareCall(sql);
			cstmt.setInt(1, bid);
			cstmt.setDouble(2, money);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.execute();
			System.out.println(cstmt.getString(3));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// function to remove money from an account
	@Override
	public void subFunds(int bid, double money) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "BEGIN SP_SUB_FUNDS(?, ?, ?); END;";
			CallableStatement cstmt = con.prepareCall(sql);
			cstmt.setInt(1, bid);
			cstmt.setDouble(2, money);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.execute();
			System.out.println(cstmt.getString(3));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// function to create a new bank account
	@Override
	public void createAcct(String uName, String acctName, double bal) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "BEGIN SP_CREATE_ACCT(?, ?, ?, ?); END;";
			CallableStatement cstmt = con.prepareCall(sql);
			cstmt.setString(1, uName);
			cstmt.setString(2, acctName);
			cstmt.setDouble(3, bal);
			cstmt.registerOutParameter(4, Types.VARCHAR);
			cstmt.execute();
			System.out.println(cstmt.getString(4));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// function to delete a bank account
	@Override
	public void deleteAcct(int bid) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "BEGIN SP_DEL_ACCT(?, ?); END;";
			CallableStatement cstmt = con.prepareCall(sql);
			cstmt.setInt(1, bid);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.execute();
			System.out.println(cstmt.getString(2));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// function to display all accounts owned by a user
	@Override
	public void fetchAccts(String name) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT BANK_ACCOUNT_ID, BANK_ACCOUNT_NAME, BALANCE FROM BANK_ACCOUNT WHERE USER_ID=FN_GET_UID(?)";
			PreparedStatement cstmt = con.prepareStatement(sql);
			cstmt.setString(1, name);
			ResultSet rs = cstmt.executeQuery();
			System.out.println(String.format("%-10s %-20s %-10s","Bank ID", "Account Name", "Balance"));
			while (rs.next()) {
				String a, b, c;
				a = rs.getString("BANK_ACCOUNT_ID");
				b = rs.getString("BANK_ACCOUNT_NAME");
				c = rs.getString("Balance");
				System.out.println(String.format("%-10s %-20s %-10s", a, b, c));
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// function to display ALL users' bank accounts
	@Override
	public void fetchAdmin() {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT BANK_ACCOUNT.BANK_ACCOUNT_ID, USER_ACCOUNT.USER_ID, "
					+ "USER_ACCOUNT.USER_NAME, BANK_ACCOUNT.BANK_ACCOUNT_NAME, "
					+ "BANK_ACCOUNT.BALANCE FROM BANK_ACCOUNT "
					+ "JOIN USER_ACCOUNT ON BANK_ACCOUNT.USER_ID = USER_ACCOUNT.USER_ID",
					str = "%-10s %-10s %-20s %-20s %-15s";
			PreparedStatement cstmt = con.prepareStatement(sql);
			ResultSet rs = cstmt.executeQuery();
			System.out.println(String.format(str, "BANK_ID", "USER_ID", "USER_NAME", "BANK_ACCOUNT_NAME", "BALANCE"));
			while (rs.next()) {
				String a, b, c, d, e;
				a = rs.getString("BANK_ACCOUNT_ID");
				b = rs.getString("USER_ID");
				c = rs.getString("USER_NAME");
				d = rs.getString("BANK_ACCOUNT_NAME");
				e = rs.getString("BALANCE");

				System.out.println(String.format(str, a, b, c, d, e));
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void fetchTrans(String name) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM TRANSACTION_HISTORY WHERE USER_ID="
					+ "(SELECT USER_ID FROM USER_ACCOUNT WHERE USER_NAME=?)",
					str = "%-10s %-10s %-20s";
			PreparedStatement cstmt = con.prepareStatement(sql);
			cstmt.setString(1, name);
			ResultSet rs = cstmt.executeQuery();
			System.out.println(String.format(str, "TRANS_ID", "USER_ID", "ACTION"));
			while (rs.next()) {
				String a, b, c;
				a = rs.getString("TRANS_ID");
				b = rs.getString("USER_ID");
				c = rs.getString("ACTION");
				

				System.out.println(String.format(str, a, b, c));
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	

	@Override
	public void fetchTransAdmin() {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM TRANSACTION_HISTORY",
					str = "%-10s %-10s %-20s";
			PreparedStatement cstmt = con.prepareStatement(sql);
			
			ResultSet rs = cstmt.executeQuery();
			System.out.println(String.format(str, "TRANS_ID", "USER_ID", "ACTION"));
			while (rs.next()) {
				String a, b, c;
				a = rs.getString("TRANS_ID");
				b = rs.getString("USER_ID");
				c = rs.getString("ACTION");
				

				System.out.println(String.format(str, a, b, c));
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
