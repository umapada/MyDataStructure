package com.test.ds1.DynamicProgramming;

/**
 * Find maximum possible stolen value from houses
 * There are n houses build in a line, each of which contains some value in it. A thief is going to steal the
 * maximal value of these houses, but he can’t steal in two adjacent houses because owner of the stolen houses
 * will tell his two neighbour left and right side. What is the maximum stolen value.
 * Examples:
 *
 * Input  : hval[] = {6, 7, 1, 3, 8, 2, 4}
 * Output : 19
 * Thief will steal 6, 1, 8 and 4 from house.
 *
 * Input  : hval[] = {5, 3, 4, 11, 2}
 * Output : 16
 * Thief will steal 5 and 11
 *
 */

// Solution

/**
 * While reaching house i thief has two options, either he robs it or leave it. Let dp[i] represents the
 * maximum value stolen so far on reaching house i. We can calculate the value of dp[i] as following –
 *
 * dp[i] = max (hval[i] + dp[i-2], dp[i-1])
 *
 * hval[i] + dp[i-2] is the case when thief
 * decided to rob house i. In that situation
 * maximum value will be the current value of
 * house + maximum value stolen till last
 * robbery at house not adjacent to house
 * i which will be house i-2.
 *
 * dp[i-1] is the case when thief decided not
 * to rob house i. So he will check adjacent
 * house for maximum value stolen till now.
 * Thief will consider both options and decide whether to rob or not and maximum of both values will be the
 * maximum stolen value till reaching house i.
 *
 */



// Java program to find the maximum stolen value
import java.io.*;

class MaxLoot
{
    // Function to calculate the maximum stolen value
    static int maxLoot(int hval[], int n)
    {
        if (n == 0)
            return 0;
        if (n == 1)
            return hval[0];
        if (n == 2)
            return Math.max(hval[0], hval[1]);
        // dp[i] represent the maximum value stolen
        // so far after reaching house i.
        int[] dp = new int[n];

        // Initialize the dp[0] and dp[1]
        dp[0] = hval[0];
        dp[1] = Math.max(hval[0], hval[1]);

        // Fill remaining positions
        for (int i = 2; i<n; i++)
            dp[i] = Math.max(hval[i]+dp[i-2], dp[i-1]);

        return dp[n-1];
    }

    // Driver program
    public static void main (String[] args)
    {
        int hval[] = {5, 5, 10, 100, 10, 5};
        int n = hval.length;
        System.out.println("Maximum loot value : " + maxLoot(hval, n));
    }
}
