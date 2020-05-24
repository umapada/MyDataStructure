package com.array;
/*
Array Pair Sum Divisibility Problem
Given an array of integers and a number k, write a function that returns true if given array can be divided into pairs
such that sum of every pair is divisible by k.
 */

public class CheckPairsDivisibleByK
{

    public static void main(String[] args)
    {
        boolean isPairs = checkPairs (new int []{12, 30, 20, 22}, 6);
        System.out.println(isPairs);
    }

    static boolean checkPairs(int nums[], int k)
    {
        // Debug prints
        System.out.println("k = " + k);
        printArray (nums, "input  ");

        // initialize counts of modulus
        int modulusCounts[] = new int[k];

        // For each number in the array, calculate
        // modulus and update relevant count
        for (int num: nums)
            modulusCounts[num %k]++;

        printArray (modulusCounts, "modulus");


        if (modulusCounts[0] % 2 != 0) // As these will not form pair with anyone else
            return false;

        if (k % 2 == 0) {
            if (modulusCounts[k/2] %2 != 0) // These will also not form pair with anyone else
                return false;
        }

        printArray (modulusCounts, "modulus");

        for (int i = 1; i <= k/2; i++)
            if (modulusCounts[i] != modulusCounts[k-i])
                return false;


        return true;
    }


    static void printArray (int arr[], String msg)
    {
        System.out.print (msg+": ");
        for (int i : arr)
            System.out.print (i + ", ");
        System.out.println();
    }
}