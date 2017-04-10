package com.revature.main;

import java.util.Scanner;

import com.revature.domain.*;

public class Main {

	public static void main(String[] args) {
		Boolean running = true;
		Boolean loggedIn = false;
		Users currentUser = new Users();
		String uName, uPass;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Welcome to Revature Banking!");
			System.out.println("Please select from the following options:");
			System.out.println("1) Log in\n2) Create New Account\n3) Exit");
			int choice = sc.nextInt();
			sc.nextLine();			
			
			switch (choice) {
			case 1: 
				System.out.println("Enter User Name: ");
				uName = sc.nextLine();
				System.out.println("Enter Password: ");
				uPass = sc.nextLine();
				currentUser = new Users(uName, uPass);
				currentUser.retrieveUser(); 
				loggedIn = true;
				break;
			case 2: 
				System.out.println("Enter User Name: ");
				uName = sc.nextLine();
				System.out.println("Enter Password: ");
				uPass = sc.nextLine();
				currentUser = new Users(uName, uPass);
				currentUser.retrieveUser();
				currentUser.createNewUser(); 
				loggedIn = true;
				break;
			case 3: 
				running = false; 
				break;
				default: break;
			}

			while (loggedIn) {
				System.out.println("Please select from the following options:");
				System.out.println("1) View Accounts\n2) Create Account\n3) Delete Account\n"
						+ "4) Deposit\n5) Withdraw\n6) Logout");
				choice = sc.nextInt();
				sc.nextLine();
				String aName;
				switch (choice) {
				case 1: currentUser.viewAccounts(); break;
				case 2: 
					System.out.println("Enter Account Name: ");
					aName = sc.nextLine();
					currentUser.createAccount(aName);
					break;
				case 3: 
					System.out.println("Enter Account Name: ");
					aName = sc.nextLine();
					currentUser.deleteAccount(aName);
					break;
				case 4: 
					System.out.println("Enter Account Name: ");
					aName = sc.nextLine();
					System.out.println("Deposit: \n$");
					int deposit = sc.nextInt();
					sc.nextLine();
					currentUser.depositAccount(aName, deposit);
					break;
				case 5: 
					System.out.println("Enter Account Name: ");
					aName = sc.nextLine();
					System.out.println("Withdraw: \n$");
					int withdraw = sc.nextInt();
					sc.nextLine();
					currentUser.withdrawAccount(aName, withdraw);
					break;
				case 6: 
					System.out.println("You have been logged out.");
					loggedIn = false; 
					break;
					default: break;
				}		
			}
		} while (running);

		sc.close();
	}
}