package com.ib.revnum;

import java.util.Scanner;

public class ReverseNumber1 {

	public static void main(String[] args) {
		System.out.println("Enter Number:");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int rem, rev = 0;
		while (num != 0) {
			rem = num % 10;
			rev = rev * 10 + rem;
			num = num / 10;
		}
		System.out.println("reverse num= " + rev);
		sc.close();
	}

}
