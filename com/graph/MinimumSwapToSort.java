package com.graph;
/*
Given an array of N distinct elements A[ ]. The task is to find the minimum number of swaps required to sort the array.
Your are required to complete the function which returns an integer denoting the minimum number of swaps, required to
sort the array.
 */

import java.util.ArrayList;
import java.util.List;

class Pair {
    int ele, ind;
    Pair(int ele, int ind) {
        this.ele = ele;
        this.ind = ind;
    }
}
class MinimumSwapToSort {
    // Function returns the minimum number of swaps required to sort the array

    public static void main(String[] args) {
        int [] arr = {3,1,7,5,0};
        int n = minSwaps(arr);

        System.out.println(n);
    }

    static int minSwaps(int[] arr) {
        int n = arr.length;

        // Create two arrays and use as pairs where first array is element and second array is position of first element
        List<Pair> arrPos = new ArrayList<Pair>();
        for (int i = 0; i<n; i++)
            arrPos.add(new Pair(arr[i], i));

        // Sort the array by array element values to get right position of every element as the elements of second array.
        arrPos.sort((a,b) -> {return  a.ele - b.ele;});

        // To keep track of visited elements.
        boolean[] vis = new boolean[n];

        int ans = 0;
        // Traverse array elements
        for (int i = 0; i<n; i++) {
            // already swapped and corrected or already present at correct pos
            if (vis[i] || arrPos.get(i).ind == i)
                continue;
            // find out the number of node in this cycle and add in ans
            int cycle_size = 0;
            int j = i;
            while (!vis[j]) {
                vis[j] = true;
                // move to next node
                j = arrPos.get(j).ind;
                cycle_size++;
            }
            // Update answer by adding current cycle.
            if (cycle_size > 0) {
                ans += (cycle_size - 1);
            }
        }
        // Return result
        return ans;
    }
}