package DynamicProgramming;

/**
 * The following is a description of the instance of this famous puzzle involving n=2 eggs and a building with k=36 floors.
 * Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from, and which will cause
 * the eggs to break on landing. We make a few assumptions:
 *
 * …..An egg that survives a fall can be used again.
 * …..A broken egg must be discarded.
 * …..The effect of a fall is the same for all eggs.
 * …..If an egg breaks when dropped, then it would break if dropped from a higher floor.
 * …..If an egg survives a fall then it would survive a shorter fall.
 * …..It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause an egg to break.
 *
 * If only one egg is available and we wish to be sure of obtaining the right result, the experiment can be carried out
 * in only one way. Drop the egg from the first-floor window; if it survives, drop it from the second floor window.
 * Continue upward until it breaks. In the worst case, this method may require 36 droppings. Suppose 2 eggs are available.
 * What is the least number of egg-droppings that is guaranteed to work in all cases?
 * The problem is not actually to find the critical floor, but merely to decide floors from which eggs should be dropped
 * so that total number of trials are minimized.
 */

/**
 * When we drop an egg from a floor x, there can be two cases (1) The egg breaks (2) The egg doesn’t break.
 *
 * 1) If the egg breaks after dropping from xth floor, then we only need to check for floors lower than x with remaining
 * eggs; so the problem reduces to x-1 floors and n-1 eggs
 * 2) If the egg doesn’t break after dropping from the xth floor, then we only need to check for floors higher than x;
 * so the problem reduces to k-x floors and n eggs.
 *
 * Since we need to minimize the number of trials in worst case, we take the maximum of two cases. We consider the max
 * of above two cases for every floor and choose the floor which yields minimum number of trials.
 *
 *   k ==> Number of floors
 *   n ==> Number of Eggs
 *   eggDrop(n, k) ==> Minimum number of trials needed to find the critical
 *                     floor in worst case.
 *   eggDrop(n, k) = 1 + min{min, max(eggDrop(n - 1, x - 1), eggDrop(n, k - x)):
 *                  x in {1, 2, ..., k}}
 */

public class EggDroppingPuzzle {

    // Driver code
    public static void main(String args[])
    {
        int n = 2, k = 30;
        System.out.print("Minimum number of trials in worst case with  eggs and " + k + " floors is " + eggDrop(n, k));
    }

    /* Function to get minimum number of trials needed in worst case with n eggs and k floors */
    static int eggDrop(int n, int k)
    {
        // If there are no floors, then no trials needed. OR if there is one floor, one trial needed.
        if (k == 1 || k == 0)
            return k;

        // We need k trials for one egg and k floors
        if (n == 1)
            return k;

        int min = Integer.MAX_VALUE, x;

        // Consider all droppings from 1st floor to kth floor and return the minimum of these values plus 1.
        for (x = 1; x <= k; x++)
        {
            min = Math.min(min, Math.max(eggDrop(n-1, x-1), eggDrop(n, k-x)));
        }
        return min + 1;
    }


    /**
     * It should be noted that the above function computes the same subproblems again and again. See the following
     * partial recursion tree, E(2, 2) is being evaluated twice. There will many repeated subproblems when you draw the
     * complete recursion tree even for small values of n and k.
     *
     *
     *                          E(2,4)
     *                            |
     *           -------------------------------------
     *           |             |           |         |
     *           |             |           |         |
     *       x=1/          x=2/      x=3/     x=4/
     *         /             /         ....      ....
     *        /             /
     *  E(1,0)  E(2,3)     E(1,1)  E(2,2)
     *           /  /...         /
     *       x=1/                 .....
     *         /
     *      E(1,0)  E(2,2)
     *             /
     *             ......
     *
     * Partial recursion tree for 2 eggs and 4 floors.
     * Since same suproblems are called again, this problem has Overlapping Subprolems property. So Egg Dropping Puzzle
     * has both properties (see this and this) of a dynamic programming problem. Like other typical Dynamic
     * Programming(DP) problems, recomputations of same subproblems can be avoided by constructing a temporary array
     * eggFloor[][] in bottom up manner.
     *
     * Dynamic Programming Solution
     * Following are the implementations for Egg Dropping problem using Dynamic Programming.
     */


    // A utility function to get maximum of two integers
    static int max(int a, int b) { return (a > b)? a: b; }

    /* Function to get minimum number of trials needed in worst case with n eggs and k floors */
    static int eggDrop2(int n, int k)
    {
       /* A 2D table where entry eggFloor[i][j] will represent minimum number of trials needed for i eggs and j floors. */
        int eggFloor[][] = new int[n+1][k+1];
        int res;
        int i, j, x;

        // We need one trial for one floor and 0 trials for 0 floors
        for (i = 1; i <= n; i++)
        {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }

        // We always need j trials for one egg and j floors.
        for (j = 1; j <= k; j++)
            eggFloor[1][j] = j;

        // Fill rest of the entries in table using optimal substructure property
        for (i = 2; i <= n; i++)
        {
            for (j = 2; j <= k; j++)
            {
                eggFloor[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++)
                {
                    res = 1 + max(eggFloor[i-1][x-1], eggFloor[i][j-x]);
                    if (res < eggFloor[i][j])
                        eggFloor[i][j] = res;
                }
            }
        }

        // eggFloor[n][k] holds the result
        return eggFloor[n][k];

    }


    /**
     * Time Complexity: O(nk^2)
     * Auxiliary Space: O(nk)
     */
}
