package com.GreedyAlgorithm;
/*
Minimize the heights
Given an array A[ ] denoting heights of N towers and a positive integer K, modify the heights of each tower either by
increasing or decreasing them by K only once and then find out the minimum difference of the heights of shortest and
longest towers.

Example

Input  : A[] = {1, 15, 10}, k = 6
Output : 5
Explanation : We change 1 to 7, 15 to
9 and 10 to 4. Maximum difference is 5
(between 4 and 9). We can't get a lower
difference.
 */
public class MinimizeTheHeights {

    public static void main(String[] args) {
        int A[] = {3, 9, 12, 16, 20}, k = 3;

        int res = minHeight(A,k);

        System.out.println(res);
    }

    static int minHeight(int[] arr, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int median = 0;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max,arr[i]);
        }
        median = (max + min) / 2;
        if ((max - min) < k) {
            return max - min;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= median) {
                arr[i] += k;
            } else {
                arr[i] -= k;
            }
        }
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max,arr[i]);
        }
        return max - min;
    }
}
