package com.ib.elementfreq;

import java.util.HashMap;
import java.util.Map;

public class ElementFrequency2 {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 1, 8, 5, 6, 8, 8, 5, 1, 6 };
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int element : array) {
			map.compute(element, (key, value) -> (value == null) ? 1 : value + 1);
		}
		System.out.println("Element --- Count");
		for (Map.Entry<Integer, Integer> obj : map.entrySet()) {
			System.out.println(obj.getKey() + "       ---        " + obj.getValue());
		}
	}

}
