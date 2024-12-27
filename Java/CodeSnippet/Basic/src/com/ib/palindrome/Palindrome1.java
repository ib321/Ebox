package com.ib.palindrome;

public class Palindrome1 {
	public static boolean isPalindrome(int number) {
		int originalNumber = number;
		int reversedNumber = 0;

		while (number > 0) {
			int remainder = number % 10;
			reversedNumber = reversedNumber * 10 + remainder;
			number /= 10;
		}

		return originalNumber == reversedNumber;
	}

	public static void main(String[] args) {
		int number = 12321;
		System.out.println(isPalindrome(number) ? number + " is a palindrome number." : number + " is not a palindrome number.");
	}
}
