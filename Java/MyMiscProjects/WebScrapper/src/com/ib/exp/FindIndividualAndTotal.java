package com.ib.exp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class FindIndividualAndTotal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter Value: ");
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader("C:\\Aarambh\\Work_Space\\Test-02\\test\\new.txt"));
		String line = br.readLine();
		while (line != null) {
			String[] split = line.split("-");
			list.add(split[0]);
			list2.add(split[1]);
			line = br.readLine();
		}
		int sum = 0;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			sum += Integer.parseInt(string.strip());
			System.out.println(string);
		}
		System.out.println("Total: " + sum);
		System.out.println("---------------------------------------------");
		for (Iterator iterator = list2.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}

	}

}

/** Data being used for this process
55 -1
70 -2
60 -3
120 -3 hair
30 -5
50 -5 s2
70 -6
7806 - 6-Rent
250 -6 - Scc
55 - 7
30 - 8
90 - 8- wax
15 - 10
32- 11
30 -12
70 -13
220 -14 ofc
30-15
15-15
40 -15
70 -16
50 -17
38 -19
50 -20
479 -21 recharge
20-21
55 -21
60 -22
70 -24
22 -25
30 -26
95 -27
65-28
182-29 ofc
*/