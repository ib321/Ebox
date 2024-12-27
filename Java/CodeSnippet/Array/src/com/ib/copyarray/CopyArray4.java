package com.ib.copyarray;

public class CopyArray4 {

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3, 4, 5 };
		int[] array2 = new int[5];

		// Fourth method using Arrays iteration
		int j=0;
		for (int i : array1) {
			array2[j++]=i;
		}
		System.out.println("\n" + (array1 == array2));
		CopyArray1.printArray(array2);
	}
}