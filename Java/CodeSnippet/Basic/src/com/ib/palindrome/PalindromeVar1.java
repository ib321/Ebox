package com.ib.palindrome;

public class PalindromeVar1 {
	public static boolean isPalindromeWithEvenDigits(int number) {
		String numberString = String.valueOf(number);
		int numDigits = numberString.length();
		if (numDigits % 2 != 0) {
			return false;
		}

		String firstHalf = numberString.substring(0, numDigits / 2);
		String secondHalf = numberString.substring(numDigits / 2);
		String reversedSecondHalf = new StringBuilder(secondHalf).reverse().toString();

		return firstHalf.equals(reversedSecondHalf);
	}

	public static void main(String[] args) {
		int number = 124321;
		System.out
				.println(isPalindromeWithEvenDigits(number) ? number + " is a palindrome with an even number of digits."
						: number + " is not a palindrome with an even number of digits.");
	}
}
