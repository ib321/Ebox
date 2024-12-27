package com.ib.factorial;

public class Factorial1 {
	public static int factorialIterative(int n) {
		if (n < 0) {
			System.out.println("Factorial of Negative number is undefined.");
			System.exit(0);
		}
		int factorial = 1;
		for (int i = 1; i <= n; i++) {
			factorial *= i;
		}
		return factorial;
	}

	public static void main(String[] args) {
		int n = -1;
		int factorial = factorialIterative(n);
		System.out.println("Factorial of " + n + " is: " + factorial);
	}
}
