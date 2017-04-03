package com.revature.collections;

import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class SetExample {

	public static void main(String[] args) {
		
		
		Set<Integer> hashSet=new LinkedHashSet<>();
		hashSet.add(5);
		hashSet.add(5);
		hashSet.add(2);
		hashSet.add(17);
		hashSet.add(6);
		
		System.out.println("HashSet: "+hashSet);
		System.out.println(hashSet.size());
		
		Set<Integer> treeSet= new TreeSet<>();
		treeSet.addAll(hashSet);
		System.out.println("TreeSet: "+treeSet);
		
		

	}

}
