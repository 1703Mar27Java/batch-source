package com.Revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Revature.domain.BankAccount;
import com.Revature.domain.User;
import com.Revature.util.ConnectionUtil;

import oracle.jdbc.internal.OracleTypes;

public class UserDAOimpl implements UserDAO {

	@Override
	public void createUser(User user) {
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");) {
			String username = user.getUsername();
			String password = user.getPassword();

			PreparedStatement pstmt = con.prepareStatement("{call CREATE_USER(?,?,0)}");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			int numRowsAffected = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public User UserByID(int id) {
		CallableStatement cs = null;
		User user = new User();

		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");) {
			cs = con.prepareCall("{call RETRIEVE_USER(?,?)}");
			cs.setInt(1, id);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.executeUpdate();
			ResultSet rs = (ResultSet) cs.getObject(2);
			while (rs.next()) {
				user.setUserID(rs.getInt("USER_ID"));
				user.setUsername(rs.getString("USER_NAME"));
				user.setPassword(rs.getString("PASS"));
				user.setSuperPriv(rs.getInt("SUPER"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User UserByLogin(String username, String password) throws IncorrectLoginException {
		CallableStatement cs = null;
		User user = new User();
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");) {
			cs = con.prepareCall("{call RETRIEVE_USER_LOGIN(?,?,?)}");
			cs.setString(1, username);
			cs.setString(2, password);
			cs.registerOutParameter(3, OracleTypes.CURSOR);
			cs.executeUpdate();
			ResultSet rs = (ResultSet) cs.getObject(3);
			if (!rs.isBeforeFirst()) {
				rs.close();
				cs.close();
				con.close();
				throw new IncorrectLoginException();
			} else {
				rs.next();
				user.setUserID(rs.getInt("USER_ID"));
				user.setUsername(rs.getString("USER_NAME"));
				user.setPassword(rs.getString("PASS"));
				user.setSuperPriv(rs.getInt("SUPER"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> retrieveAllUsers() {
		Statement stmt = null;
		List<User> users = new ArrayList<>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");){
			stmt = con.createStatement();
			String query = ("SELECT * FROM BANKUSER");
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				User user = new User();
				user.setPassword(rs.getString("PASS"));
				user.setSuperPriv(rs.getInt("SUPER"));
				user.setUserID(rs.getInt("USER_ID"));
				user.setUsername(rs.getString("USER_NAME"));
				users.add(user);
			}
		}catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	@Override
	public List<BankAccount> retrieveAccounts(int userid) {
		CallableStatement cs = null;
		List<BankAccount> accts = new ArrayList<>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");){
			cs = con.prepareCall("{call RETRIEVE_ALL_ACCOUNTS(?,?)}");
			cs.setInt(1, userid);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.executeUpdate();
			ResultSet rs = (ResultSet) cs.getObject(2);
			while(rs.next()){
				BankAccount acct = new BankAccount();
				acct.setAccountID(rs.getInt("BANK_ACCOUNTID"));
				acct.setAccountName(rs.getString("BANK_ACCOUNT_NAME"));
				acct.setBalance(rs.getDouble("BALANCE"));
				acct.setUserID(rs.getInt("USER_ID"));
				accts.add(acct);
			}
		}catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return accts;
	}
	
	@Override
	public void updateUserName(User user, String username) {
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");){
			int userid = user.getUserID();
			PreparedStatement pstmt = con.prepareStatement("{call UPDATE_USER_NAME(?,?)}");
			pstmt.setInt(1, userid);
			pstmt.setString(2, username);
			int numRowsAffected = pstmt.executeUpdate();
			//System.out.println("NumofRowsAffected: "+ numRowsAffected);
		}catch(SQLException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public void updateUserPass(User user, String pass) {
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");){
			int userid = user.getUserID();
			PreparedStatement pstmt = con.prepareStatement("{call UPDATE_USER_PASS(?,?)}");
			pstmt.setInt(1, userid);
			pstmt.setString(2, pass);
			int numRowsAffected = pstmt.executeUpdate();
			//System.out.println("NumofRowsAffected: "+ numRowsAffected);
		}catch(SQLException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(int id) {
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");){
			User user = UserByID(id);
			PreparedStatement pstmt = con.prepareStatement("{call DELETE_USER(?)}");
			pstmt.setInt(1, id);
			int numRowsAffected = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
