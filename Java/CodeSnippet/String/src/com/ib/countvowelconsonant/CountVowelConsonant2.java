package com.ib.countvowelconsonant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountVowelConsonant2 {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter Any Sentence...or press enter..\nDefault sentence:- Hello World! This is New World");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		if (string.isEmpty())
			string = "Hello World! This is New World";

		int vowels = 0, consonants = 0;
		string = string.toLowerCase();
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c >= 'a' && c <= 'z') {
				switch (c) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					++vowels;
					break;
				default:
					++consonants;
				}
			}
		}
		System.out.println("Number of vowels: " + vowels);
		System.out.println("Number of consonants: " + consonants);
	}
}