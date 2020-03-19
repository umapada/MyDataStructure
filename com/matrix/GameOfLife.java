package com.matrix;
/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by
the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight
neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is
created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

Input:
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output:
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
Follow up:

Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells
first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems
when the active area encroaches the border of the array. How would you address these problems?
 */

/*
Algorithm

Iterate the cells of the Board one by one.

The rules are computed and applied on the original board. The updated values signify both previous and updated value.

The updated rules can be seen as this:

Rule 1: Any live cell with fewer than two live neighbors dies, as if caused by under-population. Hence, change the value
of cell to -1. This means the cell was live before but now dead.

Rule 2: Any live cell with two or three live neighbors lives on to the next generation. Hence, no change in the value.

Rule 3: Any live cell with more than three live neighbors dies, as if by over-population. Hence, change the value of cell
to -1. This means the cell was live before but now dead. Note that we don't need to differentiate between the rule 1 and 3.
The start and end values are the same. Hence, we use the same dummy value.

Rule 4: Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction. Hence, change the value
of cell to 2. This means the cell was dead before but now live.

Apply the new rules to the board.

Since the new values give an indication of the old values of the cell, we accomplish the same results as approach 1 but without saving a copy.

To get the Board in terms of binary values i.e. live(1) and dead(0), we iterate the board again and change the value of a
cell to a 1 if its value currently is greater than 0 and change the value to a 0 if its current value is lesser than or equal to 0.


 */

public class GameOfLife {

    public void gameOfLife(int[][] board) {

        // Neighbors array to find 8 neighboring cells for a given cell
        int[] neighbors = {0, 1, -1};

        int rows = board.length;
        int cols = board[0].length;

        // Iterate through board cell by cell.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // For each cell count the number of live neighbors.
                int liveNeighbors = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);

                            // Check the validity of the neighboring cell.
                            // and whether it was originally a live cell.
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }

                // Rule 1 or Rule 3
                if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    // -1 signifies the cell is now dead but originally was live.
                    board[row][col] = -1;
                }
                // Rule 4
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    // 2 signifies the cell is now live but was originally dead.
                    board[row][col] = 2;
                }
            }
        }

        // Get the final representation for the newly updated board.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }
}

/*
Complexity Analysis

Time Complexity: O(M \times N)O(M×N), where MM is the number of rows and NN is the number of columns of the Board.

Space Complexity: O(1)O(1)
 */


/*
Follow up 2 : Infinite Board
So far we've only addressed one of the follow-up questions for this problem statement. We saw how to perform the simulation
according to the four rules in-place i.e. without using any additional memory. The problem statement also mentions another
follow-up statement which is a bit open ended. We will look at two possible solutions to address it. Essentially, the second
follow-up asks us to address the scalability aspect of the problem. What would happen if the board is infinitely large?
Can we still use the same solution that we saw earlier or is there something else we will have to do different? If the board
becomes infinitely large, there are multiple problems our current solution would run into:

It would be computationally impossible to iterate a matrix that large.
It would not be possible to store that big a matrix entirely in memory. We have huge memory capacities these days i.e. of
the order of hundreds of GBs. However, it still wouldn't be enough to store such a large matrix in memory.
We would be wasting a lot of space if such a huge board only has a few live cells and the rest of them are all dead. In
such a case, we have an extremely sparse matrix and it wouldn't make sense to save the board as a "matrix".
Such open ended problems are better suited to design discussions during programming interviews and it's a good habit to
take into consideration the scalability aspect of the problem since your interviewer might be interested in talking about
such problems. The discussion section already does a great job at addressing this specific portion of the problem. We will
briefly go over two different solutions that have been provided in the discussion sections, as they broadly cover two main scenarios of this problem.

One aspect of the problem is addressed by a great solution provided by Stefan Pochmann. So as mentioned before, it's quite
possible that we have a gigantic matrix with a very few live cells. In that case it would be stupidity to save the entire board as is.
 */