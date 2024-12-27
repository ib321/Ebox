package com.ib.factorial;

public class FactorialVar1_SumOfFact {
	public static boolean checkSumOfFactorial(int number) {
	    int originalNumber = number;
	    int sum = 0;
	    
	    while (number != 0) {
	        int digit = number % 10;
	        sum += factorial(digit);
	        number /= 10;
	    }
	    
	    return originalNumber == sum;
	}

	public static int factorial(int n) {
	    if (n == 0 || n == 1) {
	        return 1;
	    }
	    
	    int result = 1;
	    for (int i = 2; i <= n; i++) {
	        result *= i;
	    }
	    
	    return result;
	}


	public static void main(String[] args) {
		int n = 151;
		System.out.println("Enter the number/n Lets check if sum of factorial of each digit is equal to number or not!");
		boolean flag = checkSumOfFactorial(n);
		System.out.println(flag?"Great you found it they are both equal":"Sorry it is not equal");
		System.out.println("Below Are those magic numbers:");
		for(int i=0;i<10000;i++)
		{
			if(checkSumOfFactorial(i))
			{
				System.out.println(i);
			}
		}
	}
}
