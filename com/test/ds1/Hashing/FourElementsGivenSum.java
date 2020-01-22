package com.test.ds1.Hashing;

/**
 * Given an array of integers, Check if there exist four elements at different indexes in the array whose sum is equal to a given value k.
 * For example, if the given array is {1 5 1 0 6 0} and k = 7, then your function should print “YES” as (1+5+1+0=7).
 *
 * Examples:
 *
 * Input  : arr[] = {1 5 1 0 6 0}
 *              k = 7
 * Output : YES
 *
 * Input :  arr[] = {38 7 44 42 28 16 10 37
 *                   33 2 38 29 26 8 25}
 *             k = 22
 * Output : NO
 */


/**
 * In this post, an optimized solution is discussed that works in O(n2) on average.
 *
 * The idea is to create a hashmap to store pair sums.
 *
 * Loop i = 0 to n-1 :
 *  Loop j = i + 1 to n-1
 *    calculate sum = arr[i] + arr[j]
 *      If (k-sum) exist in hash
 *       a) Check in hash table for all
 *          pairs of indexes which form
 *          (k-sum).
 *       b) If there is any pair with no
 *          no common indexes.
 *            return true
 *     Else  update hash table
 *     EndLoop;
 * EndLoop;
 */
public class FourElementsGivenSum {
}
