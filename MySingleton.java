package com.example.helloworld;

public class MySingleton {

	private static MySingleton _instance;
	
	private MySingleton() { 
		  // construct object . . . 
	}
	
	public static synchronized MySingleton getInstance(){
		if (_instance==null) { 
			_instance = new MySingleton(); 
		} 
		return _instance; 
	}
}
