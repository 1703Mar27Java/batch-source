package com.revature.Week1Challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;

public class Utility {
	
	private String start;
	private String end;
	private String bank;
	private HashSet<String> Change;

	
	Utility(){
		Change=new HashSet<String>();
	}
	
	
	
	public void Read(String start,String end,String bank){
		this.start=start;
		this.end=end;
		this.bank=bank;
	}
	
	
	public void ReadFromFile(String fileString){
		try {
			FileReader reader=new FileReader(new File(fileString));
			BufferedReader bufferedReader=new BufferedReader(reader);
			//Scanner scanner=new Scanner(new File(fileString));
		start=	bufferedReader.readLine();
		end=bufferedReader.readLine();
		bank=bufferedReader.readLine();
		
		System.out.println(start);
		System.out.println(end);
		System.out.println(bank);
				
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public int determineMinMutations(){
		
		char startChar[] =start.toCharArray();
		char endChar[]=end.toCharArray();
		
		
		int startCount=0;
		int endCount=0;
		Hashtable<Integer,Integer> Next=new Hashtable<Integer,Integer>();
		
		for(String str: Change){
			char changeChar[]=str.toCharArray();
		
		for(int i=0;i<startChar.length;i++){
			if(startChar[i]==changeChar[i]){
				startCount++;
			}
			
			if(endChar[i]==changeChar[i]){
				endCount++;
			}
			
			if(startCount<=1){
				Next.put(startCount, endCount);
			}
			
			
		}
		}
		
	
		
		return -1;
	}
	
}
