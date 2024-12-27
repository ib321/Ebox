package com.ib.fibonacci;

import java.util.Scanner;

public class Fibonacci_Var1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("How Many Terms Do you Want For Fibonacci Series:-");
		int n = sc.nextInt();
		int a = 0, b = 1, c;
		for (int i = 0; i < n; i++) {
			if (i <= 1)
				c = i;
			else {
				c = a + b;
				a = b;
				b = c;
			}
			System.out.print(c+" ");
		}
		sc.close();

	}

}
