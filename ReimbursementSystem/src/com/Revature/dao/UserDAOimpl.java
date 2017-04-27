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

import com.Revature.domain.User;
import com.Revature.util.ConnectionUtil;

import oracle.jdbc.internal.OracleTypes;
import oracle.net.aso.s;

public class UserDAOimpl implements UserDAO {
	
	@Override
	public void createUser(User user) throws UsernameExistsException {
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");) {
			String username = user.getUsername();
			String password = user.getPassword();
			String fname = user.getFirstname();
			String lname = user.getLastname();
			String email = user.getEmail();
			Integer rid = user.getUserRoleID();
			PreparedStatement cs = con.prepareStatement("{call CREATE_USER(?,?,?,?,?,?)}");
			cs.setString(1, username);
			cs.setString(2, password);
			cs.setString(3, fname);
			cs.setString(4, lname);
			cs.setString(5, email);
			cs.setInt(6, rid);
			int numRowsAffected = cs.executeUpdate();
			if(numRowsAffected == 0){
				throw new UsernameExistsException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public User UserByLogin(String username, String password) throws IncorrectLoginException {
		CallableStatement cs = null;
		User user = new User();
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");) {
			cs = con.prepareCall("{call RETRIEVE_USER_LOGIN(?,?,?)}");	//change procedure
			cs.setString(1, username);
			cs.setString(2, password);
			cs.registerOutParameter(3, OracleTypes.CURSOR);
			cs.executeUpdate();
			ResultSet rs = (ResultSet) cs.getObject(3);
			if (!rs.next()) {
				rs.close();
				cs.close();
				con.close();
				System.out.println("Incorrect Login Exception");
				throw new IncorrectLoginException();
			} else {
				user.setUserID(rs.getInt("U_ID"));
				user.setUsername(rs.getString("U_USERNAME"));
				user.setPassword(rs.getString("U_PASSWORD"));
				user.setFirstname(rs.getString("U_FIRSTNAME"));
				user.setLastname(rs.getString("U_LASTNAME"));
				user.setEmail(rs.getString("U_EMAIL"));
				user.setUserRoleID(rs.getInt("UR_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		CallableStatement cs = null;
		List<User> users = new ArrayList<User>();
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");) {
			cs = con.prepareCall("{call ALL_USERS(?)}");	//change procedure
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.executeUpdate();
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()){
				User user = new User();
				user.setUserID(rs.getInt("U_ID"));
				user.setUsername(rs.getString("U_USERNAME"));
				user.setPassword(rs.getString("U_PASSWORD"));
				user.setFirstname(rs.getString("U_FIRSTNAME"));
				user.setLastname(rs.getString("U_LASTNAME"));
				user.setEmail(rs.getString("U_EMAIL"));
				user.setUserRoleID(rs.getInt("UR_ID"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User getUserByID(int uid) {
		CallableStatement cs = null;
		User user = new User();
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");) {
			cs = con.prepareCall("{call USER_BY_ID(?,?)}");	//change procedure
			cs.setInt(1, uid);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.executeUpdate();
			ResultSet rs = (ResultSet) cs.getObject(2);
			if (!rs.next()) {
				rs.close();
				cs.close();
				con.close();
			} else {
				user.setUserID(rs.getInt("U_ID"));
				user.setUsername(rs.getString("U_USERNAME"));
				user.setPassword(rs.getString("U_PASSWORD"));
				user.setFirstname(rs.getString("U_FIRSTNAME"));
				user.setLastname(rs.getString("U_LASTNAME"));
				user.setEmail(rs.getString("U_EMAIL"));
				user.setUserRoleID(rs.getInt("UR_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}
}
