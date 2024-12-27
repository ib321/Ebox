package com.ib.countchar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountChar3 {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter Any Sentence...or press enter..\nDefault sentence:- Hello World! This is New World");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		if (string.isEmpty())
			string = "Hello World! This is New World";

		int count = 0;
		String[] splitstr=string.split(" ");
		string="";
		for (String string2 : splitstr) {
			string=string+string2;
		}
		count=string.length();
		System.out.println("Total character in given Sentence:- "+count);
		br.close();
	}

}
