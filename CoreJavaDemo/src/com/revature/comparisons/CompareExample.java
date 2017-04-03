package com.revature.comparisons;

import java.util.ArrayList;
import java.util.Collections;

public class CompareExample {

	public static void main(String[] args) {
		ArrayList<Movie> list=new ArrayList<Movie>();
		list.add(new Movie(10,"Jurassic Park",1993));
		list.add(new Movie(17,"Super Troopers",2003));
		
		Collections.sort(list);
		System.out.println("movies after sorting: ");
		for(Movie m: list){
			System.out.println(m);
		}
	}

}

class Movie implements Comparable<Movie>{

	@Override
	public String toString() {
		return "Movie [rating=" + rating + ", name=" + name + ", year=" + year + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Movie(double rating, String name) {
		super();
		this.rating = rating;
		this.name = name;
	}
	
	public Movie(double rating, String name,int year) {
		super();
		this.rating = rating;
		this.name = name;
		this.year=year;
	}

	private double rating;
	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	private String name;
	
	private int year;
	
	@Override
	public int compareTo(Movie arg0) {
		
		return this.year-arg0.getYear();
	}
	
	
	//http://www.geeksforgeeks.org/comparable-vs-comparotr-in-java
	//for an example of comparator (more free comparison methods!
}