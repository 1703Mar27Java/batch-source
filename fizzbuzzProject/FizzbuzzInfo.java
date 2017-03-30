package com.revature.fizzbuzzProject;

import java.io.*;

public class FizzbuzzInfo implements Serializable {
	

	private static final long serialVersionUID = 4194376472311644891L;
	private int fizz;
	private int buzz;
	private int lowRange;
	private int highRange;
	
	
	public int getFizz() {
		return fizz;
	}
	public void setFizz(int fizz) {
		this.fizz = fizz;
	}
	public int getBuzz() {
		return buzz;
	}
	public void setBuzz(int buzz) {
		this.buzz = buzz;
	}
	public int getLowRange() {
		return lowRange;
	}
	public void setLowRange(int lowRange) {
		this.lowRange = lowRange;
	}
	public int getHighRange() {
		return highRange;
	}
	public void setHighRange(int highRange) {
		this.highRange = highRange;
	}
	
	
	//print FizzBuzz output to the console
	public void FizzBuzzMath()
	{
		for(int i = lowRange; i <= highRange; i++)
		{
			if(i % fizz == 0 && i % buzz == 0)
			{
				System.out.print("fizzbuzz ");
			}

			else if(i % fizz == 0)	
			{
				System.out.print("fizz ");
			}
			
			else if(i % buzz == 0)
			{
				System.out.print("buzz ");
			}			
			else
			{
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
	
	//save as byte code to file
	public void SaveTheFizz(String filename, FizzbuzzInfo fizzy)
	{
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
			oos.writeObject(fizzy);				
			oos.close();
		}
			
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//save FizzBuzz output as readable text to file
	public void SaveTheBuzz(String filename, FizzbuzzInfo fizzy)
	{
		try
		{
			FileWriter writer = new FileWriter(filename);
			for(int i = lowRange; i <= highRange; i++)
			{
				if(i % fizz == 0 && i % buzz == 0)
				{
					writer.write("fizzbuzz ");
				}

				else if(i % fizz == 0)	
				{
					writer.write("fizz ");
				}
				
				else if(i % buzz == 0)
				{
					writer.write("buzz ");
				}			
				else
				{
					writer.write(i + " ");
				}
			}
			writer.close();
		}
		
		catch(IOException e)
		{
			e.printStackTrace();			
		}
		
	}

}