package com.ib.copyarray;

public class CopyArrayVar1 {

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3, 4, 5 };
		int[] array2 = new int[5];
		int avg=5,sum=0;

		for (int i : array1) {
			sum+=i;
		}
		if(sum/array1.length==avg)
		{
			System.out.println("Average Given is same as array average\nCopying the element....");
			int j=0;
			for (int i : array1) {
				array2[j++]=i;
			}
			System.out.println("Printing array....");
			System.out.println("\n" + (array1 == array2));
			CopyArray1.printArray(array2);
		}
		else
		{
			System.out.println("array will not be copied... As Given Average is not equal to array average");
		}
		
		
	}
}