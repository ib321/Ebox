package com.ib.linearsearch;

public class LinearSearch1 {

	public static int linearSearch(int[] array, int key){    
        for(int i=0;i<array.length;i++){    
            if(array[i] == key){    
                return i;    
            }    
        }    
        return -1;    
    }
	public static void main(String[] args) {
		int[] array= {10,20,30,50,70,90};    
        int key = 50;
        System.out.println(key+" is found at index: "+linearSearch(array, key)); 
	}

}
