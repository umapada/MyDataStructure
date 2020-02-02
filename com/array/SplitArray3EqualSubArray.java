package com.array;

/*
Check if this sum is divisible by 3 or not. This is because if sum is not divisible then the sum cannot be split in
three equal sum sets. If there are three contiguous subarrays with equal sum, then sum of each subarray is S/3.
Suppose the required pair of indices is (i, j) such that sum(arr[0..i]) = sum(arr[i+1..j]) = S/3.
Also sum(arr[0..i]) = preSum[i] and sum(arr[i+1..j]) = preSum[j] – preSum[i]. This gives
preSum[i] = preSum[j] – preSum[i] = S/3. This gives preSum[j] = 2*preSum[i]. Thus, the problem reduces to find two
indices i and j such that preSum[i] = S/3 and preSum[j] = 2*(S/3).
For finding these two indices, traverse the array and store sum upto current element in a variable preSum.
Check if preSum is divisible by S/3. If yes then store current index. If an index is already found upto which sum is
divisible by S/3, then check if preSum is divisible by 2*(S/3). If yes then store current index. If the required two
indices are found then print them.
 */


// Java program to determine if array arr[]
// can be split into three equal sum sets.

public class SplitArray3EqualSubArray {

    // Function to determine if array arr[]
    // can be split into three equal sum sets.
    static int findSplit(int []array)
    {
        int n = array.length;

        // variable to store prefix sum
        int prefixSum = 0;

        // variables to store indices which
        // have prefix sum divisible by S/3.
        int index1 = -1, index2 = -1;

        // variable to store sum of
        // entire array.
        int S;

        // Find entire sum of the array.
        S = array[0];
        for (int i = 1; i < n; i++)
            S += array[i];

        // Check if array can be split in
        // three equal sum sets or not.
        if(S % 3 != 0)
            return 0;

        // Variables to store sum S/3
        // and 2*(S/3).
        int S1 = S / 3;
        int S2 = 2 * S1;

        for (int i = 0; i < n; i++)
        {
            prefixSum += array[i];

            // If prefix sum is divisible by S/3
            // and this is the first index where
            // sum is divisible then store
            // current index.
            if (prefixSum % S1 == 0 && index1 == -1)
                index1 = i;

                // If prefix sum is divisible by 2*(S/3)
                // then store current index as second
                // index.
            else if(prefixSum % S2 == 0)
            {
                index2 = i;

                // Come out of the loop as both the
                // required indices are found.
                break;
            }
        }

        // If both the indices are found
        // then print them.
        if (index1 != -1 && index2 != -1)
        {
            System.out.print("(" + index1 + ", " + index2 + ")");
            return 1;
        }

        // If indices are not found return 0.
        return 0;
    }

    // Driver code
    public static void main(String args[])
    {
        int []arr = { 1, 3, 4, 0, 4 };
        int n = arr.length;
        if (findSplit(arr) == 0)
            System.out.print("-1");
    }
}