package com.DynamicProgramming;

/**
 * Maximum path sum that starting with any cell of 0-th row and ending with any cell of (N-1)-th row
 * Given a N X N matrix Mat[N][N] of positive integers. There are only three possible moves from a cell (i, j)
 *
 * (i+1, j)
 * (i+1, j-1)
 * (i+1, j+1)
 */


/**
 * Starting from any column in row 0, return the largest sum of any of the paths up to row N-1.
 *
 * Examples:
 *
 *
 *
 * Input : mat[4][4] = { {4, 2, 3, 4},
 *                       {2, 9, 1, 10},
 *                       {15, 1, 3, 0},
 *                       {16, 92, 41, 44} };
 * Output :120
 * path : 4 + 9 + 15 + 92 = 120
 */

import java.util.Arrays;

/**
 * The above problem can be recursively defined.
 *
 * Let initial position be MaximumPathSum(N-1, j), where j varies from 0 to N-1. We return maximum value between all
 * path that we start traversing (N-1, j) [ where j varies from 0 to N-1]
 *
 * i = N-1, j = 0 to N -1
 * int MaximumPath(Mat[][N], I, j)
 *
 *   // IF we reached to first row of
 *   // matrix then return value of that
 *   // element
 *   IF ( i == 0 && j = 0 )
 *   return    Mat[i][j]
 *
 *   // out of matrix bound
 *   IF( i = N || j < 0 )
 *    return 0;
 *
 *   // call all rest position that we reached
 *   // from current position and find maximum
 *   // between them and add current value in
 *   // that path
 *   return max(MaximumPath(Mat, i-1, j),
 *              MaximumPath(Mat, i-1, j-1),
 *              MaximumPath(Mat, i-1, j+1)))
 *              + Mat[i][j];
 * If we draw recursion tree of above recursive solution, we can observe overlapping subproblems. Since the problem has
 * overlapping subproblems, we can solve it efficiently using Dynamic Programming. Below is Dynamic Programming based solution.
 */

public class MaximumPathMatrix {

    static int N = 4;

    // function find maximum sum path
    static int MaximumPath(int Mat[][])
    {
        int result = 0;

        // creat 2D matrix to store the sum
        // of the path
        int dp[][] = new int[N][N + 2];

        // initialize all dp matrix as '0'
        for (int[] rows : dp)
            Arrays.fill(rows, 0);

        // copy all element of first column into
        // 'dp' first column
        for (int i = 0; i < N; i++)
            dp[0][i + 1] = Mat[0][i];

        for (int i = 1; i < N; i++)
            for (int j = 1; j <= N; j++)
                dp[i][j] = Math.max(dp[i - 1][j - 1],
                        Math.max(dp[i - 1][j],
                                dp[i - 1][j + 1])) +
                        Mat[i][j - 1];

        // Find maximum path sum that end ups
        // at any column of last row 'N-1'
        for (int i = 0; i <= N; i++)
            result = Math.max(result, dp[N - 1][i]);

        // return maximum sum path
        return result;
    }

    // driver code
    public static void main(String arg[])
    {
        int Mat[][] = { { 4, 2, 3, 4 },
                { 2, 9, 1, 10 },
                { 15, 1, 3, 0 },
                { 16, 92, 41, 44 } };

        System.out.println(MaximumPath(Mat));
    }

    //Time complexity : O(N2)

}
