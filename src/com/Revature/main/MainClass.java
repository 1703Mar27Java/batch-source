package com.Revature.main;

import java.util.Scanner;

import com.Revature.dao.UserDAOImpl;
import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
		String adminName = null, name, pass, validUser = "";
		UserDAOImpl uDAO = new UserDAOImpl();
		boolean admin = false;

		// get admin info
		try {
			FileReader fr;
			fr = new FileReader("src/properties");
			BufferedReader br = new BufferedReader(fr);
			br.readLine();
			adminName = br.readLine();
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int n = 1;
		Scanner sc = new Scanner(in);
		// user validation phase
		out.println("Welcome to the Banky Bank Banking app of Bankyness"
				+ "\nWould you like to:\n1: Log in. \n2: Make a new user account.");
		n = sc.nextInt();
		sc.nextLine();

		if (n == 1)
			// log in
			while (validUser == "") {

				out.println("Username: ");
				name = sc.nextLine();
				out.println("Password: ");
				pass = sc.nextLine();
				validUser = uDAO.logIn(name, pass);
				if (validUser == "")
					out.println("Username/Password combination was wrong; Please try again.");
			}

		else
			// create new user
			while (validUser == "") {

				out.println("Username: ");
				name = sc.nextLine();
				out.println("Password: ");
				pass = sc.nextLine();
				validUser = uDAO.createUser(name, pass);
				if (validUser == "")
					out.println("Username exists; Please try again with a new username.");
			}
		// if the entered user is the admin acct, we enable admin features
		if (validUser.equals(adminName))
			admin = true;
		// loop through menu until we quit
		while (n != 0) {
			if (admin)
				out.println("Admin features enabled.");
			menu();
			n = sc.nextInt();
			sc.nextLine();
			switch (n) {
			// CASE CREATE ACCOUNT
			case 1:
				if (admin) {
					out.println("Enter username to modify: ");
					validUser = sc.nextLine();
				}
				out.println("Enter name for the account");
				String str = sc.nextLine();
				out.println("Enter money to deposit to this account");
				double in = sc.nextDouble();
				sc.nextLine();
				uDAO.createAcct(validUser, str, in);
				break;
			// CASE DELETE ACCOUNT
			case 2:
				if (admin) {
					out.println("Enter username to modify: ");
					validUser = sc.nextLine();
				}
				out.println("Enter the account id to delete");
				int x = sc.nextInt();
				sc.nextLine();
				uDAO.deleteAcct(x);
				break;
			// CASE ADD FUNDS
			case 3:
				if (admin) {
					out.println("Enter username to modify: ");
					validUser = sc.nextLine();
				}
				out.println("Enter account number: ");
				int bid = sc.nextInt();
				sc.nextLine();
				out.println("Enter money to deposit: ");
				in = sc.nextDouble();
				sc.nextLine();
				uDAO.addFunds(bid, in);
				break;
			// CASE REMOVE FUNDS
			case 4:
				if (admin) {
					out.println("Enter username to modify: ");
					validUser = sc.nextLine();
				}
				out.println("Enter account number: ");
				bid = sc.nextInt();
				sc.nextLine();
				out.println("Enter money to remove: ");
				in = sc.nextDouble();
				sc.nextLine();
				uDAO.subFunds(bid, in);
				break;
			// CASE VIEW ACCOUNTS
			case 5:
				if (admin)
					uDAO.fetchAdmin();
				else
					uDAO.fetchAccts(validUser);
				break;
			// CASE VIEW TRANSACTION HISTORY
			case 6:
				if (admin)
					uDAO.fetchTransAdmin();
				else
					uDAO.fetchTrans(validUser);
			case 0:
				break;
			default:
				out.println("Invalid entry, please try again.");
			}
		}
		out.printf("Thanks, now quitting");
		sc.close();

	}

	public static void menu() {
		out.println("Please choose an option from below:");
		out.println("1: Create an account.");
		out.println("2: Delete an account (balance MUST be 0).");
		out.println("3: Add funds to an account.");
		out.println("4: Remove funds from an account.");
		out.println("5: View all of your accounts.");
		out.println("6: View all of your transactions.");
		out.println("0: Logout. ");

	}

}
