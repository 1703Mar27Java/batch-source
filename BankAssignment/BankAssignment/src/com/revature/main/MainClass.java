package com.revature.main;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Scanner;
import com.revature.dao.BankDAOImpl;
import com.revature.domain.BankAccount;
import com.revature.domain.BankUser;

public class MainClass 
{

	public static void main(String[] args)
	{
		String userInput; //used for all user input after user name and pw
		BankUser loggedIn = new BankUser();
		BankUser credCheck = new BankUser(); //used to check username and password against user input
		boolean logOut = false;
		boolean newUser = true;// used for registering new user.  Set to false after user successfully logs in
		Scanner in = new Scanner(System.in);
		Boolean isMaster = false;
		String filename = "connection.properties";
		Properties prop = new Properties();
		BankDAOImpl dao = new BankDAOImpl();

		while (newUser)
		{
			System.out.println("Welcome to the bank.  Please select from the following.");
			System.out.println("1.Login existing user.");
			System.out.println("2.Register a new user.");
			userInput = in.nextLine();

			switch(userInput)
			{
			case "1":  //user login case
				
				System.out.println("Please enter your username and password.");
				System.out.print("username: ");
				loggedIn.setUserName(in.nextLine());
				System.out.print("password: ");
				loggedIn.setUserPassword(in.nextLine());
				System.out.println();
				credCheck = dao.retrieveUserByUserName(loggedIn.getUserName());
				
				if(credCheck.getUserID() == 0)
				{
					System.out.println("User doesn't exist.");
					break;
				}
				else if(credCheck.getUserPassword().equals(loggedIn.getUserPassword()))
				{
					loggedIn = credCheck;
				}
				else
				{
					System.out.println("Incorrect credentials.\n");
					break;
				}
				
				
				
				//check if user is the super user
				try (InputStream is = new FileInputStream(filename))
				{
					prop.load(is);
					if(loggedIn.getUserName().equals(prop.getProperty("mUsername"))  && loggedIn.getUserPassword().equals(prop.getProperty("mPassword")))
					{
						isMaster = true;
					}
				} 
				
				catch (FileNotFoundException e1) 
				{
					e1.printStackTrace();
				} 
				
				catch (IOException e) 
				{
					e.printStackTrace();
				}

				
				//if user is super user
				if(isMaster)
				{
					
					while(!logOut)
					{
						System.out.println("Welcome Super User.  Please choose from the following:");
						System.out.println("1. View all users");
						System.out.println("2. Create a user");
						System.out.println("3. Delete a user");
						System.out.println("4. Update a user");
						System.out.println("5. View a user");
						System.out.println("6. Log out");
						System.out.println();
					
						userInput = in.nextLine();
						
						switch(userInput)
						{
							case "1":
								dao.retrieveAllUsers();
								break;
								
							case "2":
								BankUser newBankUser = new BankUser();
								System.out.print("Enter the new user's username: ");
								 newBankUser.setUserName(in.nextLine());
								 
								 System.out.print("Enter the new user's password: ");
								 newBankUser.setUserPassword(in.nextLine());
								 
								 System.out.print("Enter the new user's first name: ");
								 newBankUser.setFirstName(in.nextLine());

								 System.out.print("Enter the new user's last name: ");
								 newBankUser.setLastName(in.nextLine());

								dao.createUser(newBankUser);
								break;
								
							case "3":
								System.out.println("Enter the User ID of the user you want to delete. ");
								dao.deleteUser(Integer.parseInt(in.nextLine()));						
								break;
								
							case "4":
								BankUser updateUser = new BankUser();
								System.out.print("Enter the ID of the user you wish to update: ");
								updateUser = dao.retrieveUserById(Integer.parseInt(in.nextLine()));
								if(updateUser.getUserID() == 0) 
								{
									System.out.println("No user with that ID exists.");
									break;
								}
								
								System.out.println("What do you wish to update?");
								System.out.println("1. First Name");
								System.out.println("2. Last Name");
								System.out.println("3. Username");
								System.out.println("4. Password");
								System.out.println("5. Everything");
								userInput = in.nextLine();
								
								switch (userInput)
								{
								case "1":
									System.out.print("Enter first name: ");
									updateUser.setFirstName(in.nextLine());
									break;
									
								case "2":
									System.out.print("Enter last name: ");
									updateUser.setLastName(in.nextLine());
									break;
									
								case "3":
									System.out.print("Enter Username: ");
									updateUser.setUserName(in.nextLine());
									break;
									
								case "4":
									System.out.print("Enter password: ");
									updateUser.setUserPassword(in.nextLine());
									break;
									
								case "5":
									System.out.print("Enter first name: ");
									updateUser.setFirstName(in.nextLine());
									System.out.print("Enter last name: ");
									updateUser.setLastName(in.nextLine());
									System.out.print("Enter username: ");
									updateUser.setUserName(in.nextLine());
									System.out.print("Enter password: ");
									updateUser.setUserPassword(in.nextLine());
									break;
								}
								dao.updateUser(updateUser);
								break;
								
							case "5":
								BankUser viewUser = new BankUser();
								System.out.print("Enter the user ID number of the user you wish to view: ");
								viewUser = dao.retrieveUserById(Integer.parseInt(in.nextLine()));
								System.out.println(viewUser);
								
								break;
							
							case "6":
								logOut = true;
								System.out.println("Thank you, come again!");
								break;
								
							default:
								System.out.println("Invalid choice.  Choose a number from the below options.");
						}
					}
				}
				
				
				else //regular user login
				{
					while(!logOut)
					{

						System.out.println("Welcome.  Please choose from the following:");
						System.out.println("1. View existing accounts");
						System.out.println("2. Create an account");
						System.out.println("3. Delete an account");
						System.out.println("4. Log out");
						System.out.println();
						in.nextLine();
						
						
						userInput = in.nextLine();
						
						switch(userInput)
						{
							case "1": //viewing, depositing, and withdrawing money
								dao.viewAccounts(loggedIn.getUserID());
								System.out.println("Which account would you like to access? "
										+ "(Choose corresponding account ID) ");
								int acctID = Integer.parseInt(in.nextLine());

								System.out.println("Please Choose.");
								System.out.println("1. Deposit");
								System.out.println("2. Withdrawal");
								in.nextLine();
								
								if(in.nextLine().equals("1"))
								{
									System.out.println("Enter how much to deposit.");
									dao.deposit(acctID, Double.parseDouble(in.nextLine()));
								}
								
								
								else
								{
									System.out.println("Enter how much to withdrawal");
									dao.withdrawal(acctID, Double.parseDouble(in.nextLine()));
								}
							
								break;
							
							case "2":
								BankAccount newAccount = new BankAccount();
								newAccount.setUserID(loggedIn.getUserID());
							
								System.out.print("Please enter the name of your new account. ");
								newAccount.setAccountName(in.nextLine());
							
								System.out.println("Please enter the initial balance. ");
								newAccount.setBalance((double)in.nextDouble());
							
								dao.createAccount(newAccount);
								break;
							
							case "3":
								dao.viewAccounts(loggedIn.getUserID());
								System.out.println("Enter the account ID you with to delete");
								dao.deleteAccount(Integer.parseInt(in.nextLine()));
								break;
				
							case "4":
								logOut = true;
								System.out.println("Thank you, come again!");
								break;
							
							default:
								System.out.println("Invalid choice.  Choose a number from the below options.");
						}
					}
				}
				newUser = false;
				break;
				
			case "2": //create new user case
				BankUser registerNewUser = new BankUser();
				System.out.print("Please enter your desired user name: ");
				registerNewUser.setUserName(in.nextLine());
				
				System.out.print("Please enter your first name: ");
				registerNewUser.setFirstName(in.nextLine());
				
				System.out.print("Please enter your last name: ");
				registerNewUser.setLastName(in.nextLine());
				
				System.out.println("please enter your password: ");
				registerNewUser.setUserPassword(in.nextLine());
				
				dao.createUser(registerNewUser);
				break;
			}	
		}
		
		in.close();
	}
}
