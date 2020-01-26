package com.test.ds1.matrix;

/**
 * Find whether there is path between two cells in matrix
 * Given N X N matrix filled with 1 , 0 , 2 , 3 . Find whether there is a path possible from source to destination,
 * traversing through blank cells only. You can traverse up, down, right and left.
 *
 * A value of cell 1 means Source.
 * A value of cell 2 means Destination.
 * A value of cell 3 means Blank cell.
 * A value of cell 0 means Blank Wall.
 * Note : there is only single source and single destination(sink).
 *
 * Examples:
 *
 *
 *
 * Input : M[3][3] = {{ 0 , 3 , 2 },
 *                    { 3 , 3 , 0 },
 *                    { 1 , 3 , 0 }};
 * Output : Yes
 *
 * Input : M[4][4] = {{ 0 , 3 , 1 , 0 },
 *                    { 3 , 0 , 3 , 3 },
 *                    { 2 , 3 , 0 , 3 },
 *                    { 0 , 3 , 3 , 3 }};
 * Output : Yes
 */

/**
 * Simple solution is that find the source index of cell in matrix and then recursively find a path from source index
 * to destination in matrix .
 * algorithm :
 *
 * Find source index in matrix , let we consider ( i , j )
 * After that Find path from source(1) to sink(2)
 * FindPathUtil ( M[][N] , i  , j )
 *
 *    IF we seen M[i][j] == 0 (wall) ||
 *       ((i, j) is out of matrix index)
 *      return false ;
 *    IF we seen destination M[i][j] == 2
 *      return true ;
 *
 *    Next move in path by traverse all 4 adjacent cell of current cell
 *    IF (FindPathUtil(M[][N], i+1, j) ||
 *        FindPathUtil(M[][N], i-1, j) ||
 *        FindPathUtil(M[][N], i, j+1) ||
 *        FindPathUtil(M[][N], i, j-1));
 *       return true ;
 *
 *  return false ;
 */
public class FindWhetherPathExist {

    // method for finding and printing whether the path exists or not
    public static void isPath(int matrix[][], int n)
    {
        // defining visited array to keep track of already visited indexes
        boolean visited[][] = new boolean[n][n];

        // flag to indicate whether the path exists or not
        boolean flag=false;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                // if matrix[i][j] is source and it is not visited
                if(matrix[i][j]==1 && !visited[i][j])

                    // starting from i, j and then finding the path
                    if(isPath(matrix, i, j, visited))
                    {
                        flag=true; // if path exists
                        break;
                    }
            }
        }
        if(flag)
            System.out.println("YES");
        else
            System.out.println("NO");
    }


    // method for checking boundries
    public static boolean isSafe(int i, int j, int matrix[][])
    {

        if(i>=0 && i<matrix.length && j>=0  && j<matrix[0].length)
            return true;

        return false;
    }

    // Returns true if there is a path from a source (a cell with value 1) to a destination (a cell with value 2)
    public static boolean isPath(int matrix[][],
                                 int i, int j, boolean visited[][]){

        // checking the boundries, walls and whether the cell is unvisited
        if(isSafe(i, j, matrix) && matrix[i][j]!=0  && !visited[i][j])
        {
            // make the cell visited
            visited[i][j]=true;

            // if the cell is the required destination then return true
            if(matrix[i][j]==2)
                return true;

            // traverse up
            boolean up = isPath(matrix, i-1, j, visited);

            // if path is found in up direction return true
            if(up)
                return true;

            // traverse left
            boolean left = isPath(matrix, i, j-1, visited);

            // if path is found in left direction return true
            if(left)
                return true;

            //traverse down
            boolean down = isPath(matrix, i+1, j, visited);

            // if path is found in down direction return true
            if(down)
                return true;

            // traverse right
            boolean right = isPath(matrix, i, j+1, visited);

            // if path is found in right direction return true
            if(right)
                return true;
        }
        return false; // no path has been found
    }

    // driver program to check above function

    public static void main (String[] args) {

        int matrix[][] = {{0, 3, 0, 1},
                {3, 0, 3, 3},
                {2, 3, 3, 3},
                {0, 3, 3, 3}};

        isPath(matrix, 4);                 // calling isPath method
    }
}
