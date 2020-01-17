package com.test.ds1;
/*
Given an unsorted array, write a function that checks if all the numbers in that
array form pairs divisible by k

----------
Example 1:
----------
int arr[] = {1005, 7, 95, 1, 193, 99};
int k = 100;

1005+95 = 1100
7+193 = 200
1+99 = 100
So function returns true

----------
Example 2:
----------
int arr[] = {1000, 7, 95, 1, 193, 99};
int k = 100;

1000+95 = 1095
7+193 = 200
1+99 = 100
So function returns false

*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairDivisibleByK {

    public static void main(String[] args) {

        int arr[] = {1005, 7, 95, 1, 193, 99, 4, 97};
        int k = 100;
        System.out.println(isDivisible(arr, k));
    }

    static boolean isDivisible(int[] arr, int k) {
//        boolean isDivisible = false;
//        Set<Integer> set = new HashSet<>();
//
//for(int i = 0; i < arr.length; i ++){
//    set.add(arr[i]%k);
//}
//    System.out.println(set);
//        return isDivisible;
//}
        //int arr[] = [1005, 7, 95, 1, 193, 99];
        // System.out.println(is_made_of_pairs_divisible_by_k(arr, 100));

        int modCounts[] = new int[k];

        // Count all the remainder
        for (int i : arr) {
            modCounts[i % k]++;
        }

        //If mid of the remainder is not even, then return false
        if (modCounts[k / 2] % 2 != 0) {
            return false;
        }
        // If first element is not even, then return false
        if (modCounts[0] % 2 != 0) {
            return false;
        }

        // Match each ith element with its respective k-i th element
        for (int i = 1; i <= k / 2; i++) {
            if (modCounts[i] != modCounts[k - i]) {
                return false;
            }
        }
        return true;
    }
}
