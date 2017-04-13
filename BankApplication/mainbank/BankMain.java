package com.revature.mainbank;

import java.sql.*;
import java.util.Scanner;

import com.revature.bankdao.BankDaoImplementation;
import com.revature.butil.ConnectionBankUtil;
import com.revature.domain.Bank;
import com.revature.bankdao.AccountDAOImpl;
import com.revature.domain.Account;


public class BankMain {
private static Bank user;
	public static void main(String[] args) throws SQLException {
		
		//Connection con = ConnectionBankUtil.getConnection();
		//System.out.println(con.toString());
		Scanner scan = new Scanner(System.in);
		boolean finish = false;
		String username, password, account = "";
		double amount;
		
		BankDaoImplementation bao =  new BankDaoImplementation();
		AccountDAOImpl lao = new AccountDAOImpl();
		
		System.out.println("***********************");
		System.out.println("**Welcome to the Bank**");
		System.out.println("***********************");
		
		displayMenu();
		
	while(!finish){	
	switch(scan.next()){
	case "1": 
		System.out.println("Please enter a valid username: ");
		username = scan.next();
		System.out.println("Please enter a valid password: ");
		password = scan.next();
		System.out.println("Please enter name of your account: ");
		account = scan.next();
		Bank banker = new Bank(username,password);
		bao.createUser(banker);
		System.out.println("Username and Password has been successfully created!");
		int id = bao.logIn(username, password).getId();
		Account acct = new Account(account,0,id);
		lao.createAccount(acct);
		System.out.println("Account completed! "+acct.getId());
		break;
		
		
	case "2":
		System.out.println("Enter your username: ");
		username = scan.next();
		System.out.println("Enter your password: ");
		password = scan.next();
		bao.logIn(username, password);
		System.out.println("Welcome Back!");
		break;
		
	case "3":
		System.out.println("Please enter deposit amount: ");
		amount = scan.nextDouble();
		//lao.Deposit(id, money);
		break;
		
	case "4":
		System.out.println("Please enter withdrawal amount: ");
		amount = scan.nextDouble();
		//lao.Withdraw(id, money);
		break;
		
	case "5":
	/*	AccountDAOImpl blao = new AccountDAOImpl();
		Account account = user.getAccount(accountName);
				dao.deleteAccount(user, account);
				System.out.println("Account was deleted");*/
		
	case "6":
		finish = true;
		System.out.println("Thanks for using the app");
		break;
	}

	}
	}
	public static void displayMenu(){
		System.out.println("Choose between the following menu options:");
		System.out.println("1: Create an account");
		System.out.println("2: Log in to your account");
		System.out.println("3: Deposit money ");
		System.out.println("4: Withdraw funds ");
		System.out.println("5: Delete account");
		System.out.println("6: Log off ");
	}

}