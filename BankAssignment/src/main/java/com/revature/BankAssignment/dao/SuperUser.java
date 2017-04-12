package com.revature.BankAssignment.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.revature.BankAssignment.domain.User;
import com.revature.BankAssignment.exceptions.IncorrectPassword;
import com.revature.BankAssignment.util.ConnectionUtil;

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
		
		
		if(!(prop.getProperty("SuperUserName").equals(Superusername) && prop.getProperty("SuperUserPassword").equals(Superuserpassword))){
		throw new IncorrectPassword();	
		}
	}
	
	public static void ViewAll(){
Connection con;
		
		String sql="SELECT * FROM USERS";
	
		
		try {
			con = ConnectionUtil.getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql);
			
			
			
ResultSet result=pstmt.executeQuery();
			
while(result.next()){
	System.out.println("USER_ID"+" "+"USER_NAME"+"USER_PASSWORD");
	System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3));
}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the id of the account you wish to delete");
		int id=scanner.nextInt();
		
		String sql="DELETE FROM BANK_ACCOUNT WHERE  USER_ID=?";
		String sql2="DELETE FROM USERS WHERE USER_ID=?";
		try {
			Connection con=ConnectionUtil.getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			pstmt=con.prepareStatement(sql2);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
			System.out.println("User number"+id+"has been deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
