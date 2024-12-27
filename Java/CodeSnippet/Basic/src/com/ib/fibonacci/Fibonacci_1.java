package com.ib.fibonacci;

import java.util.Scanner;

public class Fibonacci_1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("How Many Terms Do you Want For Fibonacci Series:-");
		int n = sc.nextInt();
		sc.close();

		int a = 0, b = 1, c, i, count = n;
		System.out.print(a + " " + b);
		for (i = 2; i < count; ++i) {
			c = a + b;
			System.out.print(" " + c);
			a = b;
			b = c;
		}
	}
}
