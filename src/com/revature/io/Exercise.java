package com.revature.io;

import java.io.*;
import java.util.*;

public class Exercise {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int value1, value2, valueA, valueB;
		
		LinkedList<String> fizzBuzzList = new LinkedList<String>();
		
		System.out.println("Enter the first integer value:");
		
		value1 = scan.nextInt();
		
		System.out.println("Enter the second integer value:");
		
		value2 = scan.nextInt();
		
		System.out.println("Enter the third integer value:");
		
		valueA = scan.nextInt();
		
		System.out.println("Enter the fourth integer value:");
		
		valueB = scan.nextInt();
		
		//range is equal to one
		if(value1 == value2)
		{
			if((value1 % valueA == 0) && (value1 % valueB != 0))
			{
				fizzBuzzList.add("fizz");
			}
			
			else if((value1 % valueA != 0) && (value1 % valueB == 0))
			{
				fizzBuzzList.add("buzz");
			}
			
			else if((value1 % valueA == 0) && (value1 % valueB == 0))
			{
				fizzBuzzList.add("fizzbuzz");
			}
			
			else fizzBuzzList.add(Integer.toString(value1));
		}
		
		//range is equal to value1 - value2
		if(value1 < value2)
		{
			for(int i = value1; i < value2; i++)
			{
				if((i % valueA == 0) && (i % valueB != 0))
				{
					fizzBuzzList.add("fizz");
				}
				
				else if((i % valueA != 0) && (i % valueB == 0))
				{
					fizzBuzzList.add("buzz");
				}
				
				else if((i % valueA == 0) && (i % valueB == 0))
				{
					fizzBuzzList.add("fizzbuzz");
				}
				
				else fizzBuzzList.add(Integer.toString(i));
			}
		}
		
		//range is equal to value2 - value1
		if(value1 > value2)
		{
			for(int i = value2; i < value1; i++)
			{
				if((i % valueA == 0) && (i % valueB != 0))
				{
					fizzBuzzList.add("fizz");
				}
				
				else if((i % valueA != 0) && (i % valueB == 0))
				{
					fizzBuzzList.add("buzz");
				}
				
				else if((i % valueA == 0) && (i % valueB == 0))
				{
					fizzBuzzList.add("fizzbuzz");
				}
				
				else fizzBuzzList.add(Integer.toString(i));
			}
		}
		
		//serialize object with populated linked list
		
		String fileName = "src/SerializedThings/FizzBuzz";
		
		FizzBuzzInfo fizzBuzz = new FizzBuzzInfo(fizzBuzzList);
		
		writeObject(fileName, fizzBuzz);
	}
	
	/**
	 * WriteObject method writes serializable object to file
	 */
	static void writeObject(String fileName, Object fzbz)
	{
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName)))
		{
			oos.writeObject(fzbz);
			oos.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException f)
		{
			f.printStackTrace();
		}
	}
}

//stores a Linked List containing the fizzes and buzzes
class FizzBuzzInfo implements Serializable
{
	private LinkedList<String> fizzBuzzList;
	
	private static final long serialVersionUID = 883790739479285638L;
	
	public FizzBuzzInfo(LinkedList<String> fizzBuzzList)
	{
		this.setFizzBuzzList(fizzBuzzList);
	}

	public LinkedList<String> getFizzBuzzList()
	{
		return fizzBuzzList;
	}

	public void setFizzBuzzList(LinkedList<String> fizzBuzzList)
	{
		this.fizzBuzzList = fizzBuzzList;
	}
}