package com.matrix;
/*
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.



Example 1:

Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
Example 2:

Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]


Note:

The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.
 */


import java.util.LinkedList;
import java.util.Queue;


/*
Solution:

For our BFS routine, we keep a queue, q to maintain the queue of cells to be examined next.
We start by adding all the cells with 0s to q.
Intially, distance for each 0 cell is 0 and distance for each 1 is INT_MAX, which is updated during the BFS.
Pop the cell from queue, and examine its neighbours. If the new calculated distance for neighbour {i,j} is smaller,
we add {i,j} to q and update dist[i][j].
*/

class Matrix_Distance_Zero {
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};

        Queue<Integer> q = new LinkedList<>();

        int[][] dist = new int[row][col];

        for(int i=0; i < row; i++)
            for(int j=0; j< col; j++){
                if(matrix[i][j] == 0){
                    dist[i][j]=0;
                    q.add(i*col+j);
                }else{
                    dist[i][j]=Integer.MAX_VALUE;
                }
            }

        while(!q.isEmpty()){
            int ele = q.remove();
            int cr = ele/col;
            int cc = ele % col;
            for(int [] d:direction){
                int nr = cr + d[0];
                int nc = cc + d[1];

                if(nr >=0 && nr < row && nc >=0 && nc < col && dist[nr][nc] > dist[cr][cc] + 1){
                    dist[nr][nc] = dist[cr][cc] + 1;
                    q.add(nr*col + nc);
                }
            }
        }
        return dist;
    }
}