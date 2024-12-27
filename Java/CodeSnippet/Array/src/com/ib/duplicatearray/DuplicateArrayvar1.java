package com.ib.duplicatearray;

public class DuplicateArrayvar1 {  
public static void main(String[] args) {
		int value=3;
        int [] arr = new int [] {1, 2, 3, 4, 2, 7, 8, 8, 3};  
        System.out.println("Duplicate elements in given array: ");  
        for(int i = 0; i < arr.length; i++) {  
            for(int j = i + 1; j < arr.length; j++) {  
                if(arr[i] == arr[j])
                	if(arr[j]>value)
                	{
                    System.out.println(arr[j]);  
                	}
            }  
        }  
    }  
}
