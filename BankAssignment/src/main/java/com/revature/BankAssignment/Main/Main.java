package com.revature.BankAssignment.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.revature.BankAssignment.dao.BankDAOImpl;
import com.revature.BankAssignment.dao.SuperUser;
import com.revature.BankAssignment.dao.UserDAO;
import com.revature.BankAssignment.dao.UserDAOImpl;
import com.revature.BankAssignment.domain.User;
import com.revature.BankAssignment.exceptions.IncorrectPassword;
import com.revature.BankAssignment.util.ConnectionUtil;









public class Main {

	
	
	public static void DeleteAccount(User user){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the number of the account you wish to delete");
		int accountNumber=scanner.nextInt();
		
		UserDAOImpl userDAO=new UserDAOImpl();
		userDAO.DeleteAccount(user, accountNumber);
	}

	public static void Deposit(User user){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the number of the account you wish to deposit money into");
		int accountNumber= scanner.nextInt();
		System.out.println("Enter the amount to be deposited");
		double amount= scanner.nextDouble();
		
		UserDAOImpl userDAO=new UserDAOImpl();
		userDAO.Deposit(user, accountNumber, amount);
		
	}

	public static void Withdraw(User user){
		
	}
	
	public static void Login(){
		
		String username="";
		String password="";
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please enter a username");
		username=scanner.next();
		System.out.println("Please enter a password");
		password=scanner.next();
	
		
		User user=new User(username,password);
		UserDAOImpl userDAO=new UserDAOImpl();
		
		try {
			userDAO.Login(user);
		
		
		
		boolean loop=true;
		
		while(loop){
			
			System.out.println("Welcome Back Please Select an option ");
			System.out.println("1: View Accounts and Balances");
			System.out.println("2: Create an Account");
			System.out.println("3: Delete an empty account");
			System.out.println("4: Make a deposit");
			System.out.println("5: Make a withdrawl");
			System.out.println("6: Logout");
			switch(scanner.nextInt()){
			case 1: userDAO.ViewAllAccounts(user);break;
			case 2: userDAO.CreateNewAccount(user); break;
			case 3: DeleteAccount(user);break;
			case 4: Deposit(user);break;
			case 5: Withdraw(user);break;
			case 6: loop=false;Logout();break;
			default: System.out.println("Invalid input please enter again"); continue;
			
			}
		}
		
		} catch (IncorrectPassword e) {
			
			e.printStackTrace();
		}
	}
	
	public static void Register(){
		
		String username="";
		String password="";
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Please enter a username");
		username=scanner.next();
		System.out.println("Please enter a password");
		password=scanner.next();
			
			
			User user=new User(username,password);
			UserDAOImpl userDAO=new UserDAOImpl();
			userDAO.CreateUser(user);
			
		
		
		
				
	}
	
	public static void Logout(){
		
	}
	
	public static void LoginAsSuperuser(){
		
		
		try {
			SuperUser.login();
			
			
			Scanner scanner=new Scanner(System.in);
			
			System.out.println("Welcome SuperUser please select an option");
			
			boolean loop=true;
			
			while(loop){
				System.out.println("1: View all users");
				System.out.println("2: Create a user");
				System.out.println("3: Update a user");
				System.out.println("4: Delete a user");
				System.out.println("5: Logout");
				switch(scanner.nextInt()){
				case 1:SuperUser.ViewAll();break;
				case 2:SuperUser.Create();break;
				case 3: SuperUser.Update();break;
				case 4: SuperUser.Delete();break;
				case 5: loop=false;break;
				default: System.out.println("Invalid input please enter again");
				}
			}
			
			
		} catch (IncorrectPassword e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
/*		try {
			Connection con=ConnectionUtil.getConnection();
			System.out.println(con.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*Properties prop=new Properties();
		
		try {
			
			FileOutputStream output = new FileOutputStream("config.properties");
			prop.setProperty("SuperUserName", "SuperUser");
			prop.setProperty("SuperUserPassword", "SuperUser");
			prop.setProperty("DataBaseConnectionUserName", "BankAssignment");
			prop.setProperty("DataBaseConnectionPassword", "BankAssignment");
			prop.setProperty("DataBaseConnectionUrl", "jdbc:oracle:thin:@localhost:1521:xe");
			prop.store(output,null);
			output.close();
			InputStream input=new FileInputStream("config.properties");
			prop.load(input);
			System.out.println(prop.getProperty("SuperUserName"));
			input.close();
			//System.out.println(prop.getProperty("SuperUserName"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		while(true){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Welcome to Ben's Bank Please Select an option");
		System.out.println("1: Login");
		System.out.println("2: Register as a new user");
		System.out.println("3: Login as a Superuser");
		System.out.println("4: Exit the program");
		switch(scanner.nextInt()){
		case 1: Login();break;
		case 2: Register(); break;
		case 3: LoginAsSuperuser();break;
		case 4: System.exit(0);break;
		default: System.out.println("Invalid input please enter again"); continue;
		
		}
		}
		

	}

}
