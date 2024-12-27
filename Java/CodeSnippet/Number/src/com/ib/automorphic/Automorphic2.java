package com.ib.automorphic;

public class Automorphic2 {

	public static void main(String[] args) {
		Integer num = 625;
		int square = num * num;
		int lastDigit = (int) (square%(Math.pow(10, Integer.toString(num).length())));
		System.out.println(num == lastDigit? num + " is Automorphic " : num + " is Not Automorphic ");
	}
}
