package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import com.revature.bankExceptions.PasswordException;
import com.revature.bankExceptions.UserDoesntExistException;
import com.revature.bankExceptions.UserNameAlreadyExistsException;
import com.revature.dao.BankDAOImp;
import com.revature.domain.User;

public class UserUtil {
	public static User tryLogin(String username, String password) throws PasswordException {
		System.out.println("\nLoading... one moment please :)");
		BankDAOImp dao = new BankDAOImp();
		User user = dao.getUser(username, password);
		if (user != null) {
			return user;
		} else {
			throw new PasswordException("Incorrect username or password");
		}

	}

	public static User trySuper(String password) throws PasswordException {
		Properties prop = new Properties();
		InputStream input = null;
		String admin = null;

		try {
			input = new FileInputStream("bank.properties");
			prop.load(input);
			admin = prop.getProperty("admin");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\nLoading... one moment please :)");
		BankDAOImp dao = new BankDAOImp();
		User user = dao.getUser(admin, password);

		if (user != null) {
			return user;
		} else {
			throw new PasswordException("Incorrect password");
		}
	}

	public static User tryCreate(String username, String password, String confirm)
			throws UserNameAlreadyExistsException, PasswordException {
		BankDAOImp dao = new BankDAOImp();
		User user = null;
		if (password.equals(confirm)) {
			if (!dao.userExists(username)) {
				System.out.println("\nThank you for setting up a Bank Account\n");
				dao.createUser(username, password);
				user = dao.getUser(username, password);
				dao.getAccounts(user);
				return user;
			} else {
				throw new UserNameAlreadyExistsException("Username is already taken");
			}
		} else {
			throw new PasswordException("Passwords do not match - failed to create account");
		}

	}

	public static void listUsers() {
		BankDAOImp dao = new BankDAOImp();
		ArrayList<User> users = dao.getUsers();
		for (User u : users) {
			System.out.println(u);
		}
	}

	public static void tryDelete(String username) throws UserDoesntExistException {
		BankDAOImp dao = new BankDAOImp();
		if (dao.userExists(username)) {
			dao.deleteUser(username);
			System.out.println("\nSuccessfully deleted user " + username);
		} else {
			throw new UserDoesntExistException("No user exists by that name");
		}
	}

	public static void tryUpdate(String username, String newUsername, String newPassword)
			throws UserNameAlreadyExistsException, UserDoesntExistException {
		BankDAOImp dao = new BankDAOImp();
		if (dao.userExists(username)) {
			if (!dao.userExists(newUsername)) {
				dao.updateUser(username, newUsername, newPassword);
				System.out.println("\nSuccessfully updated user");
			} else {
				throw new UserNameAlreadyExistsException("Username already taken");
			}
		} else {
			throw new UserDoesntExistException("No user exists by that name");
		}
	}
}
