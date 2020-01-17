package com.test.ds1.matrix.RottenOranges;




//Java program to find minimum time required to make all
//oranges rotten

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 which has the
 * following meaning:
 * 0: Empty cell
 *
 * 1: Cells have fresh oranges
 *
 * 2: Cells have rotten oranges
 * So we have to determine what is the minimum time required so that all the oranges become rotten.
 * A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1]
 * (up, down, left and right). If it is impossible to rot every orange then simply return -1.
 *
 * Examples:
 *
 *
 *
 * Input:  arr[][C] = { {2, 1, 0, 2, 1},
 *                      {1, 0, 1, 2, 1},
 *                      {1, 0, 0, 2, 1}};
 * Output:
 * All oranges can become rotten in 2 time frames.
 *
 *
 * Input:  arr[][C] = { {2, 1, 0, 2, 1},
 *                      {0, 0, 1, 2, 1},
 *                      {1, 0, 0, 2, 1}};
 * Output:
 * All oranges cannot be rotten.
 */


/**
 * Solution
 *
 *
 * The idea is to user Breadth First Search. Below is algorithm.
 *
 * 1) Create an empty Q.
 * 2) Find all rotten oranges and enqueue them to Q. Also enqueue a delimiter to indicate the beginning of
 * next time frame.
 * 3) While Q is not empty do following
 * ….3.a) Do following while delimiter in Q is not reached
 * …….. (i) Dequeue an orange from the queue, rot all adjacent oranges. While rotting the adjacent, make sure
 * that the time frame is incremented only once. And the time frame is not incremented if there are no adjacent oranges.
 * ….3.b) Dequeue the old delimiter and enqueue a new delimiter. The oranges rotten in the previous time frame
 * lie between the two delimiters.
 *
 */



public class RottenOranges
{
    public final static int R = 3;
    public final static int C = 5;

    // structure for storing coordinates of the cell
    static class Ele
    {
        int x = 0;
        int y = 0;
        Ele(int x,int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    // Drive program
    public static void main(String[] args)
    {
        int arr[][] = { {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        int ans = rotOranges(arr);
        if(ans == -1)
            System.out.println("All oranges cannot rot");
        else
            System.out.println("Time required for all oranges to rot = " + ans);


//        List<Integer> llist = new ArrayList<>();
//
//        llist.add(2);
//        llist.remove(0);
//
//        Queue<Integer> queue = new LinkedList<>();
//
//        queue.add(4);
//        queue.remove(4);
//
//        List<Integer> list = new LinkedList<>();
//
//        list.add(2);
//        list.add(3);
//        list.add(4);
//
//        list.remove("2");

    }

    // function to check whether a cell is valid / invalid
    static boolean isValid(int i, int j)
    {
        return (i >= 0 && j >= 0 && i < R && j < C);
    }


    // Function to check whether the cell is delimiter
    // which is (-1, -1)
    static boolean isDelim(Ele temp)
    {
        return (temp.x == -1 && temp.y == -1);
    }

    // Function to check whether there is still a fresh
    // orange remaining
    static boolean checkAll(int arr[][])
    {
        for (int i=0; i<R; i++)
            for (int j=0; j<C; j++)
                if (arr[i][j] == 1)
                    return true;
        return false;
    }

    // This function finds if it is possible to rot all oranges or not.
    // If possible, then it returns minimum time required to rot all,
    // otherwise returns -1
    static int rotOranges(int arr[][])
    {
        // Create a queue of cells
        Queue<Ele> Q=new LinkedList<>();
        Ele temp;
        int ans = 0;
        // Store all the cells having rotten orange in first time frame
        for (int i=0; i < R; i++)
            for (int j=0; j < C; j++)
                if (arr[i][j] == 2)
                    Q.add(new Ele(i,j));

        // Separate these rotten oranges from the oranges which will rotten
        // due the oranges in first time frame using delimiter which is (-1, -1)
        Q.add(new Ele(-1,-1));

        // Process the grid while there are rotten oranges in the Queue
        while(!Q.isEmpty())
        {
            // This flag is used to determine whether even a single fresh
            // orange gets rotten due to rotten oranges in the current time
            // frame so we can increase the count of the required time.
            boolean flag = false;

            // Process all the rotten oranges in current time frame.
            while(!isDelim(Q.peek()))
            {
                temp = Q.peek();

                // Check right adjacent cell that if it can be rotten
                if(isValid(temp.x+1, temp.y) && arr[temp.x+1][temp.y] == 1)
                {
                    if(!flag)
                    {
                        // if this is the first orange to get rotten, increase
                        // count and set the flag.
                        ans++;
                        flag = true;
                    }
                    // Make the orange rotten
                    arr[temp.x+1][temp.y] = 2;

                    // push the adjacent orange to Queue
                    temp.x++;
                    Q.add(new Ele(temp.x,temp.y));

                    // Move back to current cell
                    temp.x--;
                }

                // Check left adjacent cell that if it can be rotten
                if (isValid(temp.x-1, temp.y) && arr[temp.x-1][temp.y] == 1)
                {
                    if (!flag)
                    {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x-1][temp.y] = 2;
                    temp.x--;
                    Q.add(new Ele(temp.x,temp.y)); // push this cell to Queue
                    temp.x++;
                }

                // Check top adjacent cell that if it can be rotten
                if (isValid(temp.x, temp.y+1) && arr[temp.x][temp.y+1] == 1) {
                    if(!flag)
                    {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x][temp.y+1] = 2;
                    temp.y++;
                    Q.add(new Ele(temp.x,temp.y)); // Push this cell to Queue
                    temp.y--;
                }

                // Check bottom adjacent cell if it can be rotten
                if (isValid(temp.x, temp.y-1) && arr[temp.x][temp.y-1] == 1)
                {
                    if (!flag)
                    {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x][temp.y-1] = 2;
                    temp.y--;
                    Q.add(new Ele(temp.x,temp.y)); // push this cell to Queue
                }
                Q.remove();

            }
            // Pop the delimiter
            Q.remove();

            // If oranges were rotten in current frame than separate the
            // rotten oranges using delimiter for the next frame for processing.
            if (!Q.isEmpty())
            {
                Q.add(new Ele(-1,-1));
            }

            // If Queue was empty than no rotten oranges left to process so exit
        }

        // Return -1 if all arranges could not rot, otherwise -1.s
        return (checkAll(arr))? -1: ans;

    }

}