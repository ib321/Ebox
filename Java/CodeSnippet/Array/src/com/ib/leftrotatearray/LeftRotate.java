package com.ib.leftrotatearray;

public class LeftRotate {

	public static void main(String[] args) {
		int[] Array = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int shifts = 2;
		System.out.println("Original Array: ");
		for (int i : Array) {
			System.out.print(i + " ");
		}

		for (int i = 0; i < shifts; i++) {
			int first = Array[0];
			int j;
			for (j = 0; j < Array.length - 1; j++) {
				Array[j] = Array[j + 1];
			}
		Array[j] = first;
		}
		System.out.println();
		System.out.println("Shifted Array: ");
		for (int i : Array) {
			System.out.print(i + " ");
		}
	}

}
