package com.revature.main;

import java.util.*;
import com.revature.dao.BankDAOImpl;
import com.revature.domain.BankAccount;
import com.revature.domain.BankUser;

public class TestMain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BankDAOImpl dao = new BankDAOImpl();
		BankUser user = new BankUser();
		
		//user = dao.retrieveUserById(11);
		//System.out.println(user.getFirstName() + " " + user.getUserID() + " " + user.getLastName() + " " + user.getUserName() + " " + user.getUserPassword());
		//System.out.println(user.toString());
		/*
		List<BankUser> userList = new ArrayList<BankUser>();
		userList = dao.retrieveAllUsers();
		System.out.println();
		user = userList.get(0);
		System.out.println(user.toString());
		*/
		//BankAccount account = new BankAccount();
		//account.setBalance(1000.00);
		//account.setUserID(11);
		//dao.createAccount(account);
		in.close();
		//dao.retrieveUserById(11);
		//dao.retrieveUserByUserName("Bobby");
		//ArrayList<BankAccount> acct = (ArrayList)dao.viewAccounts(50);
		//System.out.println(acct.get(0).toString());
		//BankAccount account = new BankAccount();
		//account = dao.
		//dao.deposit(account, 1000);
	}

}
