package com.revature.collections;
import java.util.*;

public class ListExample 
{
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		List<Integer> arrayList = new ArrayList<>();
		
		arrayList.add(5);
		arrayList.add(5);
		arrayList.add(18);
		arrayList.add(2);
		arrayList.add(3);
		
		System.out.println("ArrayList: " + arrayList);
		System.out.println("Array single value: " + arrayList.get(4));
		
		//LinkedList
		List<Integer> listLinkedList = new LinkedList<>(); //only list methods
		Deque<Integer> dequeLinkedList = new LinkedList<>(); //only deque methods
		Queue<Integer> queueLinkedList = new LinkedList<>(); //only queue methods
		LinkedList<Integer> normalLinkedList = new LinkedList<>(); //everything
		
		//instanceof: compares object to specified type
		System.out.println(listLinkedList instanceof LinkedList);
		System.out.println(listLinkedList instanceof Deque);
		
		System.out.println("\n Queue example (FIFO):");
		System.out.println("Queue: " + queueLinkedList);
		queueLinkedList.add(7);
		System.out.println("Queue: " + queueLinkedList);
		queueLinkedList.add(62);
		System.out.println("Queue: " + queueLinkedList);
		queueLinkedList.add(3);
		System.out.println("Queue: " + queueLinkedList);
		queueLinkedList.remove();
		System.out.println("Queue: " + queueLinkedList);
		queueLinkedList.remove();
		System.out.println("Queue: " + queueLinkedList);
		queueLinkedList.remove();
		System.out.println("Queue: " + queueLinkedList);
		queueLinkedList.remove();
		System.out.println("Queue: " + queueLinkedList);
		
		System.out.println(arrayList);
		filter(arrayList);
		System.out.println(arrayList);
	}
	
	//Iterator
	/*
	 * Use the iterator of a collection instead of a foreach construct when
	 * you filter the collection (remove the current element
	 * OR to iterate over multiple collections in parallel)  
	 * 
	 * Iterator methods: boolean hasNext();, <>next(), void remove();
	 */
	
	//ListIterator: can iterate through Lists forwards or backwards
	//Iterator goes in one direction only
	
	static void filter(Collection<Integer> c)
	{
		for(Iterator<Integer> it = c.iterator(); it.hasNext();)
		{
			if(it.next() > 3)
			{
				it.remove();
			}
		}
	}	
}
