package com; /**
 * Count of strings that can be formed using a, b and c under given constraints
 * Given a length n, count the number of strings of length n that can be made using ‘a’, ‘b’ and ‘c’ with at-most one
 * ‘b’ and two ‘c’s allowed.
 *
 * Examples :
 *
 * Input : n = 3
 * Output : 19
 * Below strings follow given constraints:
 * aaa aab aac aba abc aca acb acc baa
 * bac bca bcc caa cab cac cba cbc cca ccb
 * abc
 * aab aac baa bcc caa cca ccb
 *
 *
 * Input  : n = 4
 * Output : 39
 */
/**
 * If we drown a recursion tree of above code, we can notice that same values appear multiple times. So we store
 * results which are used later if repeated.
 */
// A O(1) Java program to find number of strings that can be made under given constraints.
class CountOfStringsWaysABC
{
    static int countStr(int n)
    {
        return 1 + (n * 2) + (n * ((n * n) - 1) / 2);
    }
    // Driver code
    public static void main (String[] args)
    {
        int n = 3;
        System.out.println( countStr(n));
    }
// Java program to count number of strings of n characters with n is total number of characters.
    // b Count and cCount are counts of 'b' and 'c' respectively.

    static int countStrUtil(int[][][] dp, int n, int bCount, int cCount)
    {

        // Base cases
        if (bCount < 0 || cCount < 0)
        {
            return 0;
        }
        if (n == 0)
        {
            return 1;
        }
        if (bCount == 0 && cCount == 0)
        {
            return 1;
        }

        // if we had saw this combination previously
        if (dp[n][bCount][cCount] != -1)
        {
            return dp[n][bCount][cCount];
        }

        // Three cases, we choose, a or b or c In all three cases n decreases by 1.
        int res = countStrUtil(dp, n - 1, bCount, cCount);
        res += countStrUtil(dp, n - 1, bCount - 1, cCount);
        res += countStrUtil(dp, n - 1, bCount, cCount - 1);

        return (dp[n][bCount][cCount] = res);
    }

    // A wrapper over countStrUtil()
    static int countStr(int n, int bCount, int cCount)
    {
        int[][][] dp = new int[n + 1][2][3];
        for (int i = 0; i < n + 1; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                for (int k = 0; k < 3; k++)
                {
                    dp[i][j][k] = -1;
                }
            }
        }
        return countStrUtil(dp, n,bCount,cCount);
    }

}


/**
 * Time Complexity : O(n)
 * Auxiliary Space : O(n)
 */



// This code is contributed by ajit


/**
 * Time Complexity : O(1)
 * Auxiliary Space : O(1)
 */

