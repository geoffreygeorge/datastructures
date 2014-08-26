package com.example.helloworld;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyMap<K, V> {
	private int size;
	private int DEFAULT_CAPACITY = 16;
	@SuppressWarnings("unchecked")
	private MyEntry<K, V>[] values = new MyEntry[DEFAULT_CAPACITY];


	public V get(K key) {
		for (int i = 0; i < size; i++) {
			if (values[i] != null) {
				if (values[i].getKey().equals(key)) {
					return values[i].getValue();
				}
			}
		}
		return null;
	}

	public void put(K key, V value) {
		boolean insert = true;
		for (int i = 0; i < size; i++) {
			if (values[i].getKey().equals(key)) {
				values[i].setValue(value);
				insert = false;
			}
		}
		if (insert) {
			ensureCapa();
			values[size++] = new MyEntry<K, V>(key, value);
		}
	}

	private void ensureCapa() {
		if (size == values.length) {
			int newSize = values.length * 2;
			values = Arrays.copyOf(values, newSize);
		}
	}

	public int size() {
		return size;
	}

	public void remove(K key) {
		for (int i = 0; i < size; i++) {
			if (values[i].getKey().equals(key)) {
				values[i] = null;
				size--;
				condenseArray(i);
			}
		}
	}

	private void condenseArray(int start) {
		for (int i = start; i < size; i++) {
			values[i] = values[i + 1];
		}
	}

	public Set<K> keySet() {
		Set<K> set = new HashSet<K>();
		for (int i = 0; i < size; i++) {
			set.add(values[i].getKey());
		}
		return set;
	}
	
	public static void main(String[] args){
		// MyMap
		MyMap<String, Integer> map = new MyMap<String, Integer>();
		map.put("Lars", 1);
		map.put("Lars", 2);
		map.put("Lars", 1);
		log(map.get("Lars"));
		for (int i = 0; i < 100; i++) {
			map.put(String.valueOf(i), i);
		}
		log(map.size());
		log(map.get("51"));
	}

	private static void log(Object obj) {
		// TODO Auto-generated method stub
		System.out.println(obj);
	}
}
