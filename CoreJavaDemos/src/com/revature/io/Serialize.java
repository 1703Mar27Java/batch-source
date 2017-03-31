package com.revature.io;

import java.io.*;

public class Serialize 
{
	public static void main(String[] args)
	{
		String fileName = "src/SerializedThings/PersonDemo";
		Person person = new Person("john", 23, "123456789");
		writeObject(fileName, person);
	}
	
	static void writeObject(String fileName, Object obj)
	{
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName)))
		{
			oos.writeObject(obj);
			System.out.println(obj);
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
	
	static void readObject(String filename)
	{
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)))
		{
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
