package com.ib.revnum;

import java.util.Scanner;

public class ReverseNumber3 {

	public static void main(String[] args) {
		System.out.println("Enter Number:");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.print("reverse num= ");
		System.out.println(revnum(num));
		sc.close();
	}
	static int rev = 0;
	static int revnum(int num)
	{
		if(num==0)	return rev;
		else
		{
			int rem = num % 10;
			rev = rev * 10 + rem;
			revnum(num/10);
		}
		return rev;
	}

}
