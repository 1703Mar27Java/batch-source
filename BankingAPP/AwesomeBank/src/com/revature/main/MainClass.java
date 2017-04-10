package com.revature.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.AwesomeBankDaoImple;
import com.revature.domain.AwesomeBank;
import com.revature.util.ConnectionUtil;;

public class MainClass {
	
	

	public static void main(String[] args) throws SQLException {
		
		
		//Connection con = ConnectionUtil.getConnection();
		//System.out.println(con.toString());
		
		AwesomeBankDaoImple dao = new AwesomeBankDaoImple();
		
		
		//dao.deleteAccount(2);
		
		Scanner sc = new Scanner(System.in); 

		boolean session = false; 
		boolean mainMenu=true;

		while (mainMenu) {
			
			System.out.print("========================\n"
					 +"WELCOME TO THE AWESOME BANK OF AWESOME: \n \n"
					 + "1. LOGGIN TO AWESOME \n"
					 + "2. CREATE AWESOME ACCOUNT \n"
					 + "4. EXIT AWESOME BANK\n"
					 + "========================\n"
					 + "\nEnter selection: ");
				int selection = sc.nextInt(); 
			
			
				switch(selection)
				{
				case 1:
					break;
				case 2:
					
					System.out.println("=====================\n" +"PLEASE ENTER YOUR AWESOME USERNAME");
					String userName = sc.next();
					
					System.out.println("=====================\n" +"PLEASE ENTER YOUR AWESOME PASSWORD");
					
					String password = sc.next();
					AwesomeBank aB = new AwesomeBank(userName, password);
					int valid = dao.createAccount(aB);
					if(valid == 1)
					{
						session = true;
					}
					else
					{
						session = false;
					}
					
					
					
					while (session){
						System.out.print("========================\n"
								 +"AWESOME Menu: \n \n"
								 + "1. Deposit AWESOME Money \n"
								 + "2. Withdraw AWESOME Money \n"
								 + "3. Check AWESOME Account Balance\n"
								 + "4. Log out of AWESOME Account\n"
								 + "========================\n"
								 + "\nEnter selection: ");
							
						selection = sc.nextInt(); 
						
						switch(selection){
						case 1:
							System.out.println("=====================\n" +"PLEASE ENTER AWESOME DEPOSIT AMOUNT");
							float deposit = sc.nextFloat();
							aB = new AwesomeBank(33);
							dao.depositMoney(aB, deposit);
							break;
						case 2:
							break;
						case 3:
						case 4:
							session =false;
							System.out.println("========================\n" + 
							"THANK YOU FOR BEING AWESOME COME AGAIN");
						}
						
						
						
					}
					
				
				}
				
				
			

			
			
			
			
		}
		
		
		
		
		
		}
}