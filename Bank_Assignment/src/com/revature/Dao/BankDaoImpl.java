package com.revature.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.revature.Domain.Bank;
import com.revature.Domain.User;
import com.revature.Main.Main;
import com.revature.util.ConnectionUtil;

public class BankDaoImpl implements BankDao {

	@Override
	public void creatBankAccount(Bank bank, User user) {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");

			String sql = "INSERT INTO BANK_ACCOUNT (USER_ID, BANK_ACCOUNT_NAME, BALANCE) VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bank.getUserID());
			pstmt.setString(2, bank.getBankName());
			pstmt.setFloat(3, bank.getBalance());

			pstmt.executeUpdate();
			System.out.println("Account Added");

		} catch (SQLException | IOException e) {
			e.printStackTrace();

		}

		Main.onceLoggedIn(user);
	}

	@Override
	public void depositBankAccount(Bank bank, User user) {

		List<Bank> banks = retrieveBankAccounts(bank, user);

		System.out.println("Which account would you like to add to....");
		Scanner sc = new Scanner(System.in);
		try {

			int choice = sc.nextInt();
			System.out.println("How much would you like to add");
			float amount = sc.nextFloat();

			Bank chosen = banks.get(choice - 1);

			try {
				Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");

				String sql = "UPDATE BANK_ACCOUNT SET BALANCE = BALANCE + (?) WHERE BANK_ACCOUNT_NAME = (?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setFloat(1, amount);
				pstmt.setString(2, chosen.getBankName());

				pstmt.executeUpdate();
				System.out.println("Amount Added");

			} catch (SQLException | IOException e) {
				e.printStackTrace();

			}
		} catch (InputMismatchException | IndexOutOfBoundsException e) {
			System.out.println("\nInvalid Input\n");
			depositBankAccount(bank, user);
		}

		retrieveBankAccounts(bank, user);
		Main.onceLoggedIn(user);
	}

	@Override
	public void withdralBankAccount(Bank bank, User user) {
		List<Bank> banks = retrieveBankAccounts(bank, user);

		System.out.println("Which account would you like to take from....");
		Scanner sc = new Scanner(System.in);
		Bank chosen = bank;
		try {
			int choice = sc.nextInt();
			System.out.println("How much would you like to take");
			float amount = sc.nextFloat();

			chosen = banks.get(choice - 1);

			if (amount <= banks.get(choice - 1).balance && choice <= banks.size() && amount >= 0) {

				try {
					Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");

					String sql = "UPDATE BANK_ACCOUNT SET BALANCE = BALANCE - (?) WHERE BANK_ACCOUNT_NAME = (?)";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setFloat(1, amount);
					pstmt.setString(2, chosen.getBankName());

					pstmt.executeUpdate();
					System.out.println("Amount taken");

				} catch (SQLException | InputMismatchException | IOException e) {
					e.printStackTrace();

				}
			} else
				System.out.println("You can't take out more than the amount in the Account or a Negative Amount");

		} catch (InputMismatchException | IndexOutOfBoundsException e) {
			System.out.println("\nInvalid Input\n");
			withdralBankAccount(chosen, user);
		}

		retrieveBankAccounts(bank, user);
		Main.onceLoggedIn(user);
	}

	@Override
	public void deleteBankAccount(Bank bank, User user) {
		List<Bank> banks = retrieveBankAccounts(bank, user);

		System.out.println("Which account would you like to delete....");
		Scanner sc = new Scanner(System.in);

		try {
			int choice = sc.nextInt();

			Bank chosen = banks.get(choice - 1);

			if (banks.get(choice - 1).balance == 0) {

				try {
					Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");

					String sql = "DELETE FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_NAME = ?";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, chosen.getBankName());

					pstmt.executeUpdate();
					System.out.println("Account Deleted");

				} catch (SQLException | IOException e) {
					e.printStackTrace();

				}
			} else
				System.out.println("You can't delete an Account with money still in it.");

		} catch (InputMismatchException |

				IndexOutOfBoundsException e) {
			System.out.println("\nInvalid Input\n");
			deleteBankAccount(bank, user);
		}

		retrieveBankAccounts(bank, user);
		Main.onceLoggedIn(user);
	}

	@Override
	public List<Bank> retrieveBankAccounts(Bank bank, User user) {
		List<Bank> banks = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");

			String sql = "SELECT * FROM BAnK_ACCOUNT WHERE USER_ID = (?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bank.getUserID());

			int count = 0;
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				count++;
				int id = rs.getInt("USER_ID");
				String name = rs.getString("BANK_ACCOUNT_NAME");
				float balance = rs.getFloat("BALANCE");
				Bank c = new Bank(id, balance, name);
				banks.add(c);

				System.out.println(count + ") " + "Bank Account Name: " + name + "\tBalance: " + balance);
			}
			if (count < 1)
				System.out.println("You have no Bank Accounts yet");

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		// Main.onceLoggedIn(user);
		return banks;
	}
}