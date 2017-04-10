package codingChallenges.WeekTwo.main;


import java.util.Scanner;
import static java.lang.System.*;

import codingChallenges.WeekTwo.dao.EmpDAOImpl;

public class main {

	public static void main(String[] args) {
		EmpDAOImpl eDAO = new EmpDAOImpl();
		Scanner sc = new Scanner(in);
		out.println("Please enter the dept. id to give a raise to: ");
		int deptID = sc.nextInt();
		sc.nextLine();
		out.println("Please enter the raise amount percentage");
		int raiseAmt = sc.nextInt();
		eDAO.giveRaise(deptID, raiseAmt);
		sc.close();
		
		//so this works, except for some reason my stored procedure doesnt work as it should.
	}

}
