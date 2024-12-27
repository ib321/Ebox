package com.ib.armstrong;

import java.util.Scanner;

public class Armstrong1_2_3_Var {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Check Armstrong");
        System.out.println("2. Find Armstrong in a range");
        System.out.println("3. check twisted armstrong");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("Enter a number to check: ");
            int number = sc.nextInt();
            System.out.println(checkArmstrong(number) ? number + " is an armstrong number" : number + " is Not an armstrong number");
        } else if (choice == 2) {
            System.out.println("Enter the range to find Armstrong numbers:");
            System.out.print("Start: ");
            int start = sc.nextInt();
            System.out.print("End: ");
            int end = sc.nextInt();

            System.out.println("Armstrong numbers in the range " + start + " to " + end + " are:");
            findArmstrongInRange(start, end);
        }
        
        else if(choice == 3){
        	
        	System.out.println("Enter a number to check twisted armstrong:");
        	 int number = sc.nextInt();
             System.out.println(checkTwistedArmstrong(number) ? number + " is an twisted armstrong number" : number + " is Not an twisted armstrong number");
        	
        }
        else {
            System.out.println("Invalid choice.");
        }

        sc.close();
    }

	public static boolean checkArmstrong(int num) {
		int sum = 0, temp = num;
		int len = Integer.toString(num).length();
		while (num != 0) {
			int rem = num % 10;
			sum += Math.pow(rem, len);
			num = num / 10;
		}
		return sum==temp;
	}
	
	public static void findArmstrongInRange(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (checkArmstrong(i)) {
                System.out.println(i);
            }
        }
    }
	//if number 153 then 1^1 + 5^2 + 3^3 is equal to 153 or not
	public static boolean checkTwistedArmstrong(int number) {
	    int originalNumber = number;
	    int sum = 0;
	    int length = String.valueOf(number).length();
	    
	    while (number != 0) {
	        int digit = number % 10;
	        sum += Math.pow(digit, length--);
	        number /= 10;
	    }
	    
	    return originalNumber == sum;
	}


}

