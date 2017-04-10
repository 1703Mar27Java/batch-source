package com.revature.BankApp;

import java.util.Scanner;

import com.revature.domain.*;

public class App {
	public static void main(String[] args) {
		Boolean running = true;
		Boolean loggedIn = false;
		Users currentUser = new Users();
		SuperUser superU = new SuperUser();
		String uName, uPass;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Welcome to Revature Banking!");
			System.out.println("Please select from the following options:");
			System.out.println("1) Log in\n2) Create New Account\n3) Exit");
			int choice = sc.nextInt();
			sc.nextLine();		
			System.out.println("\n\n");
			
			switch (choice) {
			case 1: 
				System.out.println("Enter User Name: ");
				uName = sc.nextLine();
				System.out.println("Enter Password: ");
				uPass = sc.nextLine();
				if (uName.equals("superuser")) {
					superU.setUSER_NAME(uName);;
				} else {
					currentUser = new Users(uName, uPass);
					currentUser.retrieveUser(); 
				}
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
				System.out.println("\n\n");
				System.out.println("Please select from the following options:");
				System.out.println("1) View Accounts\n2) Create Account\n3) Delete Account\n"
						+ "4) Deposit\n5) Withdraw\n6) Logout");
				if (superU.getUSER_NAME().equals("superuser")) {
					System.out.println("\nSuperUser options\n7) View All Users"
							+ "\n8) Create New User\n9) Update Any User Name\n"
							+ "10) Update Any User Password\n11) Delete Any User");
				}
				choice = sc.nextInt();
				sc.nextLine();
				String aName;
				
				System.out.println("\n\n");
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
					superU.setUSER_NAME("null");
					break;
				case 7:
					if (superU.getUSER_NAME().equals("superuser")) {
						superU.retrieveAccounts();
						System.out.println(currentUser.toString());
					}
					break;
				case 8:
					if (superU.getUSER_NAME().equals("superuser")) {
						System.out.println("Enter new User Name: ");
						uName = sc.nextLine();
						System.out.println("Enter new Password: ");
						uPass = sc.nextLine();
						superU.createNewUser(uName, uPass);
					}
					break;
				case 9:
					if (superU.getUSER_NAME().equals("superuser")) {
						System.out.println("Enter User Name: ");
						uName = sc.nextLine();
						System.out.println("Enter new User Name: ");
						String newName = sc.nextLine();
						superU.updateAnyName(uName, newName);
					}
					break;
				case 10:
					if (superU.getUSER_NAME().equals("superuser")) {
						System.out.println("Enter User Name: ");
						uName = sc.nextLine();
						System.out.println("Enter new Password: ");
						String newPass = sc.nextLine();
						superU.updateAnyPassword(uName, newPass);
					}
					break;
				case 11:
					if (superU.getUSER_NAME().equals("superuser")) {
						System.out.println("Enter User Name: ");
						uName = sc.nextLine();
						superU.deleteAny(uName);
					}
					break;
					default: break;
				}		
			}
			System.out.println("\n\n");
		} while (running);

		sc.close();
	}
}
