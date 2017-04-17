package com.Revature.dao;

import java.sql.*;
import java.util.ArrayList;

import com.Revature.beans.BankAcct;
import com.Revature.beans.Trans;
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
			System.out.println("Error in adding funds");
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
			System.out.println("Error in removing funds");
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
			System.out.println("Error in creating an account.");
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
			System.out.println("Error in deleting an account.");
		}

	}

	// function to display all accounts owned by a user
	@Override
	public ArrayList<BankAcct> fetchAccts(String name) {
		Connection con;
		ArrayList<BankAcct> bList = new ArrayList<>();
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT BANK_ACCOUNT_ID, BANK_ACCOUNT_NAME, BALANCE FROM BANK_ACCOUNT WHERE USER_ID=FN_GET_UID(?)";
			PreparedStatement cstmt = con.prepareStatement(sql);
			cstmt.setString(1, name);
			ResultSet rs = cstmt.executeQuery();
			while (rs.next()) {
				String ban;
				double bal;
				int bid;
				bid = rs.getInt("BANK_ACCOUNT_ID");
				ban = rs.getString("BANK_ACCOUNT_NAME");
				bal = rs.getDouble("Balance");
				BankAcct b = new BankAcct(bid, ban, bal);
				bList.add(b);
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bList;
	}

	// function to display ALL users' bank accounts
	@Override
	public ArrayList<BankAcct> fetchAdmin() {
		Connection con;
		ArrayList<BankAcct> bList = new ArrayList<>();
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
				int a, b;
				String c, d;
				double e;
				a = Integer.parseInt(rs.getString("BANK_ACCOUNT_ID"));
				b = Integer.parseInt(rs.getString("USER_ID"));
				c = rs.getString("BANK_ACCOUNT_NAME");
				d = rs.getString("USER_NAME");
				e = Double.parseDouble(rs.getString("BALANCE"));
				//BankAcct(int bid, int uid, String aName, String uName, double bal)
				BankAcct bank = new BankAcct(a,b,c,d,e);
				bList.add(bank);
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bList;
	}

	@Override
	public ArrayList<Trans> fetchTrans(String name) {
		Connection con;
		ArrayList<Trans> tList = new ArrayList<>();
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM TRANSACTION_HISTORY WHERE USER_ID="
					+ "(SELECT USER_ID FROM USER_ACCOUNT WHERE USER_NAME=?) ORDER BY TRANS_ID DESC";
			PreparedStatement cstmt = con.prepareStatement(sql);
			cstmt.setString(1, name);
			ResultSet rs = cstmt.executeQuery();
			while (rs.next()) {
				String a, b, c;
				a = rs.getString("TRANS_ID");
				b = rs.getString("USER_ID");
				c = rs.getString("ACTION");
				Trans t = new Trans(Integer.parseInt(a), Integer.parseInt(b), c);
				tList.add(t); 
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tList;
	}

	@Override
	public ArrayList<Trans> fetchTransAdmin() {
		Connection con;
		ArrayList<Trans> tList = new ArrayList<>();
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM TRANSACTION_HISTORY ORDER BY TRANS_ID DESC";
			PreparedStatement cstmt = con.prepareStatement(sql);
			ResultSet rs = cstmt.executeQuery();
			while (rs.next()) {
				String a, b, c;
				a = rs.getString("TRANS_ID");
				b = rs.getString("USER_ID");
				c = rs.getString("ACTION");
				Trans t = new Trans(Integer.parseInt(a), Integer.parseInt(b), c);
				tList.add(t);
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tList;
	}

	@Override
	public String getUserOfBankAcct(int bid) {
		Connection con;
		String name=null;
		try{
			con = ConnectionUtil.getConnection();
			String sql = "SELECT USER_NAME FROM USER_ACCOUNT WHERE USER_ID="
					+ "(SELECT USER_ID FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_ID=?)";
			PreparedStatement cstmt = con.prepareStatement(sql);
			cstmt.setInt(1, bid);
			ResultSet rs = cstmt.executeQuery();
			rs.next();
			name=rs.getString("USER_NAME");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return name;
	}

}
