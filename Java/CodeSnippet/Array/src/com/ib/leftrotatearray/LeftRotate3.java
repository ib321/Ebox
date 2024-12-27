package com.ib.leftrotatearray;


public class LeftRotate3 {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int shifts = 2;
		System.out.println("Original Array: ");
		for (int i : array) {
		    System.out.print(i + " ");
		}

		int[] temp = new int[array.length];
		for (int i = 0; i < array.length; i++) {
		    int newIndex = (i - shifts + array.length) % array.length;
		    temp[newIndex] = array[i];
		}
		array = temp;
		System.out.println();
		System.out.println("Shifted Array: ");
		for (int i : array) {
		    System.out.print(i + " ");
		}
	}

}
