package com.ib.countpunctuation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountPunctuation2 {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter Any Sentence...or press enter..\nDefault sentence:- Hello world!,  'This is New World.' is it? yes. It is;");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		if (string.isEmpty())
			string = "Hello world!, 'This is New World.' is it? yes. It is;";
		int count = 0;
		char[] splitstr = string.toCharArray();
		for (char c : splitstr) {
			boolean flag= (c == '!' || c == '.'|| c == '\'' || c == '\"' || c == '-' || c == ',' || c == ':' || c == ';' || c == '?');
			if (flag)
				++count;
		}
		System.out.println("Total Punctuation in given Sentence:- " + count);
		br.close();


	}

}
