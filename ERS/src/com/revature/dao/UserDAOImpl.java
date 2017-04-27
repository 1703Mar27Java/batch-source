package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.revature.bean.User;
import com.revature.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO {

	public String logIn(String name, String pass) {

		try (Connection con = ConnectionUtil.getConnection();) {

			String sql = "BEGIN SP_ERS_VALIDATE_USER(?, ?, ?); END;";
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

	@Override
	public User getUser(String userName) {
		try (Connection con = ConnectionUtil.getConnection();) {

			String sql = "SELECT * FROM VW_ERS_USERS WHERE USER_NAME=?";
			PreparedStatement pstmt = con.prepareCall(sql);
			pstmt.setString(1, userName);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String uN, fN, lN, em, ti;
				uN = rs.getString("USER_NAME");
				fN = rs.getString("FIRST_NAME");
				lN = rs.getString("LAST_NAME");
				em = rs.getString("EMAIL");
				ti = rs.getString("JOB_TITLE");
				User u = new User(uN, fN, lN, em, ti);
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void resetPass(String userName, String email) {
		try (Connection con = ConnectionUtil.getConnection();) {
			String sql = "BEGIN SP_ERS_RESET_PASS(?,?); END;";
			PreparedStatement pstmt = con.prepareCall(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, email);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean updateUser(String user, String email, String fName, String lName) {
		boolean success = false;
		try (Connection con = ConnectionUtil.getConnection();) {
			String sql = "UPDATE ERS_USERS SET U_EMAIL=?, U_FIRSTNAME=?, U_LASTNAME=? WHERE U_USERNAME=?";
			PreparedStatement pstmt = con.prepareCall(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, fName);
			pstmt.setString(3, lName);
			pstmt.setString(4, user);
			pstmt.execute();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return success;
	}
	
	public boolean mgrUpdateUser(String user, String email, String fName, String lName, String title) {
		boolean success = false;
		try (Connection con = ConnectionUtil.getConnection();) {
			String sql = "UPDATE ERS_USERS SET U_EMAIL=?, U_FIRSTNAME=?, U_LASTNAME=?, "
					+ "UR_ID=(SELECT UR_ID FROM ERS_USER_ROLES WHERE UR_ROLE=?)  WHERE U_USERNAME=?";
			PreparedStatement pstmt = con.prepareCall(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, fName);
			pstmt.setString(3, lName);
			pstmt.setString(4, title);
			pstmt.setString(5, user);
			System.out.println(email+" "+fName+" "+lName+" "+title+" "+user);
			pstmt.executeQuery();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return success;
	}


	@Override
	public boolean updatePw(String user, String pw) {
		boolean success = false;
		try (Connection con = ConnectionUtil.getConnection();) {
			String sql = "UPDATE ERS_USERS SET U_PASSWORD=? WHERE U_USERNAME=?";
			PreparedStatement pstmt = con.prepareCall(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, user);
			pstmt.execute();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return success;
	}

	@Override
	public boolean isMgr(String user) {
		boolean isMgr=false;
		try (Connection con = ConnectionUtil.getConnection();) {

			String sql = "SELECT JOB_TITLE FROM VW_ERS_USERS WHERE USER_NAME=?";
			PreparedStatement pstmt = con.prepareCall(sql);
			pstmt.setString(1, user);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			String ti = rs.getString("JOB_TITLE");
			if(ti.equals("Manager"))
				isMgr=true;
			else
				isMgr=false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isMgr;
	}
}
