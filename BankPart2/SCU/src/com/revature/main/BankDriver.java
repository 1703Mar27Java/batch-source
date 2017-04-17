package com.revature.main;

import java.util.Scanner;

import com.revature.bankExceptions.AccountAlreadyExistsException;
import com.revature.bankExceptions.AccountDoesntExistsException;
import com.revature.bankExceptions.BankBalanceException;
import com.revature.bankExceptions.PasswordException;
import com.revature.bankExceptions.UserDoesntExistException;
import com.revature.bankExceptions.UserNameAlreadyExistsException;
import com.revature.dao.BankDAOImp;
import com.revature.domain.User;
import com.revature.util.AccountUtil;
import com.revature.util.UserUtil;

public class BankDriver {
	static String s1;

	public static void main(String[] args) {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n" + "$$$ Welcome to the Dank Bank terminal $$$\n"
				+ "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		loginPrompt();
	}

	public static void loginPrompt() {
		boolean done = false;
		User user = null;
		String username;
		String password;

		while (!done) {
			System.out.print(
					"\n[1] - login as an existing user\n" + "[2] - create a new bank account\n" + "[3] - exit\n\n>");
			Scanner in = new Scanner(System.in);
			switch (in.next()) {
			case "1":
				System.out.print("username: ");
				username = in.next();
				System.out.print("password: ");
				password = in.next();
				try {
					user = UserUtil.tryLogin(username, password);
				} catch (PasswordException e) {
					System.out.println("\n" + e.getMessage());
				}
				if (user != null) {
					userLoop(user, in);
				}
				break;

			case "2":
				System.out.print("Choose a username: ");
				username = in.next();
				System.out.print("Choose a password: ");
				password = in.next();
				System.out.print("Confirm password: ");
				String confirm = in.next();
				try {
					user = UserUtil.tryCreate(username, password, confirm);
				} catch (UserNameAlreadyExistsException | PasswordException e) {
					System.out.println("\n" + e.getMessage());
				}
				if (user != null) {
					userLoop(user, in);
					user = null;
				}
				break;

			case "3":
				System.out.println("\nThank you for using the Bank terminal. Have a nice day! (^_^)");
				done = true;

				break;

			case "admin":
				System.out.print("\nadmin password: ");
				password = in.next();
				try {
					user = UserUtil.trySuper(password);
				} catch (PasswordException e) {
					System.out.println("\n" + e.getMessage());
				}
				if (user != null) {
					superLoop(user, in);
					user = null;
				}

				break;

			default:
				System.out.println("\nPlease select one of the displayed options\n");
				break;
			}
		}
	}

	public static void userLoop(User user, Scanner in) {
		String accountName;
		boolean done = false;
		BankDAOImp dao = new BankDAOImp();

		dao.getAccounts(user);

		System.out.println("\nWelcome " + user.getUsername());

		while (!done) {
			System.out.print("\n[1] - view accounts and balances\n" + "[2] - create an account\n"
					+ "[3] - delete an account\n" + "[4] - deposit\n" + "[5] - withdraw\n"
					+ "[6] - view transaction history\n" + "[7] - logout\n\n>");

			switch (in.next()) {
			case "1":
				AccountUtil.listAccounts(user);
				break;

			case "2":
				System.out.print("\nName your new account: ");
				accountName = in.next();
				try {
					AccountUtil.tryCreate(user, accountName);
				} catch (AccountAlreadyExistsException e) {
					System.out.println("\n" + e.getMessage());
				}

				break;

			case "3":
				System.out.print("\nName the account you wish to delete: ");
				accountName = in.next();
				try {
					AccountUtil.tryDelete(user, accountName);
				} catch (AccountDoesntExistsException | BankBalanceException e) {
					System.out.println("\n" + e.getMessage());
				}

				break;

			case "4":
				System.out.print("\nName the account you wish to deposit to: ");
				accountName = in.next();
				System.out.print("\nHow much would you like to deposit: $");
				int deposit = in.nextInt();
				try {
					AccountUtil.deposit(user, accountName, deposit);
				} catch (AccountDoesntExistsException e) {
					System.out.println("\n" + e.getMessage());
				}

				break;

			case "5":
				System.out.print("\nName the account you wish to withdraw from: ");
				accountName = in.next();
				System.out.print("\nHow much would you like to withdraw: $");
				int withdraw = in.nextInt();
				try {
					AccountUtil.withdraw(user, accountName, withdraw);
				} catch (AccountDoesntExistsException | BankBalanceException e) {
					System.out.println("\n" + e.getMessage());
				}

				break;

			case "6":
				AccountUtil.listTransactions(user);
				break;

			case "7":
				done = true;
				System.out.println("Successfully logged out");
				break;

			default:
				System.out.println("\nPlease select one of the displayed options\n");
				break;

			}
		}
	}

	public static void superLoop(User user, Scanner in) {
		boolean done = false;
		String username;

		System.out.println("\nWelcome " + user.getUsername());

		while (!done) {
			System.out.print("\n[1] - view all users\n" + "[2] - create a user\n" + "[3] - update a user\n"
					+ "[4] - delete a user" + "\n[5] - logout\n\n>");

			switch (in.next()) {
			case "1":
				UserUtil.listUsers();
				break;

			case "2":
				System.out.print("Choose a username: ");
				username = in.next();
				System.out.print("Choose a password: ");
				String password = in.next();
				System.out.print("Confirm password: ");
				String confirm = in.next();
				try {
					user = UserUtil.tryCreate(username, password, confirm);
				} catch (UserNameAlreadyExistsException | PasswordException e) {
					System.out.println("\n" + e.getMessage());
				}

				break;

			case "3":
				System.out.print("\nName the id of the user you wish to update: ");
				username = in.next();
				System.out.print("\nSet new username: ");
				String newUsername = in.next();
				System.out.print("Set new password: ");
				String newPassword = in.next();

				try {
					UserUtil.tryUpdate(username, newUsername, newPassword);
				} catch (UserDoesntExistException | UserNameAlreadyExistsException e) {
					System.out.println("\n" + e.getMessage());
				}

				break;

			case "4":
				System.out.print("\nName the id of the user you wish to delete: ");
				username = in.next();
				try {
					UserUtil.tryDelete(username);
				} catch (UserDoesntExistException e) {
					System.out.println("\n" + e.getMessage());
				}
				break;

			case "5":
				done = true;
				System.out.println("Successfully logged out");
				break;

			default:
				System.out.println("\nPlease select one of the displayed options\n");
				break;

			}
		}
	}
}
