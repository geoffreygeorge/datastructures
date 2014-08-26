package com.example.helloworld;

public class HelloRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hello from thread");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		(new Thread(new HelloRunnable())).start();
	}

}
