package codeChallengeOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MutationDriver {

	public static void main(String[] args) {
		String fileName;
		showPrompt();
		Scanner in = new Scanner(System.in);
		fileName = in.next();
		in.close();
		MutationUtility mutation = getInput(fileName);

		mutation.performMutation();

	}

	public static void showPrompt() {
		System.out.println(
				"Enter the name of a file with starting sequence, an ending sequence, and a series of valid mutations"
						+ "in the following format: \n(STARTING) \n(ENDINGXX) \n(MUTATION)\n(MUTATION)\n(MUTATION)\n ...");
	}

	public static MutationUtility getInput(String fileName) {
		ArrayList<String> bank = new ArrayList<>();
		String start = "";
		String end = "";
		String validMutation = "";

		File file = new File(fileName);
		Scanner in = null;
		try {
			in = new Scanner(file);

			start = in.nextLine().toUpperCase();
			if (start.length() != 8) {
				System.out.println("Invalid length of sequence");
				System.exit(-1);
			}

			end = in.nextLine().toUpperCase();
			if (end.length() != 8) {
				System.out.println("Invalid length of sequence");
				System.exit(-1);
			}

			while (in.hasNextLine()) {
				validMutation = in.next();
				if (validMutation.length() != 8) {
					System.out.println("Invalid length: Must be 8 characters");
					System.exit(-1);
				}
				bank.add(validMutation.toUpperCase());
			}

			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		return new MutationUtility(start, end, bank);
	}

}
