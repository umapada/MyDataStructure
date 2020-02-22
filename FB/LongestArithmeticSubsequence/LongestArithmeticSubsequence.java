package FB.LongestArithmeticSubsequence;

/**
 * Given an array A of integers, return the length of the longest arithmetic subsequence in A.
 *
 * Recall that a subsequence of A is a list A[i_1], A[i_2], ..., A[i_k] with 0 <= i_1 < i_2 < ... < i_k <= A.length - 1,
 * and that a sequence B is arithmetic if B[i+1] - B[i] are all the same value (for 0 <= i < B.length - 1).
 *
 * Example 1:
 * Input: [3,6,9,12]
 * Output: 4
 * Explanation:
 * The whole array is an arithmetic sequence with steps of length = 3.
 * Example 2:
 *
 * Input: [9,4,7,2,10]
 * Output: 3
 * Explanation:
 * The longest arithmetic subsequence is [4,7,10].
 * Example 3:
 *
 * Input: [20,1,15,3,10,5,8]
 * Output: 4
 * Explanation:
 * The longest arithmetic subsequence is [20,15,10,5].
 */


// Explanation for below solution

/**
 *
 * Refer to the picture below.
 *
 * We have to find the maximum number of elements with the same difference. For the second example,
 * [9, 4, 7, 2, 10] answer would be 3 why? 4->7->10 and they are separated by 3.
 * Every element, itself make distance 0 and maximum element would be 1. So all diagonal is 1
 * For the first row, take
 * [9,4]-> distance: -5 max element: 2 because there is no element before 9 with the distance -5.
 * [9,7]-> distance: -2 max element: 2 because there is no element before 9 with the distance -2.
 * [9,2]-> distance: -7 max element: 2 because there is no element before 9 with the distance -7.
 * [9,10]-> distance: 1max element: 2 because there is no element before 9 with the distance 1.
 * 3. For the third row
 * [7,2]-> distance: -5 max element: 2 because there is no element before 7 with the distance -5. 7–4=3, 7–9=-2
 * [7,10]-> distance: 3 max element: 2+1. Because there is one more element before 7 makes distance 3. 7–4=3
  */

//V Important
public class LongestArithmeticSubsequence {

    public static void main(String[] args) {
        int[] A = {0, 8, 45, 88, 48, 68, 28, 55, 17, 24};
        //int [] A = {20,1,15,3,10,5,8};
        System.out.println(longestArithSeqLength(A));
    }


    public static int longestArithSeqLength(int[] A) {

        int len = A.length;
        int max = 1;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = 2;
                int diff = A[j] - A[i];
                // this loop is checking is there any element with the same distance
                for (int k = i - 1; k >= 0; k--) {
                    if (A[i] - A[k] == diff) {
                        dp[i][j] = Math.max(dp[i][j], dp[k][i] + 1);
                        break;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
