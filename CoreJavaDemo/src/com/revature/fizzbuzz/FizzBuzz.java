package com.revature.fizzbuzz;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class FizzBuzz implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7845663291064893401L;

	@Override
	public String toString() {
		return "FizzBuzz [range1=" + range1 + ", range2=" + range2 + ", a=" + a + ", b=" + b + "]";
	}

	private int range1,range2,a,b;
	
	/**
	 * Prompts the user for information to set up  fizzbuzz game
	 */
	public void Setup(){
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter the start of the number range");
		range1=scanner.nextInt();
		System.out.println("Enter the end of the number range");
		range2=scanner.nextInt();
		System.out.println("Enter the first multiple");
		a=scanner.nextInt();
		System.out.println("Enter the second multiple");
		b=scanner.nextInt();
		
		//if range 2 is the higher number we must swap them for the program to work properly.
		if(range1>range2){
			int temp=range1;
			range1=range2;
			range2=temp;
		}
	}
	
	
	/**
	 * outputs the results of the fizzbuzz game
	 */
	public void Print(){
		
		String output="";
		
		FileWriter writer;
		try {
			writer=new FileWriter("src/com/revature/fizzbuzz/fizzbuzzoutput");
			writer.write("");
		
		for(Integer i=range1;i<=range2;i++){
			if(i%a==0 && i%b==0){
				output="FizzBuzz";
			}
			else
				if(i%a==0){
					output="Fizz";
				}
				else if(i%b==0){
					output="Buzz";
				}
				else{
					output=i.toString();
				}
			
			System.out.println(output);
			
		
			
				writer.append(output +"\n");
		}
				writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		
	}
	
	public static void main(String[] args) {
		FizzBuzz FizzBuzzInfo=new FizzBuzz();
		FizzBuzzInfo.Setup();
		FizzBuzzInfo.Print();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/com/revature/fizzbuzz/fizzbuzzinfo"));
			oos.writeObject(FizzBuzzInfo);
			System.out.println(FizzBuzzInfo);
			oos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
