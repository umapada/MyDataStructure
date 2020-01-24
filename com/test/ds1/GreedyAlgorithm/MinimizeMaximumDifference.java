package com.test.ds1.GreedyAlgorithm;

/**
 * Minimize the maximum difference between the heights
 * Given heights of n towers and a value k. We need to either increase or decrease height of every tower by k (only once)
 * where k > 0. The task is to minimize the difference between the heights of the longest and the shortest tower after
 * modifications, and output this difference.
 *
 * Examples:
 *
 * Input  : arr[] = {1, 15, 10}, k = 6
 * Output :  Maximum difference is 5.
 * Explanation : We change 1 to 6, 15 to
 * 9 and 10 to 4. Maximum difference is 5
 * (between 4 and 9). We can't get a lower
 * difference.
 *
 * Input : arr[] = {1, 5, 15, 10}
 *         k = 3
 * Output : Maximum difference is 8
 * arr[] = {4, 8, 12, 7}
 *
 * Input : arr[] = {4, 6}
 *         k = 10
 * Output : Maximum difference is 2
 * arr[] = {14, 16} OR {-6, -4}
 *
 * Input : arr[] = {6, 10}
 *         k = 3
 * Output : Maximum difference is 2
 * arr[] = {9, 7}
 *
 * Input : arr[] = {1, 10, 14, 14, 14, 15}
 *         k = 6
 * Output: Maximum difference is 5
 * arr[] = {7, 4, 8, 8, 8, 9}
 *
 * Input : arr[] = {1, 2, 3}
 *         k = 2
 * Output: Maximum difference is 2
 * arr[] = {3, 4, 5}
 */


import java.util.Arrays;

/**
 * The idea is to sort all elements increasing order. And for all elements check if subtract(element-k) and
 * add(element+k) makes any changes or not.
 */

public class MinimizeMaximumDifference {

    // Modifies the array by subtracting/adding k to every element such that the difference between maximum and minimum
    // is minimized

    // Driver function to test the above function
    public static void main(String[] args)
    {
        int arr[] = {1, 15, 10};
        int n = arr.length;
        int k = 6;
        System.out.println("Maximum difference is "+ getMinDiff(arr, n, k));
    }

    static int getMinDiff(int arr[], int n, int k)
    {
        if (n == 1)
            return 0;

        // Sort all elements
        Arrays.sort(arr);

        // Initialize result
        int ans = arr[n-1] - arr[0];

        // Handle corner elements
        int small = arr[0] + k;
        int big = arr[n-1] - k;
        int temp = 0;

        if (small > big)
        {
            temp = small;
            small = big;
            big = temp;
        }

        // Traverse middle elements
        for (int i = 1; i < n-1; i ++)
        {
            int subtract = arr[i] - k;
            int add = arr[i] + k;

            // If both subtraction and addition do not change diff
            if (subtract >= small || add <= big)
                continue;

            // Either subtraction causes a smaller number or addition causes a greater number. Update small or big using
            // greedy approach (If big - subtract causes smaller diff, update small Else update big)
            if (big - subtract <= add - small)
                small = subtract;
            else
                big = add;
        }

        return Math.min(ans, big - small);
    }

}
