package com.ib.linearsearch;

public class LinearSearchvar1Count {

	public static int linearSearchCount(int[] array, int key) {
	    int count = 0;
	    for (int i = 0; i < array.length; i++) {
	        if (array[i] == key) {
	            count++;
	        }
	    }
	    return count;
	}

	public static void main(String[] args) {
		int[] array= {10,20,20,50,70,90};    
        int key = 20;
        int count= linearSearchCount(array, key);
        System.out.println(count!=0 ? (key+" is found and total count is : "+count): key+" Key Not Found");
	}
}
