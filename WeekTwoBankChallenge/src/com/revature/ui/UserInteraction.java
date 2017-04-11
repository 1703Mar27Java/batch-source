package com.revature.ui;

import java.util.Scanner;

import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.BankAccount;
import com.revature.domain.User;

public class UserInteraction {
	private User user;
	private String userType;
	private String userName;
	private String password;
	
	private BankAccount bankAccount;
	private String accountName;
	
	private UserDaoImpl userDao;
	private BankAccountDaoImpl bankDao;
	private Scanner sc;
	
	public UserInteraction(){
		
	}
	
	public UserInteraction(String userType){
		userDao = new UserDaoImpl();
		bankDao = new BankAccountDaoImpl();
		this.userType = userType;
		userName = "";
		password = "";
		user = null;
		bankAccount = null;
		
	sc = new Scanner(System.in);
	}
	
	public void signinOrLogin(){
		if (userType.equals("LOGIN")){
			handleLogin();
		}
		else{
			handleSignup();
		}
	}
	
	public void handleLogin(){
		//Scanner sc = new Scanner(System.in);
		String tryAgain = "";
		Boolean loginSuccessful = false;
		while (true){
			System.out.print("Username: ");
			userName = sc.nextLine();
			
			System.out.print("Password: ");
			password = sc.nextLine();
			
			user = userDao.retrieveUserByLoginInfo(userName, password);
			System.out.println(user);
			
			//if no value returned
			if (user == null){
				System.out.print("No such user was found. Try again?(Y/N):");
				tryAgain = sc.nextLine();
				
				if (tryAgain.equals("N")){
					break;
				}
			}
			else{
				loginSuccessful = true;
				break;
			}
		}
		
		if (loginSuccessful){
			System.out.println("Welcome, " + user.getUserName());
			
			//get account by userID
			retrieveBankAccount();
			
		}
	}
	
	public void handleSignup(){
		//Scanner sc = new Scanner(System.in);
		while (userName.equals("")){
			System.out.print("Create your userName: ");
			userName = sc.nextLine();
		}
		while (password.equals("") && password.length() != 6){
			System.out.print("Create your password (6 characters): ");
			password = sc.nextLine();
		}
		user = new User(userName, password);
		userDao.createUser(user);
		
		if (user != null){
			makeBankAccount();
		}
	}
	
	public void retrieveBankAccount(){
		int userID = userDao.retrieveUserByLoginInfo(userName, password).getUserID();
		bankAccount = bankDao.retrieveAccountById(userID);
		System.out.println(bankAccount);
	}
	
	public void makeBankAccount(){
		
		//bankDao = new BankAccountDaoImpl();
		
		int userID = userDao.retrieveUserByLoginInfo(userName, password).getUserID();
		
		//Scanner sc = new Scanner(System.in);
		System.out.println("Create your account, " + userID);
		System.out.print("Account name: ");
		accountName = sc.nextLine();
		
		bankAccount = new BankAccount(accountName, 0, userID);
		
		bankDao.createAccount(bankAccount);
		System.out.print(bankAccount.getBank_account_id());
		//update
		bankAccount = bankDao.retrieveAccountByAcctId(userID);
	}
	
	public void handleDeposite(){
		double depAmt = 0;
		sc = new Scanner(System.in);
		System.out.print("Deposit amount: ");
		depAmt = sc.nextDouble();

		bankDao.updateAccount(bankAccount, "DEPOSIT", depAmt);
		
		System.out.println("Deposit made");
		System.out.println("Account update:");
		//update bank account
		bankAccount = bankDao.retrieveAccountByAcctId(bankAccount.getBank_account_id());
		System.out.println(bankAccount);
	}
	
	public void handleWithdrawal(){
		double withAmt = 0;
		//sc = new Scanner(System.in);
		System.out.print("Withdrawal amount: ");
		withAmt = sc.nextDouble();

		bankDao.updateAccount(bankAccount, "WITHDRAW", withAmt);
		
		System.out.println("Withdrawal made");
		System.out.println("Account update:");
		//update bank account
		bankAccount = bankDao.retrieveAccountByAcctId(bankAccount.getBank_account_id());
		System.out.println(bankAccount);
	}
	
	public void viewAccounts(){
		System.out.println(bankDao.retrieveAllAccount());
	}
	
	public void seeCurrentBalance(){
		
	}
	
	public void switchAccount(){
		
	}
}
