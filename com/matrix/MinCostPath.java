package com.matrix;

/*

Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost
path to reach (m, n) from (0, 0). Each cell of the matrix represents a cost to traverse through that cell. Total cost
of a path to reach (m, n) is sum of all the costs on that path (including both source and destination). You can only
traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j),
(i, j+1) and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.

 */

/*
1) Optimal Substructure
The path to reach (m, n) must be through one of the 3 cells: (m-1, n-1) or (m-1, n) or (m, n-1). So minimum cost to
reach (m, n) can be written as “minimum of the 3 cells plus cost[m][n]”.

minCost(m, n) = min (minCost(m-1, n-1), minCost(m-1, n), minCost(m, n-1)) + cost[m][n]

2) Overlapping Subproblems
Following is simple recursive implementation of the MCP (Minimum Cost Path) problem. The implementation simply follows
the recursive structure mentioned above.
 */

/* A Naive recursive implementation of
MCP(Minimum Cost Path) problem */
class MinCostPath {
    /* A utility function that returns minimum of 3 integers */
    static int min(int x, int y, int z)
    {
        if (x < y)
            return (x < z) ? x : z;
        else
            return (y < z) ? y : z;
    }
    /* Returns cost of minimum cost path from (0,0) to (m, n) in mat[R][C]*/
    static int minCost(int cost[][], int m, int n)
    {
    if (n < 0 || m < 0)
        return Integer.MAX_VALUE;
    else if (m == 0 && n == 0)
        return cost[m][n];
    else
        return cost[m][n] + min( minCost(cost, m-1, n-1), minCost(cost, m-1, n), minCost(cost, m, n-1));
    }
    // Driver code
    public static void main(String args[])
    {
        int cost[][] = { {1, 2, 3,4,6,7,2,3,1, 2, 3,4,6,7,2,3},
                         {4, 8, 2,4,6,7,2,3,1, 2, 3,4,6,7,2,3},
                        {0, 5, 3,4,1,7,2,3,1, 2, 3,4,6,7,2,3},
                        {1, 5, 3,4,6,7,2,3,1, 0, 3,4,6,7,2,3},
                        {1, 5, 3,4,1,7,2,3,1, 2, 3,4,0,7,2,3},
                        {1, 5, 3,4,6,7,2,3,1, 2, 3,4,6,7,2,3},
                        {1, 2, 3,4,6,7,2,3,1, 2, 3,4,6,7,2,3},
                        {4, 8, 2,4,6,7,2,3,1, 2, 3,4,6,7,2,3},
                        {0, 5, 3,4,1,7,2,3,1, 2, 3,4,6,7,2,3},
                        {1, 5, 3,4,6,7,2,3,1, 0, 3,4,6,7,2,3},
                        {1, 5, 3,4,1,7,2,3,1, 2, 3,4,0,7,2,3},
                        {1, 5, 3,4,6,7,2,3,1, 2, 3,4,6,7,2,3}};
        System.out.print(minCost(cost, 10, 15));
    }
}

/*

It should be noted that the above function computes the same subproblems again and again. See the following recursion
tree, there are many nodes which apear more than once. Time complexity of this naive recursive solution is exponential
and it is terribly slow.

mC refers to minCost()
                                    mC(2, 2)
                          /            |           \
                         /             |            \
                 mC(1, 1)           mC(1, 2)             mC(2, 1)
              /     |     \       /     |     \           /     |     \
             /      |      \     /      |      \         /      |       \
       mC(0,0) mC(0,1) mC(1,0) mC(0,1) mC(0,2) mC(1,1) mC(1,0) mC(1,1) mC(2,0)

So the MCP problem has both properties (see this and this) of a dynamic programming problem. Like other typical Dynamic
Programming(DP) problems, recomputations of same subproblems can be avoided by constructing a temporary array tc[][] in
bottom up manner.

 */

/* Java program for Dynamic Programming implementation
of Min Cost Path problem */

class MinimumCostPath
{
    /* A utility function that returns minimum of 3 integers */
    private static int min(int x, int y, int z)
    {
        if (x < y)
            return (x < z)? x : z;
        else
            return (y < z)? y : z;
    }

    private static int minCost(int cost[][], int m, int n)
    {
        int i, j;
        int tc[][]=new int[m+1][n+1];
        tc[0][0] = cost[0][0];

        /* Initialize first column of total cost(tc) array */
        for (i = 1; i <= m; i++)
            tc[i][0] = tc[i-1][0] + cost[i][0];

        /* Initialize first row of tc array */
        for (j = 1; j <= n; j++)
            tc[0][j] = tc[0][j-1] + cost[0][j];

        /* Construct rest of the tc array */
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
                tc[i][j] = min(tc[i-1][j-1], tc[i-1][j], tc[i][j-1]) + cost[i][j];

        return tc[m][n];
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int cost[][] = { {1, 2, 3,4,6,7,2,3,1, 2, 3,4,6,7,2,3},
                {4, 8, 2,4,6,7,2,3,1, 2, 3,4,6,7,2,3},
                {0, 5, 3,4,1,7,2,3,1, 2, 3,4,6,7,2,3},
                {1, 5, 3,4,6,7,2,3,1, 0, 3,4,6,7,2,3},
                {1, 5, 3,4,1,7,2,3,1, 2, 3,4,0,7,2,3},
                {1, 5, 3,4,6,7,2,3,1, 2, 3,4,6,7,2,3},
                {1, 2, 3,4,6,7,2,3,1, 2, 3,4,6,7,2,3},
                {4, 8, 2,4,6,7,2,3,1, 2, 3,4,6,7,2,3},
                {0, 5, 3,4,1,7,2,3,1, 2, 3,4,6,7,2,3},
                {1, 5, 3,4,6,7,2,3,1, 0, 3,4,6,7,2,3},
                {1, 5, 3,4,1,7,2,3,1, 2, 3,4,0,7,2,3},
                {1, 5, 3,4,6,7,2,3,1, 2, 3,4,6,7,2,3}};
        System.out.println(minCost(cost,10,15));
    }
}
