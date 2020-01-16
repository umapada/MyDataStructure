package com.test.ds1.array;

/**
 * Given an unsorted array of nonnegative integers, find a continuous subarray which adds to a given number.
 * Examples :
 *
 * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
 * Ouptut: Sum found between indexes 2 and 4
 *
 *
 *
 * Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
 * Ouptut: Sum found between indexes 1 and 4
 *
 * Input: arr[] = {1, 4}, sum = 0
 * Output: No subarray found
 *
 * There may be more than one subarrays with sum as the given sum.
 */
//TODO
public class SubarrayWithGivenSum {

    public static void main(String[] args) {
        int [] arr = {1, 4, 0, 0, 4, 10, 5,2};
        int sum = 13;

       subArraySum(arr,sum);
    }


    static void subArraySum(int arr[], int sum)
    {
        int n = arr.length;
        int curr_sum = arr[0], start = 0, i;

        // Pick a starting point
        for (i = 1; i <= n; i++)
        {
            // If curr_sum exceeds the sum, then remove the starting elements
            while (curr_sum > sum && start < i-1)
            {
                curr_sum = curr_sum - arr[start];
                start++;
            }

            // If curr_sum becomes equal to sum, then return true
            if (curr_sum == sum)
            {
                int p = i-1;
                System.out.println("Sum found between indexes " + start
                        + " and " + p);
               // return 1;
                return;
            }

            // Add this element to curr_sum
            if (i < n)
                curr_sum = curr_sum + arr[i];

        }

        System.out.println("No subarray found");
       // return 0;
    }

}
