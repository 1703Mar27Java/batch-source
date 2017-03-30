package com.revature.io;

import java.io.*;
import java.util.Scanner;
import static java.lang.System.*;



public class FizzBuzz {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter first value for multiple: ");
		int value1 = scan.nextInt();
		System.out.println("Please enter second higher value for multiple: ");
		int value2 = scan.nextInt();
		
		System.out.println("Please enter first value for range: ");
		int range1 = scan.nextInt();
		System.out.println("Please enter second value for range: ");
		int range2 = scan.nextInt();
		
		
		String nameFile = "src/SerializeThings/SerialDemo";
		String outputFile = "src/SerializeThings/Readable";
		
		FizzBuzzInfo fbuzz = new FizzBuzzInfo(value1, value2, range1, range2);
		writeObject(nameFile, fbuzz);
		
		scan.close();
		
		try{
		FileWriter fw = new FileWriter(outputFile);
			
		for(int i = range1; i <=range2; i++)
		{
			//StringBuffer buff1 = new StringBuffer();
			//StringBuffer buff2 = new StringBuffer();
			
			if(((i % value1) == 0) && ((i % value2) == 0))
			{
				//buff1.append("fizz");
				//buff2.append("buzz");
				fw.write("fizzbuzz");
				
			}
			else if((i % value1) == 0)
			{
				//buff1.append("fizz");
				fw.write("fizz");
			}
			else if((i % value2) == 0)
			{
				//buff2.append("buzz");
				fw.write("buzz");
			}
			else{
				fw.write(new Integer(i).toString());
			}
		
		}
		fw.close();
		}catch(IOException o) {
		o.printStackTrace();
	}
}
	
static void writeObject(String filename, Object obj){
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));){
			oos.writeObject(obj);
			System.out.println(obj);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	static void readObject(String filename){
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			Object obj = ois.readObject();
			System.out.println(obj);
		} catch(FileNotFoundException o){
			o.printStackTrace();
		} catch (IOException o){
			o.printStackTrace();
		} catch (ClassNotFoundException o){
			o.printStackTrace();
		}
	}
	

}
