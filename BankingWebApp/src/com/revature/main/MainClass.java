package com.revature.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.AwesomeBankDaoImple;
import com.revature.domain.AwesomeBank;
import com.revature.domain.AwesomeBankUser;
import com.revature.util.ConnectionUtil;;

public class MainClass {
	
	

	public static void main(String[] args) throws SQLException {
		
		
		//Connection con = ConnectionUtil.getConnection();
		//System.out.println(con.toString());
		
		
		//dao.deleteAccount(2);
		
		//Scanner sc = new Scanner(System.in); 
		//dao.createAccount("Luis Nieves", 0);
		//dao.createUser("hubababa", "toast");
		//int userID = dao.retriveUserbyID("hubababa", "toast");
		//System.out.println(userID);
		//dao.createAccount("REFFUA", 32);
		//dao.viewAccount(userID);
					
		AwesomeBankDaoImple dao = new AwesomeBankDaoImple();
		AwesomeBankUser user = new AwesomeBankUser();
		
		
		//dao.deleteAccount(2);
		
		//Scanner sc = new Scanner(System.in); 
		//dao.createAccount("Luis Nieves", 0);
		//dao.createUser("hubababa", "toast");
		int userID = dao.retriveUserbyID("hubababa", "toast");
		//dao.updateBalance(41, 100);
		//dao.withdraw(5, 100);
		//System.out.println(userID);
		//dao.createAccount("REFFUA", 32);
		//dao.viewAccount(userID);
	}
	
	
	
}