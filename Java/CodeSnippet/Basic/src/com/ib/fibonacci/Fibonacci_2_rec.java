package com.ib.fibonacci;

import java.util.Scanner;

public class Fibonacci_2_rec {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("How Many Terms Do you Want For Fibonacci Series:-");
		int n = sc.nextInt();
		sc.close();
		System.out.print(a+" "+b);
		Fibonacci(n-2);
	}

	static int a=0,b=1,c=0;    
	 static void Fibonacci(int n){    
	    if(n>0){    
	         c = a + b;    
	         a = b;    
	         b = c;    
	         System.out.print(" "+c);   
	         Fibonacci(n-1);    
	     }    
	 }

}
