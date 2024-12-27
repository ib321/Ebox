package com.ib.int2string;

public class IntToString_1_2_3 {

	public static void main(String[] args) {
		System.out.println("Starting....");
		int int1 = 112;
		IntToString_1(int1);
		int int2 = 224;
		IntToString_2(int2);
		int int3 = 555;
		IntToString_3(int3);

	}

	public static void IntToString_1(int int1) {
		String str = Integer.toString(int1);
		Object obj = str;
		System.out.println(
				"Output using first method: " + str + " \nPrinting Class name of output String: " + obj.getClass());
	}

	public static void IntToString_2(int int2) {
		String str = String.valueOf(int2);
		Object obj = str;
		System.out.println(
				"Output using 2nd method: " + str + " \nPrinting Class name of output String: " + obj.getClass());
	}

	public static void IntToString_3(int int3) {
		String str = String.format("%d",int3);
		Object obj = str;
		System.out.println(
				"Output using 3rd method: " + str + " \nPrinting Class name of output String: " + obj.getClass());
	}

}
