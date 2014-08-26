package com.example.helloworld;

import java.util.Arrays;

public class MyList<E> {
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	private Object elements[];
	
	public MyList() {
		elements = new Object[DEFAULT_CAPACITY];
	}

	public void add(E e) {
		if (size == elements.length) {
			ensureCapa();
		}
		elements[size++] = e;
	}
 

	private void ensureCapa() {
		int newSize = elements.length * 2;
		elements = Arrays.copyOf(elements, newSize);
	}

	@SuppressWarnings("unchecked")
	public E get(int i) {
		if (i>= elements.length) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
		}
		return (E) elements[i];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyList<Integer> list = new MyList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(4);
		System.out.println(list.get(4));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		
		list.get(100);
	}

}
