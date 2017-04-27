package com.revature.util;

import java.util.concurrent.ThreadLocalRandom;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;
import com.revature.domain.User;
import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.EmailException;
import com.revature.exceptions.PasswordException;
import com.revature.exceptions.UsernameException;

public class UserUtil {
	
	
	public static void tryCreate(User user) throws UsernameException{
		UserDAO udao = new UserDAOImp();
		
		if(udao.userExists(user.getUsername())){
			throw new UsernameException("Username already exists");
		} else {
			udao.createUser(user);
		}
	}
	
	public static void tryUpdateUserInformation(User user, String firstName, String lastName, String email) throws EmailException{
		UserDAO udao = new UserDAOImp();
		
		if(!udao.emailExists(email) || user.getEmail().equals(email)){
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			udao.updateUser(user);
		} else{		
			throw new EmailException("Email already exists");
		}
	}
	
	public static void tryUpdatePassword(User user, String password, String confirm) throws PasswordException{
		UserDAO udao = new UserDAOImp();
		
		if(!password.equals(confirm)){
			throw new PasswordException("Passwords do not match");
		} else{
			user.setPassword(password);
			udao.updateUser(user);
		}
	}
	
	public static User tryLogin(String username, String password) throws AuthenticationException{
		UserDAO udao = new UserDAOImp();
		
		User user = udao.getUserByUsername(username);
		
		if(user == null || !(user.getPassword().equals(password))){
			throw new AuthenticationException("Incorrect username or password");
		}
		
		return user;
	}
	
	public static String generateString(int rng, String characters, int length)
	{
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++)
	    {
	    	int rand = ThreadLocalRandom.current().nextInt(rng);
	        text[i] = characters.charAt(rand);
	    }
	    return new String(text);
	}
	
	

}
