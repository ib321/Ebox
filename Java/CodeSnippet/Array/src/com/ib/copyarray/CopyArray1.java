package com.ib.copyarray;

public class CopyArray1 {

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3, 4, 5 };
		int[] array2 = new int[5];
		
		//First method using clone
		array2 = array1.clone();
		printArray(array2);
		System.out.println("\n" + (array1 == array2));
	}

	public static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
