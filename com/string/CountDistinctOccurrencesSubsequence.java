package com.string;

// Java program to count number of times
// S appears as a subsequence in T
import java.io.*;
/**
 * Count distinct occurrences as a subsequence
 * Given a two strings S and T, find count of distinct occurrences of T in S as a subsequence.
 *
 * Examples:
 *
 * Input  : S = banana, T = ban
 * Output : 3
 * T appears in S as below three subsequences.
 * [ban], [ba  n], [b   an]
 *
 * Input  : S = geeksforgeeks, T = ge
 * Output : 6
 * T appears in S as below three subsequences.
 * [ge], [     ge], [g e], [g    e] [g     e]
 * and [     g e]
 */

/**
 * This problem can be recursively defined as below.
 *
 * // Returns count of subsequences of S that match T
 * // m is length of T and n is length of S
 * subsequenceCount(S, T, n, m)
 *
 *    // An empty string is subsequence of all.
 *    1) If length of T is 0, return 1.
 *
 *    // Else no string can be a sequence of empty S.
 *    2) Else if S is empty, return 0.
 *
 *    3) Else if last characters of S and T don't match,
 *       remove last character of S and recur for remaining
 *         return subsequenceCount(S, T, n-1, m)
 *
 *    4) Else (Last characters match), the result is sum
 *       of two counts.
 *
 *         // Remove last character of S and recur.
 *         a) subsequenceCount(S, T, n-1, m) +
 *
 *         // Remove last characters of S and T, and recur.
 *         b) subsequenceCount(S, T, n-1, m-1)
 * Since there are overlapping subproblems in above recurrence result, we can apply dynamic programming approach to
 * solve above problem. We create a 2D array mat[m+1][n+1] where m is length of string T and n is length of string S.
 * mat[i][j] denotes the number of distinct subsequence of substring S(1..i) and substring T(1..j) so mat[m][n] contains our solution.
 */

//Important
class CountDistinctOccurrencesSubsequence {
    static int findSubsequenceCount(String S, String T)
    {
        int m = T.length();
        int n = S.length();

        // T can't appear as a subsequence in S
        if (m > n)
            return 0;

        // mat[i][j] stores the count of
        // occurrences of T(1..i) in S(1..j).
        int mat[][] = new int[m + 1][n + 1];

        // Initializing first column with
        // all 0s. An emptystring can't have
        // another string as suhsequence
        for (int i = 1; i <= m; i++)
            mat[i][0] = 0;

        // Initializing first row with all 1s.
        // An empty string is subsequence of all.
        for (int j = 0; j <= n; j++)
            mat[0][j] = 1;

        // Fill mat[][] in bottom up manner
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If last characters don't match,
                // then value is same as the value
                // without last character in S.
                if (T.charAt(i - 1) != S.charAt(j - 1))
                    mat[i][j] = mat[i][j - 1];

                    // Else value is obtained considering two cases.
                    // a) All substrings without last character in S
                    // b) All substrings without last characters in
                    // both.
                else
                    mat[i][j] = mat[i][j - 1] + mat[i - 1][j - 1];
            }
        }

		/* uncomment this to print matrix mat
		for (int i = 1; i <= m; i++, cout << endl)
			for (int j = 1; j <= n; j++)
				System.out.println ( mat[i][j] +" "); */
        return mat[m][n];
    }

    // Driver code to check above method
    public static void main(String[] args)
    {
        String T = "ge";
        String S = "geeksforgeeks";
        System.out.println(findSubsequenceCount(S, T));
    }
}
// This code is contributed by vt_m

/**
 * Time Complexity : O(m*n)
 * Auxiliary Space : O(m*n)
 */