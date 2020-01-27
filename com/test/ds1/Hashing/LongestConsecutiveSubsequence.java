package com.test.ds1.Hashing;

/**
 * Longest Consecutive Subsequence
 * Given an array of integers, find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
 * Examples:
 *
 * Input: arr[] = {1, 9, 3, 10, 4, 20, 2}
 * Output: 4
 * The subsequence 1, 3, 4, 2 is the longest subsequence
 * of consecutive elements
 *
 *
 *
 * Input: arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
 * Output: 5
 * The subsequence 36, 35, 33, 34, 32 is the longest subsequence
 * of consecutive elements.
 */

import java.util.HashSet;

/**
 * One Solution is to first sort the array and find the longest subarray with consecutive elements. Time complexity
 * of this solution is O(nLogn). Thanks to Hao.W for suggesting this solution.
 *
 * We can solve this problem in O(n) time using an Efficient Solution. The idea is to use Hashing. We first insert
 * all elements in a Set. Then check all the possible starts of consecutive subsequences. Below is the complete algorithm.
 *
 * Create an empty hash.
 * Insert all array elements to hash.
 * Do following for every element arr[i]
 * Check if this element is the starting point of a subsequence. To check this, we simply look for arr[i] – 1 in
 * the hash, if not found, then this is the first element a subsequence.
 * If this element is the first element, then count number of elements in the consecutive starting with this element.
 * Iterate from arr[i] + 1 till the last element that can be found.
 * If the count is more than the previous longest subsequence found, then update this.
 */

public class LongestConsecutiveSubsequence {
    // Returns length of the longest consecutive subsequence
    static int findLongestConseqSubseq(int arr[],int n)
    {
        HashSet<Integer> S = new HashSet<Integer>();
        int ans = 0;

        // Hash all the array elements
        for (int i=0; i<n; ++i) {
            S.add(arr[i]);
        }

        // check each possible sequence from the start then update optimal length
        for (int i=0; i<n; ++i)
        {
            // if current element is the starting element of a sequence
            if (!S.contains(arr[i]-1))
            {
                // Then check for next elements in the sequence
                int j = arr[i];
                while (S.contains(j))
                    j++;

                // update  optimal length if this length is more
                if (ans<j-arr[i])
                    ans = j-arr[i];
            }
        }
        return ans;
    }
}
