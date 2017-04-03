package com.revature.threads;

public class SimpleThreadExample {

	public static void main(String[] args) {
		
		MyRunnableThing job = new MyRunnableThing();
		
		Thread worker= new Thread(job);
		worker.start();
		for(int i=0;i<50;i++){
			System.out.println("main");
		}

	}

}

class MyRunnableThing implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<50;i++){
			System.out.println("runnableThing");
		}
		
	}
	
}
