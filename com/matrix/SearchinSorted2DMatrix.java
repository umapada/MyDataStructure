package com.matrix;
/*
Search an element in a 2D array (matrix) sorted row-wise and col-wise
Linear search is O(N2) for an N by N matrix but doing that would mean that we are not using the sorted property of the matrix. We cannot apply binary search considering the matrix to be one array of length NxN because sorting is only per row and per column i.e. the matrix could have the following form:

   01   06    09

   03   08    12

   05   10    14

So we need to apply binary search in a different way.

Start from matrix[0][N] and use the following algorithm:
 */

public class SearchinSorted2DMatrix {

    public static void main(String[] args) {

    }

    static boolean search(int [][] matrix, int searchEle) {
        int N = matrix.length;
        int i = 0;
        int j = N - 1;

        while (i < N && j >= 0) {
            if (matrix[i][j] == searchEle)
                return true;
            if (matrix[i][j] < searchEle)
                i++;
            else
                j--;
        }
        return false;
    }

}
