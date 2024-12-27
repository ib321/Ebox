package com.ib.countchar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountCharVar1 {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter Any Sentence...or press enter..\nDefault sentence:- Hello World! This is New World");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		if (str.isEmpty())
			str = "Hello World! This is New World";
		int counter[] = new int[256];
		int len=str.length();
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) != ' ')
		    counter[(int) str.charAt(i)]++;
		}

		for (int i = 0; i < 256; i++) {
		    if (counter[i] != 0) {
		        System.out.println((char) i + ": " + counter[i]);
		    }
		}
		br.close();
	}

}
