package com.GreedyAlgorithm;

/**
 * Find maximum meetings in one room
 *
 * There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is the start time
 * of meeting i and F[i] is finish time of meeting i. The task is to find the maximum number of meetings that can be
 * accommodated in the meeting room. Print all meeting numbers
 *
 * Examples:
 *
 * Input : s[] = {1, 3, 0, 5, 8, 5}, f[] = {2, 4, 6, 7, 9, 9}
 * Output : 1 2 4 5
 * First meeting [1, 2]
 * Second meeting [3, 4]
 * Fourth meeting [5, 7]
 * Fivth meeting [8, 9]
 *
 *
 *
 * Input : s[] = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924},
 * f[] = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252 }
 * Output : 6 7 1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Approach:
 * Idea is to solve the problem using the greedy approach which is the same as Activity Selection Problem.
 *
 * Sort all pairs(Meetings) in increasing order of second number(Finish time) of each pair.
 * Select first meeting of sorted pair as the first Meeting in the room and push it into result vector and set a
 * variable time_limet(say) with the second value(Finishing time) of the first selected meeting.
 * Iterate from the second pair to last pair of the array and if the value of the first element(Starting time of
 * meeting) of the current pair is greater then previously selected pair finish time (time_limit) then select the
 * current pair and update the result vector (push selected meeting number into vector) and variable time_limit.
 * Print the Order of meeting from vector.
 */

class Pair {
    int x,y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class NMeetingsInOneRoom {

    static void sortPair(Pair arr[]) {
        Arrays.sort(arr, (a,b) -> {return a.y - b.y;});
    }

    public static void main (String[] args) throws IOException {

        int [] start = {1, 3, 0, 5, 8, 5};
        int [] end =   {2, 4, 6, 7, 9, 9};

            int n = start.length;
            Pair[] p = new Pair[n];
            for(int i=0; i<start.length; i++){
                p[i] = new Pair(start[i], end[i]);
            }

            Pair[] p2 = p.clone();
            sortPair(p);
       int i = 0;
        System.out.print(i+" ");

        // Consider rest of the activities
        for (int j = 1; j < n; j++)
        {
            // If this activity has start time greater than or equal to the finish time of previously selected activity, then select it
            if (p2[j].x >= p2[i].y)
            {
                System.out.print(j+" ");
                i = j;
            }
        }
            System.out.println();
    }
}