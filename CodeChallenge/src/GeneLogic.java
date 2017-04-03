import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeneLogic {
	private String start = "";
	private String end = "";
	private List<String> bank = new ArrayList<>();	//using a list instead of an array because arrays aren't muteable
	
	public GeneLogic(){
		
	}
	
	public void setStrings(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Start: ");
		start = sc.nextLine();
		System.out.print("End: ");
		end = sc.nextLine();
		
		boolean badString = false;
		
		while(true){
			badString = false;
			for (int i = 0; i < start.length(); i++){
				if (start.charAt(i) != 'A' && start.charAt(i) != 'C' && start.charAt(i) != 'G' && start.charAt(i) != 'T'){
					badString = true;
				}
			}
			if (badString){
				System.out.println("Start can only have A, C, G or T");
				System.out.print("Start: ");
				start = sc.nextLine();
			}
			else{
				badString = false;
				break;
			}
		}
		
		while(true){
			badString = false;
			for (int i = 0; i < end.length(); i++){
				if (end.charAt(i) != 'A' && end.charAt(i) != 'C' && start.charAt(i) != 'G' && start.charAt(i) != 'T'){
					badString = true;
				}
			}
			if (badString){
				System.out.println("End can only have A, C, G or T");
				System.out.print("End: ");
				end = sc.nextLine();
			}
			else{
				badString = false;
				break;
			}
		}
		
		while (start.length() != 8){
			System.out.println("Start has to be 8 chars");
			System.out.print("Start: ");
			start = sc.nextLine();
		}
		
		while (end.length() != 8){
			System.out.println("End has to be 8 chars");
			System.out.print("End: ");
			end = sc.nextLine();
		}
		
		//this should always be the case
		if (!badString){
			startEndSuccessfull(start, end);
		}
		
	}
	
	public void startEndSuccessfull(String start, String end){
		bank.add(start);
		bank.add(end);
		
		System.out.println("bank: " + bank.get(0) + " , " + bank.get(1));
	}
	
	public int calculateMutations(){
		int numberOfMutations = 0;
		
		while (!bank.get(numberOfMutations).equals(bank.get(numberOfMutations + 1))){
			
			
			String temp = bank.get(numberOfMutations);
			String temp2 = bank.get(numberOfMutations + 1);
			
			StringBuilder tempBld = new StringBuilder(temp);
			
			for (int i = 0; i < temp.length(); i++){
				if (temp.charAt(i) != temp2.charAt(i)){
					System.out.println("No equals");
					tempBld.setCharAt(i, temp2.charAt(i));
					bank.add(++numberOfMutations, tempBld.toString());
					break;	//we only want to do it once
				}
			}
			
			//print the updated bank
			for (int j = 0; j < bank.size(); j++){
				System.out.print(bank.get(j) + " , ");
			}
			System.out.println("");
		}
		
		return numberOfMutations;
	}

}
