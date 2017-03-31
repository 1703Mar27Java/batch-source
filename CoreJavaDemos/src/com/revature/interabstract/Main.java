package com.revature.interabstract;

public class Main {

	public static void main(String[] args) {
		Shape s = new Rectangle(3, 4);
		double area = s.calculateArea();
		System.out.println(area);

	}
}

abstract class Shape
{
	public abstract double calculateArea();
}

class Rectangle extends Shape
{
	private double length;
	private double width;
	
	public Rectangle(double length, double width)
	{
		this.length = length;
		this.width = width;
	}
	
	@Override
	public double calculateArea()
	{
		return (this.length * this.width);
	}
}