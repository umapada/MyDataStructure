package com.matrix;

/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and
is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */


import java.util.ArrayDeque;
import java.util.Queue;

class NumberOfIslands {
    int direction[][] = {{0,1},{0, -1},{1,0},{-1,0}};
    int row, col;


    int numIslands(char[][] grid) {
        int count = 0;
        row = grid.length;
        if(row>0) {
            col = grid[0].length;
            for(int i=0; i<row; i++)
                for(int j=0; j<col; j++){
                    if(grid[i][j] == '1'){
                        count ++;
                        makeIsland(i,j,grid);
                    }
                }
        }
        return count;
    }

    void makeIsland(int i, int j, char[][] grid){
        Queue<int[]> q = new ArrayDeque();
        int [] temp = {i,j};
        q.add(temp);
        grid[i][j] = '2';
        while(!q.isEmpty()){
            int[] ele = q.remove();
            int a = ele[0];
            int b = ele[1];
            for(int[] d:direction){
                int pp = a + d[0];
                int qq = b + d[1];
                if(0<= pp && pp < row && 0<= qq && qq < col && grid[pp][qq] == '1'){
                    grid[pp][qq] = '2';
                    int tmp [] = new int[2];
                    tmp[0]=pp;
                    tmp[1]=qq;
                    q.add(tmp);
                }
            }
        }
    }
}