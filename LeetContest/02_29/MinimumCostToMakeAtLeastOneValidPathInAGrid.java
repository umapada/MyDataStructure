
/*
Given a m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit if you are currently in
this cell. The sign of grid[i][j] can be:
1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
Notice that there could be some invalid signs on the cells of the grid which points outside the grid.

You will initially start at the upper left cell (0,0). A valid path in the grid is a path which starts from the upper
left cell (0,0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid. The valid path doesn't have to be the shortest.

You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.

Return the minimum cost to make the grid have at least one valid path.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Example 1: The path to (3, 3) is as follows. (0, 0) --> (0, 1) --> (0, 2) --> (0, 3) change the arrow to down with
cost = 1 --> (1, 3) --> (1, 2) --> (1, 1) --> (1, 0) change the arrow to down with cost = 1 --> (2, 0) --> (2, 1) -->
(2, 2) --> (2, 3) change the arrow to down with cost = 1 --> (3, 3)

See Image : grid1.png

Example 2:
Input: grid = [[1,1,3],[3,2,2],[1,1,4]]
Output: 0
Explanation: You can follow the path from (0, 0) to (2, 2).
See Iamge: grid2.png

Example 3:
Input: grid = [[1,2],[4,3]]
Output: 1
See Image: grid3.png

Example 4:

Input: grid = [[2,2,2],[2,2,2]]
Output: 3
Example 5:

Input: grid = [[4]]
Output: 0


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100

 */
public class MinimumCostToMakeAtLeastOneValidPathInAGrid {

    class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int minCost( int [][] grid){
        int [][] dir = {{0,1},{0,-1}, {1,0},{-1,0}};
        int [][]cost = new int[grid.length][grid[0].length];
        for(int [] cst: cost) Arrays.fill(cst, Integer.MAX_VALUE);
        Queue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(p -> cost[p.y][p.x]));
        cost[0][0] = 0;
        Point p = new Point(0,0);
        pq.add(p);

        while (!pq.isEmpty()){
            Point current = pq.poll();
            int direction = grid[current.y][current.x] - 1;
                for(int i=0; i < dir.length; i ++){
                    int targetX = current.x + dir[i][1];
                    int targetY = current.y + dir[i][0];
                    // Points going beyond grid
                    if(targetX >= grid[0].length || targetX < 0 || targetY >= grid.length || targetY < 0)
                        continue;
                    // Going in same direction
                    if(i == direction && cost[targetY][targetX] > cost[current.y][current.x] ){
                        cost[targetY][targetX] = cost[current.y][current.x];
                        pq.add(new Point(targetX, targetY));
                    //
                    }else if (cost[targetY][targetX] > cost[current.y][current.x] + 1){
                        cost[targetY][targetX] = cost[current.y][current.x] + 1;
                        pq.add(new Point(targetX, targetY));
                    }
                 }
        }

        return cost[grid.length-1] [grid[0].length-1];
    }

}
