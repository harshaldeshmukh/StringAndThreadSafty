package com.demo;

public class StringHandling implements Runnable {
	
	private String s;
	

	public StringHandling(String name) {
		super();
		this.s = name;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("in run method " + Thread.currentThread().getName());

		try {
			// introducing some delay
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Adding to String
		s = s + Thread.currentThread().getName();
		System.out.println("String " + s);
		
	}
	

	public static void main(String[] args) {
		System.out.println("String Handling");
		
		String str = "abc";
		
	
		
		
		Thread t1 = new Thread(new StringHandling(str));
		Thread t2 = new Thread(new StringHandling(str));
		Thread t3 = new Thread(new StringHandling(str));
		t1.start();
		t2.start();
		t3.start();
		// Waiting for all of them to finish
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("String is " + str.toString());
	}

}
