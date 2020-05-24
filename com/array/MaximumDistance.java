package com.array;
/*
Two sorted elements with maximum distance in an unsorted array


Problem: Given an unsorted array, find two indexes in the array such that arr[i] < arr[j] and j-i is maximum.

Example: If the array is [7, 3, 9, 2, 1, 11, 0], 7 and 11 are the solution.


Solution: A naive solution is O(n2) where we loop over entire array and at each loop-position, check the elements towards its right for greater elements max distance far.

For a more efficient solution, we will need to analyze some properties of the problem.

Note that for any solution i and j, the value (j-i) has to be maximum which means that no element towards right of j can be greater than arr[j].
Because if there were such an element, then that element would have been part of the solution and not arr[j].
Similarly, if i and j are a solution, then no element to left of arr[i] is smaller than arr[i].

Thus, if we create two arrays IndexOfLeftMinimum and IndexOfRightMaximum for every element in the array, then the solution is just the maximum value of IndexOfRightMaximum[k] - IndexOfLeftMinimum[k].
 */

public class MaximumDistance {


    void findMaxDistanceApart(int arr[]) {
        if (arr.length <= 1)
            return;

        int indexOfLeftMin[] = new int[arr.length];
        int indexOfRightMax[] = new int[arr.length];

        // below loop fills first array such that value at every index
        // tells the position of the minimum element present in the left of that index
        indexOfLeftMin[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            int currMin = arr[indexOfLeftMin[i - 1]];
            if (arr[i] < currMin) {
                indexOfLeftMin[i] = i;
            } else {
                indexOfLeftMin[i] = indexOfLeftMin[i - 1];
            }
        }


        // below loop fills second array such that value at every index
        // tells the position of the maximum element present in the right of that index
        indexOfRightMax[arr.length - 1] = arr.length - 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int currMax = arr[indexOfRightMax[i + 1]];
            if (arr[i] > currMax) {
                indexOfRightMax[i] = i;
            } else {
                indexOfRightMax[i] = indexOfRightMax[i + 1];
            }
        }

        // find k such that difference between indexOfRightMax[k] and indexOfLeftMin[k] is maximum

        int maxDiff = -1;
        int i = -1;
        int j = -1;
        for (int k = 0; k < arr.length; k++) {
            int distance = indexOfRightMax[k] - indexOfLeftMin[k];
            if (distance > maxDiff) {
                i = indexOfLeftMin[k];
                j = indexOfRightMax[k];
            }
        }
        if (i == j) {
            System.out.println("No such pair exists");
            return;
        }

        System.out.println("Two sorted elements maximum distance apart are " + arr[i] + " and " + arr[j]);
        System.out.println("And maximum distance is " + (j - i));

    }
}