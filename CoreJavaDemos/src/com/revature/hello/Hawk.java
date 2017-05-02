package com.revature.hello;


class Raptor extends Bird {
	static  {
		System.out.print("r1 ");
	}
	public Raptor() {
		System.out.print("r2 ");
	}
	{
		System.out.print("r3 ");
	}
	static  {
		System.out.print("r4 ");
	}
	
}
public class Hawk extends Raptor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("pre ");
		new Hawk();
		System.out.println("hawk ");

	}

}
class Bird {
	{
		System.out.print("b1 ");
	}

	public Bird() {
		System.out.print("b2 ");
	}
	
	static  {
		System.out.print("b3 ");
	}
}

