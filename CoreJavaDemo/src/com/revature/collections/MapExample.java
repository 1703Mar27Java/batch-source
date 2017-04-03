package com.revature.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapExample {

	public static void main(String[] args) {
		
		//Maps do not have iterators
		Map<Integer,String> hashMap=new HashMap<>();
		hashMap.put(4, "John Smith");
		hashMap.put(5, "Johann Smith");
		hashMap.put(6, "John Schmidt");
	
		System.out.println(hashMap);
		
		hashMap.put(6, "Johanna Schmidth"); //replaced value for key #6
		
		System.out.println(hashMap);
		
		System.out.println("hashMap size: "+hashMap.size());
		System.out.println("hashMap size value: "+hashMap.get(5));
		
		for(Entry<Integer,String> entry : hashMap.entrySet()){
			System.out.println(entry.getKey()+ "\t"+entry.getValue());
			
			
		}

	}

}
