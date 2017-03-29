package com.revature.fizzBuzz;

import java.util.Scanner;
import java.io.*;

public class fizzBuzz {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int low = 0;
		int high = 0;
		int first =0;
		int second =0;
		//take next 4 user inputs
		try {
			low = s.nextInt();
			high = s.nextInt();
			first = s.nextInt();
			second = s.nextInt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//close resources -- should have done it this was for other streams as well
		finally{
			s.close();
		}
		//print data to console
		System.out.println(String.format("Low: %d High : %d First : %d Second : %d",low,high,first,second));
		//begin string generation
		String out = "";
		if (low < high && first!=0 && second!=0) {
			for (int i = low; i <= high; ++i) {
				out+=(process(i,first,second));
			}
		}
		//write to file
		BufferedWriter write;
		try {
			write = new BufferedWriter(new FileWriter("src/SerializedThings/test.out"));
			write.write(out);
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//create object for file
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/SerializedThings/test0.out"));
			oos.writeObject(new FizzBuzzInfo(out,low,high,first,second));
			oos.close();
			//open object file to read data
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/SerializedThings/test0.out"));
			System.out.println(((FizzBuzzInfo)ois.readObject()).getOutput());
			ois.close();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private static String process(int at, int first, int second) {
		String out = at +"";
		if (at%first==0)out ="fizz";
		if (at%second ==0) out=out.replaceAll("[-0-9]","")+"buzz";
		//System.out.println(out);
		out+="\r";
		return out;
	}
}
