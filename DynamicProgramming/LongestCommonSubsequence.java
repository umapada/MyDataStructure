package DynamicProgramming;

/**
 * Longest Common Subsequence | DP-4
 * We have discussed Overlapping Subproblems and Optimal Substructure properties in Set 1 and Set 2 respectively.
 * We also discussed one example problem in Set 3. Let us discuss Longest Common Subsequence (LCS) problem as one more
 * example problem that can be solved using Dynamic Programming.
 *
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. For example,
 * “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 *
 * In order to find out the complexity of brute force approach, we need to first know the number of possible different
 * subsequences of a string with length n, i.e., find the number of subsequences with lengths ranging from 1,2,..n-1.
 * Recall from theory of permutation and combination that number of combinations with 1 element are nC1. Number of
 * combinations with 2 elements are nC2 and so forth and so on. We know that nC0 + nC1 + nC2 + … nCn = 2n. So a string
 * of length n has 2n-1 different possible subsequences since we do not consider the subsequence with length 0. This
 * implies that the time complexity of the brute force approach will be O(n * 2n). Note that it takes O(n) time to check
 * if a subsequence is common to both the strings. This time complexity can be improved using dynamic programming.
 *
 * It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences
 * between two files), and has applications in bioinformatics.
 *
 * Examples:
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */


public class LongestCommonSubsequence {

    //Following is simple recursive implementation of the LCS problem.

    public static void main(String[] args)
    {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " +  lcs.lcs( X, Y, m, n ) );
    }

    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    int lcs( char[] X, char[] Y, int m, int n )
    {
        if (m == 0 || n == 0)
            return 0;
        if (X[m-1] == Y[n-1])
            return 1 + lcs(X, Y, m-1, n-1);
        else
            return max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
    }

    /* Utility function to get max of 2 integers */
    int max(int a, int b)
    {
        return (a > b)? a : b;
    }


    /**
     * Time complexity of the above naive recursive approach is O(2^n) in worst case and worst case happens when
     * all characters of X and Y mismatch i.e., length of LCS is 0.
     * Considering the above implementation, following is a partial recursion tree for input strings “AXYT” and “AYZX”
     *
     *                          lcs("AXYT", "AYZX")
     *                        /
     *          lcs("AXY", "AYZX")            lcs("AXYT", "AYZ")
     *          /                              /
     * lcs("AX", "AYZX") lcs("AXY", "AYZ")   lcs("AXY", "AYZ") lcs("AXYT", "AY")
     * In the above partial recursion tree, lcs(“AXY”, “AYZ”) is being solved twice. If we draw the complete recursion
     * tree, then we can see that there are many subproblems which are solved again and again. So this problem has
     * Overlapping Substructure property and recomputation of same subproblems can be avoided by either using Memoization
     * or Tabulation. Following is a tabulated implementation for the LCS problem.
     */

    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    int lcs2( char[] X, char[] Y, int m, int n )
    {
        int L[][] = new int[m+1][n+1];

    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i-1] == Y[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = max(L[i-1][j], L[i][j-1]);
            }
        }
        return L[m][n];
    }

//Time Complexity of the above implementation is O(mn) which is much better than the worst-case time complexity of Naive Recursive implementation.
}
