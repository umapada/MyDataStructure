package com.test.ds1.Hashing;

/**
 * Given two unsorted arrays, find all pairs whose sum is x
 * Given two unsorted arrays of distinct elements, the task is to find all pairs from both arrays whose sum is equal to X.
 *
 * Examples:
 *
 * Input :  arr1[] = {-1, -2, 4, -6, 5, 7}
 *          arr2[] = {6, 3, 4, 0}
 *          x = 8
 * Output : 4 4
 *          5 3
 *
 * Input : arr1[] = {1, 2, 4, 5, 7}
 *         arr2[] = {5, 6, 3, 4, 8}
 *         x = 9
 * Output : 1 8
 *          4 5
 *          5 4
 */

import java.util.HashMap;
import java.util.Map;

/**
 * An Efficient solution of this problem is to hashing. Hash table is implemented using unordered_set in C++.
 *
 * We store all first array elements in hash table.
 * For elements of second array, we subtract every element from x and check the result in hash table.
 * If result is present, we print the element and key in hash (which is an element of first array).
 */

public class FindPairsSumX {


    public static void main(String[] args)
    {
        int arr1[] = { 1, 0, -4, 7, 6, 4 };
        int arr2[] = { 0, 2, 4, -3, 2, 1 };
        int x = 8;

        findPairs(arr1, arr2, arr1.length, arr2.length, x);
    }

    // Function to find all pairs in both arrays whose sum is equal to given value x
    public static void findPairs(int arr1[], int arr2[],
                                 int n, int m, int x)
    {
        // Insert all elements of first array in a hash
        Map<Integer, Integer> s = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++)
            s.put(arr1[i], 0);

        // Subtract sum from second array elements one by one and check it's present in array first or not
        for (int j = 0; j < m; j++)
            if (s.containsKey(x - arr2[j]))
                System.out.println(x - arr2[j] + " " + arr2[j]);
    }

    /**
     * Time Complexity: O(max(n, m))
     * Auxiliary Space: O(n)
     */

}
