package com.example.helloworld;

public class Person {
	String name;

	// Person constructor
	public Person(String _name)
	// Post: An instance of Person is initialized.
	{
		// Set the name of this Person object to the name passed into the constructor.
		name = _name;
	}

	public String getName()
	// Post: The name of this person is returned.
	{
		return name;
	}
} // End of Person class
