package Backtrack;
/*
In chess, a queen can move as far as she pleases, horizontally, vertically, or diagonally. A chess board has
8 rows and 8 columns. The standard 8 by 8 Queen’s problem asks how to place 8 queens on an ordinary chess board so
that none of them can hit any other in one move.(Source: http://www.math.utah.edu/~alfeld/queens/queens.html)
 */


public class NQueensProblem {
    public int[][] solution;

    public NQueensProblem(int N) {
        solution = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                solution[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int N = 4;
        NQueensProblem q = new NQueensProblem(N);
        q.solve(N);

    }

    public void solve(int N) {
        if (placeQueens(0, N)) {
            //print the result
          /*  for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(" " + solution[i][j]);
                }
                System.out.println();
            } */
            System.out.println("SOLUTION EXISTS");
        } else {
            System.out.println("NO SOLUTION EXISTS");
        }
    }

    public boolean placeQueens(int queen, int N) {
        // will place the Queens one at a time, for column wise
        if (queen == N) {
            //if we are here that means we have solved the problem
            return true;
        }
        for (int row = 0; row < N; row++) {
            // check if queen can be placed row,col
            if (canPlace(solution, row, queen)) {
                // place the queen
                solution[row][queen] = 1;
                // solve  for next queen
                if (placeQueens(queen + 1, N)) {
                    return true;
                }
                //if we are here that means above placement didn't work
                //BACKTRACK
                solution[row][queen] = 0;
            }
        }
        //if we are here that means we haven't found solution
        return false;

    }

    // check if queen can be placed at matrix[row][column]
    public boolean canPlace(int[][] matrix, int row, int column) {
        // since we are filling one column at a time, we will check if no queen is placed in that particular row
        //Check the row
        for (int i = 0; i < column; i++) {
            if (matrix[row][i] == 1) {
                return false;
            }
        }
        // we are filling one column at a time,so we need to check the upper and diagonal as well check upper diagonal
        //Upper diagonal
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (matrix[i][j] == 1) {
                return false;
            }
        }
        // check lower diagonal
        for (int i = row, j = column; i < matrix.length && j >= 0; i++, j--) {
            if (matrix[i][j] == 1) {
                return false;
            }
        }
        // if we are here that means we are safe to place Queen at row,column
        return true;
    }

}