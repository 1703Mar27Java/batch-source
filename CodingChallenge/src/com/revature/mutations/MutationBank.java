package com.revature.mutations;

public class MutationBank 
{
	//starting gene string
	public String start;
	//ending gene string
	public String end;
	//gene string bank
	public String[] bank;
	
	
	//constructor
	public MutationBank(String start, String end, String[] bank)
	{
		this.start = start;
		this.end = end;
		this.bank = bank;
	}
	
	//compare two strings and find put if they only have one character different
	private boolean onlyOneDifferent(String string1, String string2)
	{
		if(string1.length() != string2.length())
		{
			return false;
		}
		
		else
		{
			int same = 0;
			
			for(int i = 0; i < string1.length(); i++)
			{
				if(string1.charAt(i) == string2.charAt(i))
				{
					same++;
				}
			}
			
			return same == (string1.length() - 1);
		}
	}
	
	//return number of mutations
	public int numMutations()
	{
		int mutationCount = 0;
		
		//return zero if start and end arrays are the same
		if(start.equals(end))
		{
			return 0;
		}
		
		else
		{
			//cycle through all Strings in the bank
			for(int i = 0; i < bank.length; i++)
			{
				if(this.start.equals(end))
				{
					return mutationCount;
				}
				
				else if(this.start.equals(bank[i]))
				{
					continue;
				}
				
				else if(onlyOneDifferent(start, bank[i]))
				{
					this.start = bank[i];
					mutationCount++;
					
					//head back to the beginning of the loop, in case the changed string
					//now equals the first string in bank
					//i should be equal to one after loop increments and before next execution
					i = -1;
				}
			}
		}
		
		//if this is reached, then mutation to desired result is impossible
		return -1;
	}
	
}
