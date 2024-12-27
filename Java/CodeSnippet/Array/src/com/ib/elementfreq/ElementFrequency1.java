package com.ib.elementfreq;

import java.util.HashMap;
import java.util.Map;

public class ElementFrequency1 {

	public static void main(String[] args) {
		int [] array = new int [] {1, 1, 8, 5, 6, 8, 8, 5, 1, 6};
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for (int i : array) {
			map.put(i, linearSearchCount(array,i));
		}
		System.out.println("Element --- Count");
		//Set<Map.Entry<Integer, Integer>> set=map.entrySet();
		for (Map.Entry<Integer, Integer> obj : map.entrySet()) {
			System.out.println(obj.getKey()+"       ---        "+obj.getValue());
		}
		
	}
	
	public static int linearSearchCount(int[] array, int key) {
	    int count = 0;
	    for (int i = 0; i < array.length; i++) {
	        if (array[i] == key) {
	            count++;
	        }
	    }
	    return count;
	}

}
