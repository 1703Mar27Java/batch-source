package com.revature.fizzbuzz;
import java.util.Scanner;

import java.io.*;

public class FizzBuzzHandler {

	public static void main(String[] args) {
		int[] fourInts = new int[4];
		String changedRange = "";
		
		//1 take 4 ints
		Scanner sc = new Scanner(System.in);
		System.out.print("To:");
		fourInts[0] = sc.nextInt();
		System.out.print("From:");
		fourInts[1] = sc.nextInt();
		System.out.print("First:");
		fourInts[2] = sc.nextInt();
		System.out.print("Second:");
		fourInts[3] = sc.nextInt();
		
		//2 print out range
		for (int i = 0; i < fourInts.length; i++){
			System.out.print(fourInts[i] + " ");
		}
		
		System.out.println();
		
		int rangeCount = fourInts[0] - fourInts[1];
		System.out.println(rangeCount);
		
		int[] changedRangeInt = new int[rangeCount + 1];
		
		for (int i = fourInts[1]; i < fourInts[0] + 1; i++){
			changedRangeInt[i - fourInts[1]] = i;
			
			//control flow decisions
			if ((i % fourInts[2] == 0) && (i % fourInts[3] == 0)){
				changedRange = changedRange.concat("fizzbuzz ");
			}
			else if (i % fourInts[2] == 0){
				changedRange = changedRange.concat("fizz ");
			}
			else if (i % fourInts[3] == 0){
				changedRange = changedRange.concat("buzz ");
			}
			else{
				changedRange = changedRange.concat(String.valueOf(i) + " ");
			}
			
		}
		
		System.out.println(changedRange);
		
		//3 create instance of fizzbuzz pojo with params
		FizzBuzz readyToBeSerialized = new FizzBuzz(fourInts, changedRange);
		//System.out.println(readyToBeSerialized);
		
		//4 serialize pojo to file
		String filename = "src/serializedThings/FizzBuzz";
		//writeObject(filename, readyToBeSerialized);
		readObject(filename);
		
		//5 use fileReader and FileWriter
		String filename2 = "src/serializedThings/FizzBuzzFileReadWriteBonus";
		//writeObjectBonus(filename2, readyToBeSerialized);
		ReadObjectBonus(filename2);
		
	}
	
	static void writeObjectBonus(String filename, Object obj){
		//exception handling
		try (Writer writer = new FileWriter(filename)){
			writer.write(obj.toString());
			writer.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	static void ReadObjectBonus(String filename){
		//exception handling
		try (Reader reader = new FileReader(filename)){
			    int data = reader.read();
			    while(data != -1){
			        char dataChar = (char) data;
			        System.out.print(dataChar);
			        data = reader.read();
			    }
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	
	static void writeObject(String filename, Object obj){
		//exception handling
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(obj);
			System.out.println(obj);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	static void readObject(String filename){
		//exception handling. More specific to most general
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			Object obj = ois.readObject();
			System.out.println(obj);
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}

}
