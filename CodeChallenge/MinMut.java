package miniumumMutation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class MinMut {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter The First String");
		String string1 = scanner.nextLine();
		string1.toUpperCase();
		
		System.out.println("Enter The Second String");
		String string2 = scanner.nextLine();
		string2.toUpperCase();
		System.out.println("Enter The Bank, Each String should be followed by a comma");
		String array = scanner.nextLine();
		array.toUpperCase();
		
		String[] bank= array.split(",");
		int mutation = miniumumMutation(string1,string2, bank);
		
		
		System.out.println(mutation);

	}
	
	private static int miniumumMutation(String start, String end, String[] bank) {
		
		
		char[] charsSet = {'A','C','G','T'};
		Queue<String> queue = new LinkedList<>();

		if(start.equals(end))
		{
			return 0;
		}
		
		int mutation  = 0;
		
		Set<String> bankS = new HashSet<>();
		
		queue.add(start);
		
		for (String bankarray : bank)
		{
			bankS.add(bankarray);
		}
		
		while(!queue.isEmpty())
		{
			
			for(int i = queue.size(); i > 0; i--)
			{
				String curSet = queue.remove();
				if (curSet.equals(end))
				{
					return mutation;
				}
				for (int j = 0; j < curSet.length(); j++) {
					for (char curChar : charsSet) 
					{
						char[] currChar = curSet.toCharArray();
						currChar[i] =curChar;
						
						String contain = new String(currChar);
						
						if(bankS.contains(contain))
						{
							queue.add(contain);
							bankS.remove(contain);
						}
					}
				}
				
			}
			mutation++;
			
		}
		
		return -1;
		
	}

	
}
