package com.ib.prime;

public class PrimeNumberVar1 {
	public static void main(String args[]) {

		//System.out.print("first number : ");
		int start = 0;
		//System.out.print("second number : ");
		int end = 100;
		System.out.println("List of prime numbers between " + start + " and " + end+": ");
		for (int i = start; i <= end; i++) {
			if (isPrime(i)) {
				System.out.print(i+",  ");
			}
		}
	}

	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
