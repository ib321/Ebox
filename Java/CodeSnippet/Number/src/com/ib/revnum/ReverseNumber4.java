package com.ib.revnum;

import java.util.Scanner;

public class ReverseNumber4 {

	public static void main(String[] args) {
		System.out.println("Enter Number:");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.print("reverse num= ");
		revnum(num);
		sc.close();
	}

	static void revnum(int num)
	{
	        if (num < 10) {
	            System.out.println(num);
	            return;
	        } else {
	            System.out.print(num % 10);
	            revnum(num / 10);
	        }
	}

}
