package com.matrix;
/*

Given an square matrix, turn it by 90 degrees in anti-clockwise direction without using any extra space.

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

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrixRotate90Degree {

    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();
        map.entrySet();

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
        displayMatrix(N,mat);

        int res[][] = roatate(mat);

        // Print rotated matrix
        displayMatrix(N,res);
    }
    // Function to print the matrix
    static void displayMatrix(int N, int mat[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);

            System.out.print("\n");
        }
        System.out.print("\n");
    }

    static int[][] roatate(int mat[][]){
        int[][] dest_buffer = new int[mat.length][mat[0].length];

        System.out.println(mat.length +" " + mat[0].length);

        for (int r = 0; r < mat.length; r++){
            for (int c = 0; c < mat[0].length; c++){
                dest_buffer [ r ] [ mat.length - c - 1 ] = mat [ c ] [ r ];
            }
        }


        return dest_buffer;

    }



}

