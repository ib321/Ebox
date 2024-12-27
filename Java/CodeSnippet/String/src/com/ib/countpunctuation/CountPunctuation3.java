package com.ib.countpunctuation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountPunctuation3 {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter Any Sentence...or press enter..\nDefault sentence:- Hello world!,  'This is New World.' is it? yes. It is;");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		if (string.isEmpty())
			string = "Hello world!, 'This is New World.' is it? yes. It is;";
		int count = 0;
		String punctuations = "!.'\"-,;:?";
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            //System.out.println(punctuations.indexOf(c));
            if (punctuations.indexOf(c) != -1)
                ++count;
        }
		System.out.println("Total Punctuation in given Sentence:- " + count);
		br.close();


	}

}