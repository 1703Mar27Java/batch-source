package com.revature.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UserDAOImpl;
import com.revature.domain.UserBackBean;
import com.revature.domain.UserFrontBean;

public class UserDAOUtil
{
	private static final String filename = new File("C:\\Revature\\ReimbursementProjectNew\\WebContent\\connection.properties").getAbsolutePath();
	public static boolean authenticateUser(String username, String password)
	{
		UserDAOImpl dao = new UserDAOImpl();
		UserBackBean checkAgainst = dao.getUser(dao.getUserID(username, filename), filename);
		System.out.println("test");
		System.out.println(checkAgainst.toString());
		
		//user doesn't exist
		if(checkAgainst.getId()==0)
		{
			return false;
		}
		
		UserBackBean user = new UserBackBean();
		user.setUsername(username);
		user.setPassword(password);
		
		if(user.getPassword().equals(checkAgainst.getPassword()))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public static UserFrontBean translateBacktoFrontBean(UserBackBean back)
	{
		UserDAOImpl dao = new UserDAOImpl();
		UserFrontBean user = new UserFrontBean();
		user.setId(back.getId());
		user.setFirstName(back.getFirstName());
		user.setLastName(back.getLastName());
		user.setUsername(back.getUsername());
		user.setPassword(back.getPassword());
		user.setEmail(back.getEmail());
		user.setuRole(dao.getRole(back, filename));
		return user;
	}
	
	public static UserBackBean translateFrontToBackBean(UserFrontBean front)
	{
		UserDAOImpl dao = new UserDAOImpl();
		UserBackBean user = new UserBackBean();
		user.setId(front.getId());
		user.setFirstName(front.getFirstName());
		user.setLastName(front.getLastName());
		user.setUsername(front.getUsername());
		user.setPassword(front.getPassword());
		user.setEmail(front.getEmail());
		user.setuRole(dao.getRoleID(front.getuRole(), filename));
		return user;
	}

	public static UserBackBean getUserHelper(String username)
	{
		UserBackBean user = new UserBackBean();
		UserDAOImpl dao = new UserDAOImpl();
		
		user = dao.getUser(dao.getUserID(username, filename), filename);
		return user;	
	}

	public static UserBackBean getUserByIDHelper(int userID)
	{
		UserBackBean user = new UserBackBean();
		UserDAOImpl dao = new UserDAOImpl();
		user = dao.getUserByID(userID, filename);
		return user;
	}
	
	public static boolean updateUserHelper(UserFrontBean front, boolean reset)
	{
		UserDAOImpl dao = new UserDAOImpl();

		UserBackBean back = new UserBackBean();
		back = getUserByIDHelper(front.getId());
		
		if(!front.getFirstName().equals("") || !front.getFirstName().equals(null))
		{
			back.setFirstName(front.getFirstName());
		}
		
		if(!front.getLastName().equals("") || !front.getLastName().equals(null))
		{
			back.setLastName(front.getLastName());
		}
		
		if(!front.getUsername().equals("") || !front.getUsername().equals(null))
		{
			back.setUsername(front.getUsername());
		}
		
		if(!front.getEmail().equals("") || !front.getEmail().equals(null))
		{
			back.setEmail(front.getEmail());
		}
		
		if(reset)
		{
			resetPassword(back);
		}
		
		return dao.updateUser(back, filename);
		
	}
	
	public static boolean resetPassword(UserBackBean back)
	{
		return false;
	}
	
	public static List<UserFrontBean> getAllFrontEmps()
	{
		ArrayList<UserFrontBean> frontList = new ArrayList<UserFrontBean>();
		ArrayList<UserBackBean> backList = new ArrayList<UserBackBean>();

		UserDAOImpl dao = new UserDAOImpl();
		backList = (ArrayList<UserBackBean>)dao.getUsers(1, filename);
		for(int i = 0; i < backList.size(); i++)
		{
			UserFrontBean user = new UserFrontBean();
			user = UserDAOUtil.translateBacktoFrontBean(backList.get(i));
			frontList.add(user);
		}
		return frontList;
		
	}


	public static boolean createUserHelper(UserFrontBean user)
	{
		UserDAOImpl dao = new UserDAOImpl();
		UserBackBean back = new UserBackBean();
		back = translateFrontToBackBean(user);
		return dao.createUser(back, filename);
	}
}
