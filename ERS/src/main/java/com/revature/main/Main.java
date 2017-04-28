package com.revature.main;
import javax.xml.crypto.Data;

import com.revature.beans.User;
import com.revature.database.*;


public class Main {

	public static void main(String[] args) {
		
		DataFacadeImple dao = new DataFacadeImple();
		
		User pass = dao.getUser("rprice0");
		
		System.out.println(pass.getFirstName());
		
	}

}
