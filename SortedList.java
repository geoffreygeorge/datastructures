package com.example.helloworld;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a list with an ordered list of items
		List sortedList = new LinkedList();
		sortedList.addAll(Arrays.asList(new String[]{"ant", "bat", "cat", "dog"}));

		// Search for the non-existent item
		int index = Collections.binarySearch(sortedList, "cow");      // -4

		// Add the non-existent item to the list
		if (index < 0) {
		    sortedList.add(-index-1, "cow");
		}
		System.out.println(sortedList);
	}

}
