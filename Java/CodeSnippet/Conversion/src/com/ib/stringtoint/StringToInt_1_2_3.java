package com.ib.stringtoint;

public class StringToInt_1_2_3 {

	public static void main(String[] args) {
		System.out.println("Starting....");
		System.out.println("First Integer static method parseInt() :- ");
		String str1 = "112";
		StringToInt_1(str1);
		String str2 = "224";
		StringToInt_2(str2);
		String str = "String";
		StringToInt_3(str);

	}

	public static void StringToInt_1(String str) {
		int num = Integer.parseInt(str);
		Object obj = num;
		System.out.println(
				"Output using first method: " + num + " \nPrinting Class name of output int: " + obj.getClass());
	}

	public static void StringToInt_2(String str) {
		int num = Integer.valueOf(str);
		Object obj = num;
		System.out.println(
				"Output using second method: " + num + " \nPrinting Class name of output int: " + obj.getClass());

	}

	public static void StringToInt_3(String str) {
		System.out.println("Exception occurs when we pass other than int value to parseInt or valueOF method:-");
		int num = Integer.parseInt(str);
		System.out.println(num);
	}

}
