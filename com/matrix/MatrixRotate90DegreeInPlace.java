package com.matrix;

/*
Given an square matrix, turn it by 90 degrees in anti-clockwise direction without using any extra space.

Examples :

Input
 1  2  3
 4  5  6
 7  8  9

Output:
 3  6  9
 2  5  8
 1  4  7

Input:
 1  2  3  4
 5  6  7  8
 9 10 11 12
13 14 15 16

Output:
 4  8 12 16
 3  7 11 15
 2  6 10 14
 1  5  9 13

 */

public class MatrixRotate90DegreeInPlace {
/*
The idea is for each square cycle, we swap the elements involved with the corresponding cell in the matrix in anti-clockwise direction i.e. from top to left, left to bottom, bottom to right and from right to top one at a time. We use nothing but a temporary variable to achieve this.

Below steps demonstrate the idea

First Cycle (Involves Red Elements)
 1  2  3 4
 5  6  7  8
 9 10 11 12
 13 14 15 16


Moving first group of four elements (First
elements of 1st row, last row, 1st column
and last column) of first cycle in counter
clockwise.
 4  2  3 16
 5  6  7 8
 9 10 11 12
 1 14  15 13

Moving next group of four elements of
first cycle in counter clockwise
 4  8  3 16
 5  6  7  15
 2  10 11 12
 1  14  9 13

Moving final group of four elements of
first cycle in counter clockwise
 4  8 12 16
 3  6  7 15
 2 10 11 14
 1  5  9 13


Second Cycle (Involves Blue Elements)
 4  8 12 16
 3  6 7  15
 2  10 11 14
 1  5  9 13

Fixing second cycle
 4  8 12 16
 3  7 11 15
 2  6 10 14
 1  5  9 13
 */

    // An Inplace function to rotate a N x N matrix
    // by 90 degrees in anti-clockwise direction
    static void rotateMatrix(int N, int mat[][]) {
        //  ANTI-CLOCKWISE
        // Consider all squares one by one
//        for (int i = 0; i < N / 2; i++)
//        {
//            // Consider elements in group of 4 in
//            // current square
//            for (int j = i; j < N-i-1; j++)
//            {
//                // store current cell in temp variable
//                int temp = mat[i][j];
//
//                // move values from right to top
//                mat[i][j] = mat[j][N-1-i];
//
//                // move values from bottom to right
//                mat[j][N-1-i] = mat[N-1-i][N-1-j];
//
//                // move values from left to bottom
//                mat[N-1-i][N-1-j] = mat[N-1-j][i];
//
//                // assign temp to left
//                mat[N-1-j][i] = temp;
//            }
//        }

        //  CLOCKWISE

        // Traverse each cycle
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {
                // Swap elements of each cycle in clockwise direction
                int temp = mat[i][j];
                mat[i][j] = mat[N - 1 - j][i];
                mat[N - 1 - j][i] = mat[N - 1 - i][N - 1 - j];
                mat[N - 1 - i][N - 1 - j] = mat[j][N - 1 - i];
                mat[j][N - 1 - i] = temp;
            }
        }
    }

    // Function to print the matrix
    static void displayMatrix(int N, int mat[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        int N = 4;

        // Test Case 1
        int mat[][] =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                };


        // Tese Case 2
        /* int mat[][] = {
                            {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
                        };
         */

        // Tese Case 3
        /*int mat[][] = {
                        {1, 2},
                        {4, 5}
                    };*/

        // displayMatrix(mat);
        rotateMatrix(N, mat);
        // Print rotated matrix
        displayMatrix(N, mat);
    }

}

