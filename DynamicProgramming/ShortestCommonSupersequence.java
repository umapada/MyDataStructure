package DynamicProgramming;

/**
 * Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.
 * Examples :
 *
 * Input:   str1 = "geek",  str2 = "eke"
 * Output: "geeke"
 *
 * Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
 * Output:  "AGXGTXAYB"
 */


/**
 * A simple analysis yields below simple recursive solution.
 *
 * Let X[0..m - 1] and Y[0..n - 1] be two strings and m and n be respective
 * lengths.
 *
 *   if (m == 0) return n;
 *   if (n == 0) return m;
 *
 *   // If last characters are same, then add 1 to result and
 *   // recur for X[]
 *   if (X[m - 1] == Y[n - 1])
 *      return 1 + SCS(X, Y, m - 1, n - 1);
 *
 *   // Else find shortest of following two
 *   //  a) Remove last character from X and recur
 *   //  b) Remove last character from Y and recur
 *   else return 1 + min( SCS(X, Y, m - 1, n), SCS(X, Y, m, n - 1) );
 */


public class ShortestCommonSupersequence {

    // Driver code
    public static void main(String args[])
    {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println("Length of the shortest" +
                "supersequence is: "
                + superSeq(X, Y, X.length(),Y.length()));
    }

    static int superSeq(String X, String Y,
                        int m, int n)
    {
        if (m == 0) return n;
        if (n == 0) return m;

        if (X.charAt(m - 1) == Y.charAt(n - 1))
            return 1 + superSeq(X, Y, m - 1, n - 1);

        return 1 + Math.min(superSeq(X, Y, m - 1, n),
                superSeq(X, Y, m, n - 1));
    }

    /**
     * Time complexity of the above solution exponential O(2min(m, n)). Since there are overlapping subproblems,
     * we can efficiently solve this recursive problem using Dynamic Programming. Below is Dynamic Programming based
     * implementation. Time complexity of this solution is O(mn).
     */

    static int superSeq2(String X, String Y, int m, int n)
    {
        int[][] dp = new int[m + 1][n + 1];

        // Fill table in bottom up manner
        for (int i = 0; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                // Below steps follow above recurrence
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j],
                            dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }

}
