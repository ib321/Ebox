package com.ib.anagram;

import java.util.Arrays;

public class Anagram1 {
	public static void main(String[] args) {
		String str1 = "TBean";
		String str2 = "BTean";

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		if (str1.length() != str2.length()) {
			System.out.println("Length not equal strings are not anagram");
		} else {
			char[] string1 = str1.toCharArray();
			char[] string2 = str2.toCharArray();
			Arrays.sort(string1);
			Arrays.sort(string2);

			if (Arrays.equals(string1, string2) == true) {
				System.out.println("Both the strings are anagram");
			} else {
				System.out.println("Both the strings are not anagram");
			}
		}
	}
}
