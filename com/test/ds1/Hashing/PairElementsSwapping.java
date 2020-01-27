package com.test.ds1.Hashing;

/**
 * Find a pair of elements swapping which makes sum of two arrays same
 * Given two arrays of integers, find a pair of values (one value from each array) that you can swap to give the two arrays the same sum.
 *
 * Examples:
 *
 * Input: A[] = {4, 1, 2, 1, 1, 2}, B[] = (3, 6, 3, 3)
 * Output: {1, 3}
 * Sum of elements in A[] = 11
 * Sum of elements in B[] = 15
 * To get same sum from both arrays, we
 * can swap following values:
 * 1 from A[] and 3 from B[]
 *
 *
 *
 * Input: A[] = {5, 7, 4, 6}, B[] = {1, 2, 3, 8}
 * Output: 6 2
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Method 1 (Naive Implementation):
 * Iterate through the arrays and check all pairs of values. Compare new sums or look for a pair with that difference.
 */
public class PairElementsSwapping {


    public static void main (String[] args)
    {
        int A[] = { 4, 1, 2, 1, 1, 2 };
        int n = A.length;
        int B[] = { 3, 6, 3, 3 };
        int m = B.length;

        // Call to function
        findSwapValues4(A, n, B, m);
    }

    // Function to calculate sum of elements of array
    static int getSum(int X[], int n)
    {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += X[i];
        return sum;
    }

    // Function to prints elements to be swapped
    static void findSwapValues(int A[], int n, int B[], int m)
    {
        // Calculation of sums from both arrays
        int sum1 = getSum(A, n);
        int sum2 = getSum(B, m);

        // Look for val1 and val2, such that
        // sumA - val1 + val2 = sumB - val2 + val1
        int newsum1, newsum2, val1 = 0, val2 = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                newsum1 = sum1 - A[i] + B[j];
                newsum2 = sum2 - B[j] + A[i];
                if (newsum1 == newsum2)
                {
                    val1 = A[i];
                    val2 = B[j];
                }
            }
        }

        System.out.println(val1+" "+val2);
    }

    /**
     * Time Complexity :- O(n*m)
     */


    /**
     * Method 2 -> Other Naive implementation
     *
     * We are looking for two values, a and b, such that:
     * sumA - a + b = sumB - b + a
     *     2a - 2b  = sumA - sumB
     *       a - b  = (sumA - sumB) / 2
     */

    static int getTarget(int A[], int n, int B[], int m)
    {
        // Calculation of sums from both arrays
        int sum1 = getSum(A, n);
        int sum2 = getSum(B, m);

        // because that the target must be an integer
        if ((sum1 - sum2) % 2 != 0)
            return 0;
        return ((sum1 - sum2) / 2);
    }

    // Function to prints elements to be swapped
    static void findSwapValues2(int A[], int n, int B[], int m)
    {
        int target = getTarget(A, n, B, m);
        if (target == 0)
            return;

        // Look for val1 and val2, such that
        // val1 - val2 = (sumA - sumB) / 2
        int val1 = 0, val2 = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (A[i] - B[j] == target)
                {
                    val1 = A[i];
                    val2 = B[j];
                }
            }
        }
        System.out.println(val1+" "+val2);
    }

    /**
     * Time Complexity :- O(n*m)
     */


    /**
     * Method 3 -> Optimized Solution :-
     *
     * Sort the arrays.
     * Traverse both array simultaneously and do following for every pair.
     * If the difference is too small then, make it bigger by moving ‘a’ to a bigger value.
     * If it is too big then, make it smaller by moving b to a bigger value.
     * If it’s just right, return this pair.
     */

    // Function to prints elements to be swapped
    static void findSwapValues3(int A[], int n, int B[], int m)
    {
        // Call for sorting the arrays
        Arrays.sort(A);
        Arrays.sort(B);

        // Note that target can be negative
        int target = getTarget(A, n, B, m);

        // target 0 means, answer is not possible
        if (target == 0)
            return;

        int i = 0, j = 0;
        while (i < n && j < m)
        {
            int diff = A[i] - B[j];
            if (diff == target)
            {
                System.out.println(A[i]+" "+B[i]);
                return;
            }

            // Look for a greater value in A[]
            else if (diff < target)
                i++;

                // Look for a greater value in B[]
            else
                j++;
        }
    }

    /**
     * If arrays are sorted : O(n + m)
     * If arrays aren’t sorted : O(nlog(n) + mlog(m))
     */

    /**
     * We can solve this problem in O(m+n) time and O(m) auxiliary space. Below are algorithmic steps.
     *
     * // assume array1 is small i.e. (m < n)
     * // where m is array1.length and n is array2.length
     * 1. Find sum1(sum of small array elements) ans sum2 (sum of larger array elements). // time O(m+n)
     * 2. Make a hashset for small array(here array1).
     * 3. Calculate diff as (sum1-sum2)/2.
     * 4. Run a loop for array2
     *      for (int i equal to 0 to n-1)
     *        if (hashset contains (array2[i]+diff))
     *            print array2[i]+diff and array2[i]
     *            set flag  and break;
     * 5. If flag is unset then there is no such kind of
     * pair.
     */

//Important
    static void findSwapValues4(int A[], int n, int B[], int m){
        int sum1 = 0, sum2 = 0;
        Set<Integer> set1 = new HashSet<>();

        for(int i=0; i < A.length; i++){
            sum1 += A[i];
            set1.add(A[i]);
        }

        for(int i=0; i < B.length; i++){
            sum2 += B[i];
        }

        int diff = 0;

            diff = sum2 - sum1;
            for(int i=0; i < B.length; i++){
                if(set1.contains(diff - B[i])){
                    System.out.println(diff - B[i] + " " + B[i]  );
                    break;
                }
            }




    }

}
