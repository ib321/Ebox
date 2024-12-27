package com.ib.linearsearch;

public class LinearSearch2 {

	public static int linearSearchLast(int[] array, int key) {
	    for (int i = array.length - 1; i >= 0; i--) {
	        if (array[i] == key) {
	            return i;
	        }
	    }
	    return -1;
	}
	public static void main(String[] args) {
		int[] array= {10,20,30,50,70,90};    
        int key = 50;
        System.out.println(key+" is found at index: "+linearSearchLast(array, key)); 
	}

}
