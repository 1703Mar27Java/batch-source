package com.pbjbank.main;

//import java.util.*;
import com.pbjbank.domain.*;
import com.pbjbank.dao.*;
//import java.sql.*;



public class Main {
	
	
	
	public static void main(String[] args){
		
		BankUserDAOImpl dao = new BankUserDAOImpl();
		//dao.createBankAccount(new BankAccount(1,1,"Checking Account",9.00));
		dao.createNewUserPS(new User_Logon(0,"ted","e34r"));
		//dao.createBankAccount(new BankAccount(3,2,"Pennes From Heaven",75));	
		
		
	}
	
	
	
/*	
public void userInput(){
	BankDAOImpl daoB = new BankDAOImpl();
	BankUserDAOImpl daoU = new BankUserDAOImpl();
	Scanner input = new Scanner(System.in);
	
	int opt;
	String u ;
	String p ;
	String ba;
		
	System.out.println("Welcome to the PB & J Bank!\nPlease make a selection from the following options: ");
	System.out.println("Existing Customers ---- Press 1 ");
	System.out.println("New Customers --------- Press 2 ");
	System.out.println("Exit System ----------- Press 3 ");
	opt= input.nextInt();		
	}
}*/
		
	}