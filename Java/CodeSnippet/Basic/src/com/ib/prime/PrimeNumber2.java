package com.ib.prime;

public class PrimeNumber2 {
	public static void main(String args[]) {

		int num = 4;
		System.out.println(!isPrime(num) ? num + " is not prime number" : num + " is prime number");
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
