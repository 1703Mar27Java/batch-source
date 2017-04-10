package com.revature.mainbank;

import java.sql.*;

import com.revature.bankdao.BankDaoImplementation;
import com.revature.butil.ConnectionBankUtil;
import com.revature.domain.Bank;


public class BankMain {

	public static void main(String[] args) throws SQLException {
		Bank b = new Bank("Jay", "Sean");
		BankDaoImplementation bao = new BankDaoImplementation();
		bao.createUser(b);
		
		//Connection con = ConnectionBankUtil.getConnection();
		//System.out.println(con.toString());
		System.out.println("***********************");
		System.out.println("**Welcome to the Bank**");
		System.out.println("***********************");
		
		
		displayMenu();

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