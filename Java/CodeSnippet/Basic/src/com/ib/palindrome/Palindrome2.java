package com.ib.palindrome;

public class Palindrome2 {
    public static boolean isPalindrome(int number) {
        String numberString = String.valueOf(number);
        String reversedNumberString = new StringBuilder(numberString).reverse().toString();
        return numberString.equals(reversedNumberString);
    }

    public static void main(String[] args) {
        int number = 12321;
		System.out.println(isPalindrome(number) ? number + " is a palindrome number." : number + " is not a palindrome number.");
    }
}
