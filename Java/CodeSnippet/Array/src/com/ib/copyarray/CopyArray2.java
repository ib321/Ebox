package com.ib.copyarray;

public class CopyArray2 {

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3, 4, 5 };
		int[] array2 = new int[5];

		// Second method using System.arraycopy
		System.arraycopy(array1, 0, array2, 0, 5);
		CopyArray1.printArray(array2);
		System.out.println("\n" + (array1 == array2));
	}
}
