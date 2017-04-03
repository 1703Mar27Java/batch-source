package codingChallenges.WeekOne;

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// start by reading in the text file
		String filename = "src/CodingChallenges/WeekOne/bank.txt";
		String str;
		try {
			// start by reading in data from file
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			str = br.readLine();
			out.println("The starting point is: " + str);
			Gene start = new Gene(str);
			str = br.readLine();
			out.println("The ending goal is: " + str);
			Gene end = new Gene(str);
			ArrayList<Gene> bank = new ArrayList<Gene>();
			out.println("The bank of available mutations is: ");
			while ((str = br.readLine()) != null) {
				out.println(str);
				Gene g = new Gene(str);
				bank.add(g);
			}
			// done reading data and creating our data structures
			// so we close our streams
			br.close();
			fr.close();

			// now we call our method that performs the
			// computations to determine the number of mutations
			// required to go from start -> end

			out.println("The number of mutations required to reach the goal is: " + minMutations(start, end, bank));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//can be  "A", "C", "G", "T".
	// this is an obvious implementation of Djikstra's algorithm
	private static int minMutations(Gene start, Gene end, ArrayList<Gene> bank) {
		if (start.equals(end))
			return 0;

		Queue<Gene> q = new LinkedList<>();
		q.add(start);
		int size = 0;
		while (!q.isEmpty()) {
			
			Gene g = new Gene(q.poll().toString());
			if (g.equals(end))
				return size;
			String curr = new String(g.toString());
			
			char[] currArr = curr.toCharArray();
			//iterate through each char and change it to see if that value is in the bank
			for (int i = 0; i < currArr.length; i++) {
				char old = currArr[i];
				currArr[i]='A';
				String next = new String(currArr);
				g.setName(next);
				if (bank.contains(g)){
					q.add(g);
				}
				currArr[i]='C';
				next = currArr.toString();
				g.setName(next);
				if (bank.contains(g)){
					q.add(g);
				}
				currArr[i]='G';
				next = currArr.toString();
				g.setName(next);
				if (bank.contains(g)){
					q.add(g);
				}
				currArr[i]='T';
				next = currArr.toString();
				g.setName(next);
				if (bank.contains(g)){
					q.add(g);
				}
				
				
				currArr[i] = old;
			}

			size++;
			
		}
		return -1;
	}

}
