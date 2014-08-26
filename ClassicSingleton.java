package com.example.helloworld;

public class ClassicSingleton {
	private static ClassicSingleton instance = null;

	protected ClassicSingleton() {
		// Exists only to defeat instantiation.
	}

	public static ClassicSingleton getInstance() {
		if (instance == null) {
			synchronized(ClassicSingleton.class) { 
				instance = new ClassicSingleton();
			}
		}
		return instance;
	}
}