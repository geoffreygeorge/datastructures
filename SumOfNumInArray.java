package com.example.helloworld;

import java.util.HashSet;
import java.util.Set;

public class SumOfNumInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] i = {31, -41, 59, 26, -53, 58, 97, -93, -23, 84};
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

}
