package main;

import java.util.ArrayList;
import java.util.Scanner;
import dao.challengeDAOImp;
import domain.Department;

public class Main {

	public static void main(String[] args) {
		challengeDAOImp dao = new challengeDAOImp();
		boolean done = false;

		Scanner s = new Scanner(System.in);

		while (!done) {
			System.out.print("Choose an option:\n\n[1] view departments\n[2] give raise\n\n>");
			switch (s.next()) {
			case "1":
				ArrayList<Department> deps = dao.getDepartments();
				System.out.println("Listing departments-\n");
				for (Department d : deps) {
					System.out.println(d.getName() + ": " + d.getAvgSal());
				}
				break;

			case "2":
				System.out.print("Enter department id: ");
				int id = s.nextInt();
				System.out.print("Enter raise amount(for 10% enter 1.10):");
				double raise = s.nextDouble();
				dao.callRaise(id, raise);
				System.out.println("\nSuccessfully raised salary");
				break;

			case "3":
				done = true;
				break;
				
			default:
				break;
			}
			

		}
		s.close();
	}

}
