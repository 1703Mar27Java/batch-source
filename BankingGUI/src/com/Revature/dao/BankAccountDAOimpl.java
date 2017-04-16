package com.Revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.Revature.domain.BankAccount;
import com.Revature.util.ConnectionUtil;

import oracle.jdbc.OracleTypes;

public class BankAccountDAOimpl implements BankAccountDAO {

	@Override
	public void createAccount(BankAccount acct) {
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");){
			int userid = acct.getUserID();
			String name = acct.getAccountName();
			PreparedStatement pstmt = con.prepareStatement("{call CREATE_BANK_ACCOUNT(?,?,0)}");
			pstmt.setInt(1, userid);
			pstmt.setString(2, name);
			int numRowsAffected = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public BankAccount retrieveAccountByID(int id) {
		CallableStatement cs = null;
		BankAccount acct = new BankAccount();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");){
			cs = con.prepareCall("{call RETRIEVE_BANK_ACCOUNT(?,?)}");
			cs.setInt(1, id);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(2);
			while(rs.next()){
				acct.setAccountID(rs.getInt("BANK_ACCOUNTID"));
				acct.setAccountName(rs.getString("BANK_ACCOUNT_NAME"));
				acct.setBalance(rs.getDouble("BALANCE"));
				acct.setUserID(rs.getInt("USER_ID"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return acct;
	}

	@Override
	public void updateAccount(BankAccount acct, String newName) {
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");){
			int acctid = acct.getAccountID();
			PreparedStatement pstmt = con.prepareStatement("{call UPDATE_BANK_ACCOUNT(?,?)}");
			pstmt.setInt(1, acctid);
			pstmt.setString(2, newName);
			int numRowsAffected = pstmt.executeUpdate();
			//System.out.println("NumofRowsAffected: "+ numRowsAffected);
		}catch(SQLException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBankAccount(int id) throws DeletingNonZeroAccountException{
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");){
			BankAccount acct = retrieveAccountByID(id);
			if(acct.getBalance() != 0){
				throw new DeletingNonZeroAccountException();
			}else{
				PreparedStatement pstmt = con.prepareStatement("{call DELETE_BANK_ACCOUNT(?)}");
				pstmt.setInt(1, id);
				int numRowsAffected = pstmt.executeUpdate();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public void deposit(BankAccount acct, double amt){
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");){
			int userid = acct.getUserID();
			int acctid = acct.getAccountID();
			PreparedStatement pstmt = con.prepareStatement("{call DEPOSIT(?,?,?)}");
			pstmt.setDouble(1, amt);
			pstmt.setInt(2, userid);
			pstmt.setInt(3, acctid);
			int numRowsAffected = pstmt.executeUpdate();
			//System.out.println("NumofRowsAffected: "+ numRowsAffected);
		}catch(SQLException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void withdraw(BankAccount acct, double amt) throws OverdraftException{
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");){
			if((acct.getBalance()-amt)<0){
				throw new OverdraftException();
			}
			int userid = acct.getUserID();
			int acctid = acct.getAccountID();
			PreparedStatement pstmt = con.prepareStatement("{call WITHDRAW(?,?,?)}");
			pstmt.setDouble(1, amt);
			pstmt.setInt(2, userid);
			pstmt.setInt(3, acctid);
			int numRowsAffected = pstmt.executeUpdate();
			//System.out.println("NumofRowsAffected: "+ numRowsAffected);
		}catch(SQLException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
