package com.ib.factorial;

public class Factorial2 {
    public static int factorialRecursive(int n) {
    	if (n < 0) {
			System.out.println("Factorial of Negative number is undefined.");
			System.exit(0);
		}
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorialRecursive(n - 1);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int factorial = factorialRecursive(n);
        System.out.println("Factorial of " + n + " is: " + factorial);
    }
}

