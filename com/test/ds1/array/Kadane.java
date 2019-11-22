package com.test.ds1.array;

//Java program to print largest contiguous array sum
//Write an efficient program to find the sum of contiguous sub-array within a one-dimensional array
// of numbers which has the largest sum.

/*
 * Simple idea of the Kadane's algorithm is to look for all positive contiguous segments of the array
 * (max_ending_here is used for this).
 * And keep track of maximum sum contiguous segment among all positive segments (max_so_far is used for this). 
 * Each time we get a positive sum compare it with max_so_far and update max_so_far if it is greater than max_so_far
 */
class Kadane
{
 public static void main (String[] args)
 {
     int [] a = {-2,1,-3,4,-1,2,1,-5,4};
     System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
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
}