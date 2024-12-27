package com.ib.revnum;

import java.util.Scanner;

public class ReverseNumbervar1 {

	public static void main(String[] args) {
		System.out.println("Enter Number:");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println("Enter reversed number: ");
		int revnum = sc.nextInt();
		int rem, rev = 0;
		while (num != 0) {
			rem = num % 10;
			rev = rev * 10 + rem;
			num = num / 10;
		}
		
		if(revnum==rev)
		{
			System.out.println("Both are equal so printing the reverse number:"+rev);
			System.out.println("reverse num= " + rev);
		}
		sc.close();
	}

}
