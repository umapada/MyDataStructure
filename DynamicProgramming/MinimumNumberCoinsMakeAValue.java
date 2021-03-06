package DynamicProgramming;

/**
 * Find minimum number of coins that make a given value
 * Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins to make the change?
 * Examples:
 *
 * Input: coins[] = {25, 10, 5}, V = 30
 * Output: Minimum 2 coins required
 * We can use one coin of 25 cents and one of 5 cents
 *
 * Input: coins[] = {9, 6, 5, 1}, V = 11
 * Output: Minimum 2 coins required
 * We can use one coin of 6 cents and 1 coin of 5 cents
 */

/**
 * This problem is a variation of the problem discussed Coin Change Problem. Here instead of finding total number of possible solutions, we need to find the solution with minimum number of coins.
 *
 * The minimum number of coins for a value V can be computed using below recursive formula.
 *
 * If V == 0, then 0 coins required.
 * If V > 0
 *    minCoins(coins[0..m-1], V) = min {1 + minCoins(V-coin[i])}
 *                                where i varies from 0 to m-1
 *                                and coin[i] <= V
 * Below is recursive solution based on above recursive formula.
 */

// A Naive recursive JAVA program to find minimum of coins
// to make a given change V
class MinimumNumberCoinsMakeAValue
{
    // m is size of coins array (number of different coins)
    static int minCoins(int coins[], int m, int V)
    {
        // base case
        if (V == 0) return 0;

        // Initialize result
        int res = Integer.MAX_VALUE;

        // Try every coin that has smaller value than V
        for (int i=0; i<m; i++)
        {
            if (coins[i] <= V)
            {
                int sub_res = minCoins(coins, m, V-coins[i]);

                // Check for INT_MAX to avoid overflow and see if
                // result can minimized
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
                    res = sub_res + 1;
            }
        }
        return res;
    }
    public static void main(String args[])
    {
        int coins[] = {9, 6, 5, 1};
        int m = coins.length;
        int V = 11;
        System.out.println("Minimum coins required is "+ minCoins(coins, m, V) );
    }
}/* This code is contributed by Rajat Mishra */


/**
 * The time complexity of above solution is exponential. If we draw the complete recursion tree, we can observer that many subproblems are solved again and again. For example, when we start from V = 11, we can reach 6 by subtracting one 5 times and by subtracting 5 one times. So the subproblem for 6 is called twice.
 * Since same suproblems are called again, this problem has Overlapping Subprolems property. So the min coins problem has both properties (see this and this) of a dynamic programming problem. Like other typical Dynamic Programming(DP) problems, recomputations of same subproblems can be avoided by constructing a temporary array table[][] in bottom up manner. Below is Dynamic Programming based solution.
 */

// A Dynamic Programming based Java
// program to find minimum of coins
// to make a given change V

class MinimumNumberCoinsMakeAValue2
{
    // m is size of coins array
    // (number of different coins)
    static int minCoins(int coins[], int m, int V)
    {
        // table[i] will be storing
        // the minimum number of coins
        // required for i value. So
        // table[V] will have result
        int table[] = new int[V + 1];

        // Base case (If given value V is 0)
        table[0] = 0;

        // Initialize all table values as Infinite
        for (int i = 1; i <= V; i++)
            table[i] = Integer.MAX_VALUE;

        // Compute minimum coins required for all
        // values from 1 to V
        for (int i = 1; i <= V; i++)
        {
            // Go through all coins smaller than i
            for (int j = 0; j < m; j++)
                if (coins[j] <= i)
                {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE
                            && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;


                }

        }
        return table[V];

    }

    // Driver program
    public static void main (String[] args)
    {
        int coins[] = {9, 6, 5, 1};
        int m = coins.length;
        int V = 11;
        System.out.println ( "Minimum coins required is "
                + minCoins(coins, m, V));
    }
}

//This Code is contributed by vt_m.
//Time complexity of the above solution is O(mV).