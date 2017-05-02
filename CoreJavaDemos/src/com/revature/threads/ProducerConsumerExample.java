package com.revature.threads;

public class ProducerConsumerExample {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		Basket b = new Basket();
		Runnable producerJob = new Producer(b);
		Runnable consumerJob = new Consumer(b);
		Thread producerWorker = new Thread(producerJob, "PRODUCER");
		Thread consumerWorker = new Thread(consumerJob, "CONSUMER");
		producerWorker.start();
		consumerWorker.start();
	}
}

class Basket {
	private int contents;
	private boolean available = false;

	public synchronized int get() {
		while (available == false) {
			try {
				System.out.println("\t\t\t" + Thread.currentThread().getName() + " called waiting");
				wait();
			} catch (InterruptedException e) {
			}
		}
		available = false;
		notifyAll();
		return contents;
	}

	public synchronized void put(int value) {
		while (available == true) {
			try {
				System.out.println("\t\t\t" + Thread.currentThread().getName() + " called waiting");
				wait();
			} catch (InterruptedException e) {
			}
		}
		contents = value;
		available = true;
		notifyAll();
	}
}

class Consumer implements Runnable {
	private Basket basket;

	public Consumer(Basket b) {
		basket = b;
	}

	public void run() {
		int value = 0;
		for (int i = 0; i < 10; i++) {
			value = basket.get();
			System.out.println(Thread.currentThread().getName() + " got: " + value);
		}
	}
}

class Producer implements Runnable {
	private Basket basket;

	public Producer(Basket b) {
		this.basket = b;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			basket.put(i);
			System.out.println(Thread.currentThread().getName() + " put: " + i);
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
		}
	}
}
