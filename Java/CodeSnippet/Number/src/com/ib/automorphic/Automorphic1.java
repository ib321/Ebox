package com.ib.automorphic;

public class Automorphic1 {

	static boolean isAutomorphic(int num) {
		int square = num * num;
		System.out.println(num+" "+square);
		while (num > 0) {
			if (num % 10 != square % 10)
				return false;
			num = num / 10;
			square = square / 10;
		}
		return true;

	}

	public static void main(String[] args) {
		int num = 76;
		System.out.println(isAutomorphic(num) ? num + " is Automorphic " : num + " is Not Automorphic ");
	}

}
