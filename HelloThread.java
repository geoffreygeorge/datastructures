package com.example.helloworld;

public class HelloThread extends Thread{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		(new HelloThread()).start();
	}
	
	public void run(){
		System.out.println("Hello from thread");
	}

}
