package com.ib.elementfreq;

import java.util.HashMap;
import java.util.Map;

public class ElementFrequencyVar1 {
	public static void main(String[] args) {
		int[] array = new int[] { 1, 1, 8, 5, 6, 8, 8, 5, 1, 6 };
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int element : array) {
			int count = linearSearchCount(array, element);
			if (count >= 3) {
				map.put(element, count);
			}
		}
		System.out.println("Only elements with 3 or more occurrences are shown.\n");
		System.out.println("Element --- Count");

		for (Map.Entry<Integer, Integer> obj : map.entrySet()) {
			System.out.println(obj.getKey() + "       ---        " + obj.getValue());
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