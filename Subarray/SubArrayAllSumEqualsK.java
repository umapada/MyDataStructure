package Subarray;

/*
Given an array of integers and an integer k, you need to find the
total number of continuous subarrays whose sum equals to k.

 */

// Java program to find number of subarrays  with sum exactly equal to k.
import java.util.HashMap;

public class SubArrayAllSumEqualsK {

    // Function to find number of subarrays with sum exactly equal to k.
    static int findSubarraySum(int arr[], int n, int k)
    {
        // HashMap to store number of subarrays starting from index zero having particular value of sum.
        HashMap <Integer, Integer> map = new HashMap<>();
        int count = 0;
        // Sum of elements so far.
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // Add current element to sum so far.
            sum += arr[i];
            // If currsum is equal to desired sum, then a new subarray is found. So increase count of subarrays.
            if (sum == k)
                count++;
            // currsum exceeds given sum by currsum - sum. Find number of subarrays having
            // this sum and exclude those subarrays from currsum by increasing count by same amount.
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            // Add currsum value to count of different values of sum.
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        return count;
    }

    public static void main(String []args){
       // int arr[] = { 10, 2, -2, -20, 10};
       // int sum = -10;
         int arr[] = { 3,4,7,2,-3,1,4,2};
         int sum = 7;
        int n = arr.length;
        System.out.println(findSubarraySum(arr, n, sum));
    }
}

