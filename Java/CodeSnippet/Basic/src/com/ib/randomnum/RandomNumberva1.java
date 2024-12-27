package com.ib.randomnum;

import java.util.Random;
import java.util.Scanner;

public class RandomNumberva1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Generate random integer");
        System.out.println("2. Generate random float");
        System.out.println("3. Generate random double");
        System.out.println("4. Generate random long");
        System.out.println("5. Generate random boolean");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        Random random = new Random();

        switch (choice) {
            case 1:
                int randomInt = random.nextInt();
                System.out.println("Random integer: " + randomInt);
                break;
            case 2:
                float randomFloat = random.nextFloat();
                System.out.println("Random float: " + randomFloat);
                break;
            case 3:
                double randomDouble = random.nextDouble();
                System.out.println("Random double: " + randomDouble);
                break;
            case 4:
                long randomLong = random.nextLong();
                System.out.println("Random long: " + randomLong);
                break;
            case 5:
                boolean randomBoolean = random.nextBoolean();
                System.out.println("Random boolean: " + randomBoolean);
                break;
            default:
                System.out.println("Invalid choice.");
        }

        sc.close();
    }
}

