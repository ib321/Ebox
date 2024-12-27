package com.ib.prime;

public class PrimeNumber1 {
	public static void main(String args[]) {
		int flag = 0;
		int num = 4;

		if (num == 0 || num == 1) {
			System.out.println(num + " is not prime number");
		} else {
			for (int i = 2; i <= num / 2; i++) {
				if (num % i == 0) {
					flag = 1;
					break;
				}
			}
			System.out.println(flag == 1 ? num + " is not prime number" : num + " is prime number");
		}
	}
}
