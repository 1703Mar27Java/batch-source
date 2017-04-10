package com.revature.BankAssignment.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import com.revature.BankAssignment.domain.User;
import com.revature.BankAssignment.exceptions.IncorrectPassword;

public class SuperUser {

	
	
	public static void login() throws IncorrectPassword{
Properties prop = new Properties();
		
		FileInputStream input = null;
		try {
			input=new FileInputStream("config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String Superusername="";
		String Superuserpassword="";
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Please enter the username for the superuser");
		Superusername=scanner.next();
		System.out.println("Please enter the password for the superuser");
		Superuserpassword=scanner.next();
		
		
		if(!(prop.getProperty("SuperUserName")==Superusername && prop.getProperty("SuperUserPassword")==Superuserpassword)){
		throw new IncorrectPassword();	
		}
	}
	
	public static void ViewAll(){
		
	}
	
	public static void Create(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a username for the new user");
		String username=scanner.next();
		System.out.println("Enter a password for the new user");
		String password=scanner.next();
		
		UserDAOImpl UserDAO=new UserDAOImpl();
		UserDAO.CreateUser(new User(username,password));
	}
	public static void Update(){
		
	}
	
	public static void Delete(){
		
	}
	
}
