package com.revature.util;

import java.sql.SQLException;
import java.util.List;

import com.revature.bean.ERS_REIMBURSEMENTS;
import com.revature.bean.ERS_USERS;
import com.revature.dao.ERS_REIMBURSEMENTSDAO;
import com.revature.dao.ERS_REIMBURSEMENTSDAOImpl;
import com.revature.dao.ERS_USERSDAO;
import com.revature.dao.ERS_USERSDAOImpl;

public class Main {

	public static void main(String[] args) {

		ERS_USERSDAO udao = new ERS_USERSDAOImpl();
		ERS_REIMBURSEMENTSDAO rdao = new ERS_REIMBURSEMENTSDAOImpl();
		
        String username = "mehrab";
        String password = "p4ss";
		try {
	        ERS_USERS currentUser;
			currentUser = udao.search(username, password);
	        List<ERS_REIMBURSEMENTS> reimbursements = rdao.loadAll();
	        List<ERS_USERS> allEmps = udao.loadAll();
	        System.out.println(allEmps);
	        System.out.println(currentUser);
	        System.out.println(reimbursements);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
