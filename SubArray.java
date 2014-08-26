package com.example.helloworld;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i = {31, -41, 59, 26, -53, 58, 97, -93, -23, 84};
		subArrayWithLargestSumNew(i);
		int sum = -146;
		int j = sumOfNumInArray(i, sum);
		System.out.println("Sum of " + j + " and " + (sum-j) + " = " + sum);
		System.exit(0);
	}

	private static int sumOfNumInArray(int[] array, int sum) {
		Set<Integer> check = new HashSet<Integer>();
		for (int i: array) {
			if (check.contains(new Integer(sum - i))){
				return i;
			}
			check.add(new Integer(i));
		}
		return -1;
	}

	private static int subArrayWithLargestSumNew(int[] array) {
		int maxSoFar = 0;
		int maxUpToHere = 0;
		
		for (int i: array) {
			maxUpToHere = Math.max(maxUpToHere + i, 0);
	        maxSoFar = Math.max(maxSoFar, maxUpToHere);
	        System.out.println("i : " + i + " maxUptoHere : " + maxUpToHere + " maxSoFar : " + maxSoFar);
		}
	    return maxSoFar;

	}

	public static Integer[] subArrayWithLargestSum(int[] array) {
		List intList = new ArrayList();

		if (array.length > 0) {
			// first check to see if we get all positive number sub-array
			for (int i: array) {
				if (i > 0) intList.add(i);
			}

			// check to see if it has any ZERO number
			if (intList.size() == 0) {
				for (Integer i: array) {
					if (i == 0) {
						intList.add(0);
						break;
					}
				}
			}

			// means all are negative values
			if (intList.size() == 0) {
				Integer max = array[0];
				for (Integer i: array) {
					if (i >= max) {
						intList.remove(max);
						intList.add(i);
						max = i;
					}
				}
			}

		}

		return null; //intList.toArray(new Integer[0]);
	}
}
