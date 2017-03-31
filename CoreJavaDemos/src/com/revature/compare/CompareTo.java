package com.revature.compare;

import java.util.ArrayList;
import java.util.Collections;

public class CompareTo
{
	public static void main(String[] args)
	{
		ArrayList<Movie> list = new ArrayList<Movie>();
		list.add(new Movie(6, "Super Troopers", 2003));
		list.add(new Movie(10,"Jurassic Park", 1993));
		
		Collections.sort(list);
		System.out.println("Sorted Movies: ");
		for(Movie M : list)
		{
			System.out.println(M.getName());
		}
	}
}

class Movie implements Comparable<Movie>
{
	private double rating;
	private String name;
	private int year;	

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
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
	
	public Movie(double rating, String name, int year)
	{
		this.rating = rating;
		this.name = name;
		this.year = year;
	}
	
	@Override
	public int compareTo(Movie arg0)
	{
		return (this.year - arg0.year) + (this.name.hashCode() - arg0.name.hashCode()) + ((int)(this.rating - arg0.rating));
	}
}