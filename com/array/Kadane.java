package com.array;

//Java program to print largest contiguous array sum
//Write an efficient program to find the sum of contiguous sub-array within a one-dimensional array
// of numbers which has the largest sum.

/*
 * Simple idea of the Kadane's algorithm is to look for all positive contiguous segments of the array
 * (max_ending_here is used for this).
 * And keep track of maximum sum contiguous segment among all positive segments (max_so_far is used for this). 
 * Each time we get a positive sum compare it with max_so_far and update max_so_far if it is greater than max_so_far
 */
//Progress => //4
class Kadane
{
 public static void main (String[] args)
 {
    // int [] a = {-2,1,-3,4,-1,2,1,-5,4};
      int [] a = {6,-5,4};

     System.out.println("Maximum contiguous sum is " + maxSubArray(a));
 }

 static int maxSubArraySum(int a[])
 {
     int size = a.length;
     int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

     for (int i = 0; i < size; i++)
     {
         max_ending_here = max_ending_here + a[i];
         if (max_so_far < max_ending_here)
             max_so_far = max_ending_here;
         if (max_ending_here < 0)
             max_ending_here = 0;
     }
     return max_so_far;
 }


    //We should ignore the sum of the previous n-1 elements if nth element is greater than the sum
    public static int maxSubArray(int[] A) {
        int max = A[0];
        int[] sum = new int[A.length];
        sum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sum[i] = Math.max(A[i], sum[i-1] + A[i]);
            max = Math.max(max, sum[i]);
        }
        return max;
    }


}

// DP ?



