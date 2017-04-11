package com.revature.main;
import java.sql.Connection;
import java.util.Scanner;
import java.util.scanner;

import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.BankAccount;
import com.revature.domain.User;
import com.revature.ui.UserInteraction;
import com.revature.util.ConnectionUtil;

public class Main {

	public static void main(String[] args) {
		BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
		UserDaoImpl userDao = new UserDaoImpl();
		
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			System.out.println(con.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String dataType = "";
		
		Scanner sc = new Scanner(System.in);
		while (!dataType.equals("LOGIN") && !dataType.equals("SIGNUP")){
			System.out.print("Type LOGIN or SIGNUP: ");
			dataType = sc.nextLine();
		}
		UserInteraction user = new UserInteraction(dataType);
		user.signinOrLogin();
		
		String action = "";
		while (!action.equals("LOGOUT")){
			System.out.println("Select action:\nWITHDRAW, DEPOSIT, CREATE ACCOUNT,\nSWITCH ACCOUNT, VIEW ACCOUNTS, LOGOUT");
			action = sc.nextLine();
			
			switch (action){
				case "WITHDRAW":
					user.handleWithdrawal();
					break;
				case "DEPOSIT":
					user.handleDeposite();
					break;
				case "CREATE ACCOUNT":
					user.makeBankAccount();
					break;
				case "VIEW ACCOUNTS":
					user.viewAccounts();
					break;
				case "SWITCH ACCOUNT":
					user.switchAccount();
					break;
				case "LOGOUT":
					break;
				case "DELETE":
					user.handleDelete();
					break;
				default:
					System.out.println("Please provide a valid command");
			}
		}
		
		System.out.println("Thank you for playing");
		
	}

}
