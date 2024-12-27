package com.ib.linearsearch;

public class LinearSearchvar2 {

	public static int linearSearchFirstGreaterEqual(int[] array, int key, int value) {
	    for (int i = 0; i < array.length; i++) {
	        if (array[i] == key && array[i] >= value) {
	            return i;
	        }
	    }
	    return -1;
	}


	public static void main(String[] args) {
		int[] array= {10,20,30,50,70,90};    
        int key = 70;
        int value=20;
        int output= linearSearchFirstGreaterEqual(array, key, value);
        System.out.println(output!=(-1) ? (key+" is found and is greater than "+value+" it's index is : "+output): key+" Key Not Found or it is less than "+value);
	}

}
