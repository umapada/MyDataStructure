package DynamicProgramming;

/*

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

 */

/*

Intuition

The reason why it failed with the brute-force approach is simply because we re-calculate the sub-solutions over and over again. However, the formula that we derived before is still valuable. All we need is a better way to implement the formula.

\text{numSquares}(n) = \min \Big(\text{numSquares(n-k) + 1}\Big) \qquad \forall k \in \{\text{square numbers}\}numSquares(n)=min(numSquares(n-k) + 1)∀k∈{square numbers}

One might notice that, the problem is similar to the Fibonacci number problem, judging from the formula. And like Fibonacci number, we have several more efficient ways to calculate the solution, other than the simple recursion.

One of the ideas to solve the stack overflow issue in recursion is to apply the Dynamic Programming (DP) technique, which is built upon the idea of reusing the results of intermediate sub-solutions to calculate the final solution.

To calculate the value of \text{numSquares}(n)numSquares(n), first we need to calculate all the values before nn, i.e. \text{numSquares}(n-k) \qquad \forall{k} \in\{\text{square numbers}\}numSquares(n−k)∀k∈{square numbers}. If we have already kept the solution for the number n-kn−k in somewhere, we then would not need to resort to the recursive calculation which prevents the stack overflow.

Algorithm

Based on the above intuition, we could implement the DP solution in the following steps.

As for almost all DP solutions, we first create an array dp of one or multiple dimensions to hold the values of intermediate sub-solutions, as well as the final solution which is usually the last element in the array. Note that, we create a fictional element dp[0]=0 to simplify the logic, which helps in the case that the remainder (n-k) happens to be a square number.
As an additional preparation step, we pre-calculate a list of square numbers (i.e. square_nums) that is less than the given number n.
As the main step, we then loop from the number 1 to n, to calculate the solution for each number i (i.e. numSquares(i)). At each iteration, we keep the result of numSquares(i) in dp[i], while resuing the previous results stored in the array.
At the end of the loop, we then return the last element in the array as the result of the solution.
 */

import java.util.Arrays;

class PerfectSquares {
    public int numSquares(int n) {


        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // bottom case
        dp[0] = 0;

        // pre-calculate the square numbers.
        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; ++i) {
            square_nums[i] = i * i;
        }

        for (int i = 1; i <= n; ++i) {
            for (int s = 1; s < max_square_index; ++s) {
                if (i < square_nums[s])
                    break;
                dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
            }
        }
        return dp[n];
    }
}