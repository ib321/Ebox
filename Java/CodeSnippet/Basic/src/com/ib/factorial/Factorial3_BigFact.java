package com.ib.factorial;

import java.math.BigInteger;

public class Factorial3_BigFact {
    public static BigInteger factorialBigInteger(int n) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    public static void main(String[] args) {
        int n = 100;
        BigInteger factorial = factorialBigInteger(n);
        System.out.println("Factorial of " + n + " is: " + factorial);
    }
}


