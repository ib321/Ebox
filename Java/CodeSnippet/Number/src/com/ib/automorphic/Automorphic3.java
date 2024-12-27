package com.ib.automorphic;

public class Automorphic3 {

	public static void main(String[] args) {
		Integer num = 625;
		int square = num * num;
		int temp = num, count = 0;
		while (temp > 0) {
			count++;
			temp = temp / 10;
		}
		int lastDigit = (int) (square % (Math.pow(10, count)));
		System.out.println(num == lastDigit ? num + " is Automorphic " : num + " is Not Automorphic ");
	}
}
