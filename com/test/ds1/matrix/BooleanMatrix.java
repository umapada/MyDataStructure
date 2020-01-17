package com.test.ds1.matrix;

/*

 A Boolean Matrix Question
Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1
(or true) then make all the cells of ith row and jth column as 1.

Example 1
The matrix
1 0
0 0
should be changed to following
1 1
1 0

Example 2
The matrix
0 0 0
0 0 1
should be changed to following
0 0 1
1 1 1

Example 3
The matrix
1 0 0 1
0 0 1 0
0 0 0 0
should be changed to following
1 1 1 1
1 1 1 1
1 0 1 1

*/

//Important
public class BooleanMatrix {
/*
This method is a space optimized version of above method 1. This method uses the first row and first column of
the input matrix in place of the auxiliary arrays row[] and col[] of method 1. So what we do is: first take
care of first row and column and store the info about these two in two flag variables rowFlag and colFlag.
Once we have this info, we can use first row and first column as auxiliary arrays and apply method 1 for
submatrix (matrix excluding first row and first column) of size (M-1)*(N-1).

1) Scan the first row and set a variable rowFlag to indicate whether we need to set all 1s in first row or not.
2) Scan the first column and set a variable colFlag to indicate whether we need to set all 1s in first column or not.
3) Use first row and first column as the auxiliary arrays row[] and col[] respectively, consider the matrix as
    submatrix starting from second row and second column and apply method 1.
4) Finally, using rowFlag and colFlag, update first row and first column if needed.

    Time Complexity: O(M*N)
    Auxiliary Space: O(1)
*/


    public static void modifyMatrix(int mat[][]){

        // variables to check if there are any 1
        // in first row and column
        boolean row_flag = false;
        boolean col_flag = false;

        // updating the first row and col if 1
        // is encountered
        for (int i = 0; i < mat.length; i++ ){
            for (int j = 0; j < mat[0].length; j++){
                if (i == 0 && mat[i][j] == 1)
                    row_flag = true;

                if (j == 0 && mat[i][j] == 1)
                    col_flag = true;

                if (mat[i][j] == 1){

                    mat[0][j] = 1;
                    mat[i][0] = 1;
                }

            }
        }

        // Modify the input matrix mat[] using the
        // first row and first column of Matrix mat
        for (int i = 1; i < mat.length; i ++){
            for (int j = 1; j < mat[0].length; j ++){

                if (mat[0][j] == 1 || mat[i][0] == 1){
                    mat[i][j] = 1;
                }
            }
        }

        // modify first row if there was any 1
        if (row_flag == true){
            for (int i = 0; i < mat[0].length; i++){
                mat[0][i] = 1;
            }
        }

        // modify first col if there was any 1
        if (col_flag == true){
            for (int i = 0; i < mat.length; i ++){
                mat[i][0] = 1;
            }
        }
    }



    /* A utility function to print a 2D matrix */
    public static void printMatrix(int mat[][]){
        for (int i = 0; i < mat.length; i ++){
            for (int j = 0; j < mat[0].length; j ++){
                System.out.print( mat[i][j] );
            }
            System.out.println("");
        }
    }

    // Driver function to test the above function
    public static void main(String args[] ){

        int mat[][] = {{1, 0, 0, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 0}};



        System.out.println("Input Matrix :");
        printMatrix(mat);

        modifyMatrix(mat);

        System.out.println("Matrix After Modification :");
        printMatrix(mat);

    }

}
