package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.UserBackBean;
import com.revature.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO {

	public boolean createUser(UserBackBean user, String filename) 
	{
		
		try 
		{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "BEGIN SP_CREATE_USER(?, ?, ?, ?, ?, ?, ?); END;";
			CallableStatement cstmt = con.prepareCall(sql);
			cstmt.setString(1, user.getUsername());
			cstmt.setString(2, user.getPassword());
			cstmt.setString(3, user.getFirstName());
			cstmt.setString(4, user.getLastName());
			cstmt.setString(5, user.getEmail());
			cstmt.setInt(6, user.getuRole());;
			cstmt.registerOutParameter(7, Types.INTEGER);
			cstmt.execute();
			int success = cstmt.getInt(7);
			if(success == 1)
			{
				return true;
			}
			else return false;

		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
			return false;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		} 
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public UserBackBean getUser(int userID, String filename) 
	{
		UserBackBean user = new UserBackBean();
		try 
		{
			Connection con;
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM ERS_USERS WHERE U_ID = "+ userID;
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet results = pstmt.executeQuery();
			
			while (results.next())
			{
				user.setId(Integer.parseInt(results.getString("U_ID")));
				user.setUsername(results.getString("U_USERNAME"));
				user.setPassword(results.getString("U_PASSWORD"));
				user.setFirstName(results.getString("U_FIRSTNAME"));
				user.setLastName(results.getString(("U_LASTNAME")));
				user.setEmail(results.getString(("U_EMAIL")));
				user.setuRole(Integer.parseInt(results.getString("UR_ID")));

			}
			return user;
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		} 
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return null;
		}
	}

	public List<UserBackBean> getUsers(int role, String filename) 
	{
		try 
		{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			
			List<UserBackBean> userList = new ArrayList<UserBackBean>();
			String sql = "SELECT * FROM ERS_USERS WHERE UR_ID =" + role;
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet results = pstmt.executeQuery();

			while (results.next())
			{
				UserBackBean user = new UserBackBean();

				user.setId(Integer.parseInt(results.getString("U_ID")));
				user.setUsername(results.getString("U_USERNAME"));
				user.setPassword(results.getString("U_PASSWORD"));
				user.setFirstName(results.getString("U_FIRSTNAME"));
				user.setLastName(results.getString(("U_LASTNAME")));
				user.setEmail(results.getString(("U_EMAIL")));
				user.setuRole(Integer.parseInt(results.getString("UR_ID")));
					
				userList.add(user);

			}
			return userList;
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		} 
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return null;
		}
	}

	public boolean updateUser(UserBackBean user, String filename) 
	{
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "BEGIN SP_UPDATE_USER(?, ?, ?, ?, ?, ?, ?, ?); END;";
			CallableStatement cstmt = con.prepareCall(sql);
			cstmt.setInt(1, user.getId());
			cstmt.setString(2, user.getUsername());
			cstmt.setString(3, user.getPassword());
			cstmt.setString(4, user.getFirstName());
			cstmt.setString(5, user.getLastName());
			cstmt.setString(6, user.getEmail());
			cstmt.setInt(7, user.getuRole());
			cstmt.registerOutParameter(8, Types.INTEGER);
			cstmt.execute();
			int success = cstmt.getInt(8);
			if(success == 1)
			{
				return true;
			}
			else
			{
				return false;
			}

			
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
			return false;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		} 
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUser(int userID, String filename) 
	{
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "DELETE FROM ERS_USERS WHERE U_ID = "+ userID;
			PreparedStatement pstmt = con.prepareStatement(sql);
			int numRowsAffected = pstmt.executeUpdate();
			if (numRowsAffected == 1) 
			{
				return true;
			}
			
			else
			{
				return false;
			}
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
			return false;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		} 
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public int getUserID(String username, String filename) 
	{
		int userID = 0;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT U_ID FROM ERS_USERS WHERE U_USERNAME = '"+ username + "'";
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet results = pstmt.executeQuery();
			
			while (results.next())
			{
				userID = Integer.parseInt(results.getString("U_ID"));
			}
			return userID;
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			return userID;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return userID;
		}
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return userID;
		}
	}

	public String getRole(UserBackBean user, String filename) 
	{
		String role = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) 
		{
			String sql = "SELECT UR_ROLE FROM ERS_USER_ROLES WHERE UR_ID = " + user.getuRole();
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet results = pstmt.executeQuery();
			
			while (results.next())
			{
				role = results.getString("UR_ROLE");
			}
			return role;
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			return role;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return role;
		} 
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return role;
		}
	}

	@Override
	public UserBackBean getUserByID(int userID, String filename) 
	{
		UserBackBean user = new UserBackBean();
		System.out.println(userID);
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT * FROM ERS_USERS WHERE U_ID = " + userID;
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet results = pstmt.executeQuery();
			
			while (results.next())
			{
				user.setId(userID);
				user.setUsername(results.getString("U_USERNAME"));
				user.setPassword(results.getString("U_PASSWORD"));
				user.setFirstName(results.getString("U_FIRSTNAME"));
				user.setLastName(results.getString("U_LASTNAME"));
				user.setEmail(results.getString("U_EMAIL"));
				user.setuRole(Integer.parseInt(results.getString("UR_ID")));
			}
			return user;
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			return user;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return user;
		} 
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return user;
		}	}

	@Override
	public int getRoleID(String role, String filename) 
	{
		int roleID = 0;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT UR_ID FROM ERS_USER_ROLES WHERE UR_ROLE = '"+ role + "'";
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet results = pstmt.executeQuery();
			
			while (results.next())
			{
				roleID = Integer.parseInt(results.getString("RS_ID"));
			}
			return roleID;
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			return roleID;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return roleID;
		} 
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return roleID;
		}
	}
	

}
