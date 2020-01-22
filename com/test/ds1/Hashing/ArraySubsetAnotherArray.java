package com.test.ds1.Hashing;

/**
 * Find whether an array is subset of another array | Added Method 3
 * Given two arrays: arr1[0..m-1] and arr2[0..n-1]. Find whether arr2[] is a subset of arr1[] or not. Both the arrays
 * are not in sorted order. It may be assumed that elements in both array are distinct.
 * Examples:
 *
 * Input: arr1[] = {11, 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1}
 * Output: arr2[] is a subset of arr1[]
 *
 *
 *
 * Input: arr1[] = {1, 2, 3, 4, 5, 6}, arr2[] = {1, 2, 4}
 * Output: arr2[] is a subset of arr1[]
 *
 * Input: arr1[] = {10, 5, 2, 23, 19}, arr2[] = {19, 5, 3}
 * Output: arr2[] is not a subset of arr1[]
 */


import java.util.HashSet;
import java.util.Set;

/**
 * Method 4 (Use Hashing)
 *
 * Create a Hash Table for all the elements of arr1[].
 * Traverse arr2[] and search for each element of arr2[] in the Hash Table. If element is not found then return 0.
 * If all elements are found then return 1.
 */
public class ArraySubsetAnotherArray {


    public static void main(String[] args)
    {
        int arr1[] = {11, 1, 13, 21, 3, 7};
        int arr2[] = {11, 3, 7, 1};

        int m = arr1.length;
        int n = arr2.length;

        if(isSubset(arr1, arr2, m, n))
            System.out.println("arr2 is a subset of arr1");
        else
            System.out.println("arr2 is not a subset of arr1");
    }

    static boolean isSubset(int arr1[], int arr2[], int m,
                            int n)
    {
        Set<Integer> hset= new HashSet<>();

        // hset stores all the values of arr1
        for(int i = 0; i < m; i++)
        {
            if(!hset.contains(arr1[i]))
                hset.add(arr1[i]);
        }

        // loop to check if all elements of arr2 also
        // lies in arr1
        for(int i = 0; i < n; i++)
        {
            if(!hset.contains(arr2[i]))
                return false;
        }
        return true;
    }

}
