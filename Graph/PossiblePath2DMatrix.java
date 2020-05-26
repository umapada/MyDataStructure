package Graph;

/**
 * Check for possible path in 2D matrix
 * Given a 2D array(m x n). The task is to check if there is any path from top left to bottom right. In the matrix,
 * -1 is considered as blockage (can’t go through this cell) and 0 is considered path cell (can go through it).
 *
 * Note: Top left cell always contains 0
 *
 * Examples:
 *
 *
 *
 * Input : arr[][] = {{ 0, 0, 0, -1, 0},
 *                   {-1, 0, 0, -1, -1},
 *                   { 0, 0, 0, -1, 0},
 *                   {-1, 0, 0,  0, 0},
 *                   { 0, 0, -1,  0, 0}}
 * Output : Yes
 *
 * Input : arr[][] = {{ 0, 0, 0, -1, 0},
 *                   {-1, 0, 0, -1, -1},
 *                   { 0, 0, 0, -1, 0},
 *                   {-1, 0, -1,  0, 0},
 *                   { 0, 0, -1,  0, 0}}
 * Output : No
 */

/**
 * A simple solution is to do BFS or DFS to find if there is a path.
 *
 * A better solution is to mark all accessible nodes by changing their value to 1. First, change the value of the first
 * top left element value to 1. Then get the next (current) value in the first row and compare to the previous value.
 * Set this current value equal to the previous value only if it is reachable (not equal to -1). Similarly, do the same
 * for column values, by comparing and setting the current with the previous column’s value if it is reachable.
 * Then start from the first-row & first column and take the values of previous row & the previous column. Find the max
 * between them, and set the current index to that max. If the current index value is -1 then there’s no change.
 * In the end, if the final index at right bottom is 1 then return yes else return no.
 */


public class PossiblePath2DMatrix {

    // to find the path from top left to bottom right
    static boolean isPath(int arr[][])
    {
        // set arr[0][0] = 1
        arr[0][0] = 1;

        // Mark reachable (from top left) nodes in first row and first column.
        for (int i = 1; i < 5; i++)
            if (arr[0][i] != -1)
                arr[0][i] = arr[0][i - 1];
        for (int j = 1; j < 5; j++)
            if (arr[j][0] != -1)
                arr[j][0] = arr[j - 1][0];

        // Mark reachable nodes in remaining matrix.
        for (int i = 1; i < 5; i++)
            for (int j = 1; j < 5; j++)
                if (arr[i][j] != -1)
                    arr[i][j] = Math.max(arr[i][j - 1],
                            arr[i - 1][j]);

        // return yes if right bottom index is 1
        return (arr[5 - 1][5 - 1] == 1);
    }

    //Driver code
    public static void main(String[] args)
    {
        // Given array
        int arr[][] = { { 0, 0, 0, -1, 0 },
                { -1, 0, 0, -1, -1 },
                { 0, 0, 0, -1, 0 },
                { -1, 0, -1, 0, -1 },
                { 0, 0, -1, 0, 0 } };

        // path from arr[0][0] to arr[row][col]
        if (isPath(arr))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
