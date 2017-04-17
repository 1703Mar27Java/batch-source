package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.revature.bean.Bank_User;
import com.revature.dao.Bank_UserDAO;
import com.revature.dao.Bank_UserDAOImpl;

public class Main {

	public static void main(String[] args) {

        String userName = "admin";
        String userPassword = "p4ssw0rd";
        Bank_UserDAO bank_UserDAO = new Bank_UserDAOImpl();
        
        try {
			Bank_User user = bank_UserDAO.getUser(userName, userPassword);
			System.out.println(user.toString());
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
