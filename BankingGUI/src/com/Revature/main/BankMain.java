package com.Revature.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.Revature.dao.BankAccountDAOimpl;
import com.Revature.dao.DeletingNonZeroAccountException;
import com.Revature.dao.IncorrectLoginException;
import com.Revature.dao.OverdraftException;
import com.Revature.dao.UserDAOimpl;
import com.Revature.domain.BankAccount;
import com.Revature.domain.User;
import com.Revature.util.ConnectionUtil;

public class BankMain {
	private static User user;
	private static UserDAOimpl userDAO;

	public static void main(String[] args) {
		System.out.println("*****WELCOME TO LOCAL BANK*****");
		boolean success = false;
		do {
			success = login();
		} while (!success);
		success = false;
		userPage();
	}
	public static void userPage(){
		int choice = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println(	"1) Create new bank account\n"
				+ 			"2) View bank accounts\n"
				+ 			"3) Update bank account name\n"
				+ 			"4) Delete bank account\n"
				+ 			"5) Deposit to account\n"
				+ 			"6) Withdraw from account\n"
				+ 			"7) Logout");
		if(user.isSuperPriv()==1){
			System.out.println("8) Super User settings\n");	//<--- TODO create super user functions
		}
		try{
			System.out.print("Input: ");
			choice = scan.nextInt();
		}catch(InputMismatchException e){
			System.out.println("Invalid entry");
			userPage();
		}
		switch(choice){
			case 1:	createAccountPage();
					break;
			case 2: accountPage(2);
					break;
			case 3: accountPage(3);
					break;
			case 4:	accountPage(4);
					break;
			case 5: accountPage(5);
					break;
			case 6: accountPage(6);
					break;
			case 7: System.out.println("\n*****LOGGED OUT*****\n");
					user = null;
					userDAO = null;
					Boolean success = false;
					do {
						success = login();
					} while (!success);
					break;
			case 8:	if(user.isSuperPriv()==1){
						superUserPage();
					}
					break;
		}
		userPage();
	}
	/*COMMENCE SPAGHETTI CODE*/
	public static void superUserPage(){
		System.out.println("\n*****SUPER USER PAGE*****\n");
		System.out.println(	"1) Create user\n"
				+ 			"2) View all users\n"
				+ 			"3) Delete user\n"
				+ 			"4) Update user\n");
		System.out.print("Input: ");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		switch(choice){
			case 1:	createUserPage(1);
					break;
			case 2:	adminPage(2);
					break;
			case 3: adminPage(3);
					break;
			case 4: adminPage(4);
					break;
		}
	}
	public static void adminPage(int choice){
		List<User> users = userDAO.retrieveAllUsers();
		System.out.println("\n*****RETRIEVED EXISTING USERS*****\n");
		System.out.println("UserID\t\t\tUserName\t\tPassword");
		System.out.println("---------\t\t-----------\t\t-------");
		for(User user: users){
			System.out.println(user.getUserID()+"\t\t\t"+user.getUsername()+"\t\t"+user.getPassword());
		}
		System.out.println();
		if(choice!=2){
			Scanner scan = new Scanner(System.in);
			System.out.println("Select user by UserID: ");
			int userID = scan.nextInt();
			switch(choice){
				case 3:	deleteUser(userID);
						break;
				case 4: updateUser(userID);
						break;
			}
		}
	}
	public static void deleteUser(int userID){
		UserDAOimpl userDAO = new UserDAOimpl();
		userDAO.deleteUser(userID);
		System.out.println("\n*****USER DELETED*****");
	}
	public static void updateUser(int userID){
		User user = userDAO.UserByID(userID);
		Scanner scan = new Scanner(System.in);
		System.out.println("Update user name: ");
		String username = scan.nextLine();
		System.out.println("Update user password: ");
		String pass = scan.nextLine();
		userDAO.updateUserName(user, username);
		userDAO.updateUserPass(user, pass);
		System.out.println("\n*****USER INFO UPDATED*****");
	}
	public static void createUserPage(int superUser){
		Scanner scan = new Scanner(System.in);
		System.out.println("New username: ");
		String username = scan.nextLine();
		System.out.println("New password: ");
		String password = scan.nextLine();
		if(superUser == 0){
			user = new User(username, password, 0);
		}
		userDAO.createUser(user);
		System.out.println("\n*****CREATED USER "+username+"*****\n");
	}
	public static void createAccountPage(){
		BankAccountDAOimpl accountDAO = new BankAccountDAOimpl();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter new account name: ");
		String acctName = scan.next();
		BankAccount acct = new BankAccount(user.getUserID(), acctName, 0);
		accountDAO.createAccount(acct);
		System.out.println("\n*****ACCOUNT "+acctName+" CREATED*****\n");
	}
	public static void accountPage(int action){
		List<BankAccount> accounts = userDAO.retrieveAccounts(user.getUserID());
		System.out.println("\n*****RETRIEVED EXISTING ACCOUNTS*****\n");
		System.out.println("AccountID\t\tAccountName\t\t\tBalance");
		System.out.println("---------\t\t-----------\t\t\t-------");
		for(BankAccount ba: accounts){
			System.out.println(ba.getAccountID()+"\t\t\t"+ba.getAccountName()+"\t\t\t$"+ba.getBalance());
		}
		System.out.println("\n");
		if(action!=2){
			Scanner scan = new Scanner(System.in);
			System.out.print("Select account by AccountID: ");
			int acctID = scan.nextInt();
			switch(action){
				case 3:	updateAccountPage(acctID);
						break;
				case 4:	deleteBankAccount(acctID);
						break;
				case 5: deposit(acctID);
						break;
				case 6:	withdraw(acctID);
						break;
			}
		}
	}
	public static void updateAccountPage(int acctID){
		BankAccountDAOimpl bankDAO = new BankAccountDAOimpl();
		BankAccount acct = bankDAO.retrieveAccountByID(acctID);
		Scanner scan = new Scanner(System.in);
		System.out.println("update account name: ");
		String newName = scan.next();
		bankDAO.updateAccount(acct, newName);
		System.out.println("\n*****UPDATED ACCOUNT NAME TO "+newName+"*****\n");
	}
	public static void deleteBankAccount(int acctID){
		BankAccountDAOimpl bankDAO = new BankAccountDAOimpl();
		try {
			bankDAO.deleteBankAccount(acctID);
			System.out.println("\n*****BANK ACCOUNT DELETED*****\n");
		} catch (DeletingNonZeroAccountException e) {
			System.out.println("\n*****WITHDRAW FUNDS BEFORE DELETING*****\n");
		}	
	}
	public static void deposit(int acctID){
		BankAccountDAOimpl bankDAO = new BankAccountDAOimpl();
		BankAccount acct = bankDAO.retrieveAccountByID(acctID);
		Scanner scan = new Scanner(System.in);
		System.out.println("Amount to deposit: ");
		double amt = scan.nextDouble();
		bankDAO.deposit(acct, amt);
		System.out.println("\n*****DEPOSITED $"+amt+" TO "+acct.getAccountName()+"*****");
	}
	public static void withdraw(int acctID){
		BankAccountDAOimpl bankDAO = new BankAccountDAOimpl();
		BankAccount acct = bankDAO.retrieveAccountByID(acctID);
		Scanner scan = new Scanner(System.in);
		System.out.println("Amount to withdraw: ");
		double amt = scan.nextDouble();
		try {
			bankDAO.withdraw(acct, amt);
			System.out.println("\n*****WITHDREW $"+amt+" FROM ACCOUNT "+acct.getAccountName()+"*****");
		} catch (OverdraftException e) {
			System.out.println("\n*****INSUFFICIENT FUNDS*****\n");
		}
	}
	public static boolean login() {
		Scanner scan = new Scanner(System.in);
		Boolean result = false;
		int choice = 0;
		userDAO = new UserDAOimpl();
		System.out.println("1) New User\n" + "2) Login\n");
		System.out.print("Input: ");
		try{
			choice = scan.nextInt();
		}catch(InputMismatchException e){
			System.out.println("Invalid entry");
			result = false;
		}
		if (choice == 1) {
			createUserPage(0);
			result = true;
		} else if (choice == 2) {
			System.out.println("Username: ");
			String username = scan.next();
			System.out.println("Password: ");
			String password = scan.next();
			try {
				user = userDAO.UserByLogin(username, password);
				System.out.println("\n*****LOGIN SUCCESSFUL*****\n");
				result = true;
			} catch (IncorrectLoginException e) {
				System.out.println("\n*****INCORRECT USERNAME/PASSWORD*****\n");
				result = false;
			}
		}
		return result;
	}
}