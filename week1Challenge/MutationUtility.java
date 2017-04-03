package codeChallengeOne;

import java.util.ArrayList;

public class MutationUtility {
	private String start;
	private String end;
	private ArrayList<String> bank;

	public MutationUtility() {
		super();
	}

	public MutationUtility(String start, String end, ArrayList<String> bank) {
		this.start = start;
		this.end = end;
		this.bank = bank;
	}

	public int performMutation() {
		ArrayList<Integer> diffElements = new ArrayList<Integer>();
		int count = 0;

		for (int i = 0; i < 8; i++) {
			if (start.charAt(i) != end.charAt(i)) {
				diffElements.add(i);
			}
		}

		StringBuilder mutated = new StringBuilder(start);
		for (int index : diffElements) {
			for (String validMut : bank) {
				if (mutated.charAt(index) != end.charAt(index) && end.charAt(index) == validMut.charAt(index)) {
					mutated.setCharAt(index, validMut.charAt(index));
					count++;
					continue;
				}
			}

		}

		if (mutated.toString().equals(end)) {
			System.out.println("Mutated from " + start + " to " + end + " in " + count + " sub mutations.");
			return count;
		} else {
			System.out.println("Failed to mutate");
			return -1;
		}

	}

}
