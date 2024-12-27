package com.ib.leftrotatearray;

import java.util.Arrays;
import java.util.Collections;

public class LeftRotate2 {

	public static void main(String[] args) {
		Integer[] array = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };
		int shifts = 1;
		System.out.println("Original Array: ");
		for (int i : array) {
		    System.out.print(i + " ");
		}

		Collections.rotate(Arrays.asList(array), -shifts);

		System.out.println();
		System.out.println("Shifted Array: ");
		for (int i : array) {
		    System.out.print(i + " ");
		}
	}

}
