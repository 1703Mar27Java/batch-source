package com.revature.Main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.Dao.BankDaoImpl;
import com.revature.Dao.UserDaoImpl;
import com.revature.Domain.Bank;
import com.revature.Domain.User;

public class Main {

	public static void main(String[] args) {
		

		System.out.println("Welcome to Revature Banking App(tm)");
		System.out.println("Would you like to...");
		System.out.println("1: Login into an Existing Account");
		System.out.println("2: Create a new Account");
		System.out.println("3: Exit Application");

		Scanner scanner = new Scanner(System.in);
		int choice = 0;

		try {
			choice = scanner.nextInt();
		} catch (InputMismatchException e) {
			// e.printStackTrace();
		}

		switch (choice) {
		case 1:
			System.out.println("User: ");
			String usL = scanner.next();
			System.out.println("Password: ");
			String paL = scanner.next();
			System.out.println("Logging in....");

			User userL = new User(usL, paL, false);
			UserDaoImpl udaoL = new UserDaoImpl();
			//udaoL.Display();

			udaoL.loginUser(userL);
			onceLoggedIn(userL);
			break;
		case 2:
			System.out.println("Creating user");
			System.out.println("User: ");
			String us = scanner.next();
			System.out.println("Password: ");
			String pa = scanner.next();

			User user = new User(us, pa, false);
			UserDaoImpl udao = new UserDaoImpl();

			//udao.Display();
			
			udao.createUser(user);
			udao.loginUser(user);
			onceLoggedIn(user);
			break;
		case 3:
			System.out.println("Thanks for using our App, we hope to see you again soon!");
			System.exit(0);
		default:
			System.out.println("Invalid Input");
			Main.main(null);
		}

		scanner.close();
	}

	public static void onceLoggedIn(User user) {
		System.out.println("\n\nWelcome " + user.userName);
		System.out.println("Would you like to...");
		System.out.println("1: Added a new Account");
		System.out.println("2: View Existing Bank Accounts and Balances");
		System.out.println("3: Withdrawl from an Account");
		System.out.println("4: Deposit to an Account");
		System.out.println("5: Delete an Account");
		System.out.println("6: Log Off");

		if (user.getSuperUser()) {
			System.out.println("7: SuperUser - View All Users");
			System.out.println("8: SuperUser - Create User");
			System.out.println("9: SuperUser - Update User");
			System.out.println("10: SuperUser - Delete all Users");
			
			try {
				FileWriter fw = new FileWriter("connection.properties",true);
				fw.append("\nSuperUser Username: " + user.getUserName() + "SuperUser Password: "+ user.getPassword());
				
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		int choice = 0;
		Scanner scanner = new Scanner(System.in);
		try {
			choice = scanner.nextInt();
		} catch (Exception e) {
			choice = 6;
		}

		UserDaoImpl uDao = new UserDaoImpl();
		BankDaoImpl bDao = new BankDaoImpl();
		Bank bank = new Bank(user.getUserID(), 0, " ");

		switch (choice) {
		case 1:
			System.out.println("Creating Bank Account");
			System.out.println("Account Name:");
			String bName = scanner.next();
			System.out.println("Starting Balance:");
			float bBalance = scanner.nextFloat();

			bank = new Bank(user.getUserID(), bBalance, bName);
			bDao.creatBankAccount(bank, user);
			break;
		case 2:
			System.out.println("Viewing Existing Accounts");
			bDao.retrieveBankAccounts(bank, user);
			onceLoggedIn(user);
			break;
		case 3:
			System.out.println("Viewing Existing Accounts");
			bDao.withdralBankAccount(bank, user);
			break;
		case 4:
			System.out.println("Viewing Existing Accounts");
			bDao.depositBankAccount(bank, user);
			break;
		case 5:
			bDao.deleteBankAccount(bank, user);
			break;
		case 6:
			
			uDao.logOut();
			break;
		case 7:
			if (user.getSuperUser()) {
				uDao.retrieveAll();
			}
			onceLoggedIn(user);
			break;
		case 8:
			if (user.getSuperUser()) {
				System.out.println("Creating user");
				System.out.println("User: ");
				String us = scanner.next();
				System.out.println("Password: ");
				String pa = scanner.next();

				User userC = new User(us, pa, false);

				uDao.createUser(userC);
				onceLoggedIn(user);
			}
			break;
		case 9:
			if (user.getSuperUser()) {
				uDao.uppdateUser(user);
			}
			onceLoggedIn(user);
			break;
		case 10: {
			if (user.getSuperUser()) {
				uDao.deleteAll();
			}
			onceLoggedIn(user);
		}
			break;
		default:
			System.out.println("\nInvalid Input\n");
			onceLoggedIn(user);
		}

		scanner.close();
	}
}
