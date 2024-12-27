package com.ib.copyarray;

import java.util.Arrays;

public class CopyArray3 {

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3, 4, 5 };
		int[] array2 = new int[5];

		// Third method using Arrays.copyOf
		array2 = Arrays.copyOf(array1, array1.length);
		CopyArray1.printArray(array2);
		System.out.println(array2.length);
		System.out.println("\n" + (array1 == array2));
	}
}
