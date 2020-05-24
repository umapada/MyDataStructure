package com.GreedyAlgorithm;

/**
 * Geek collects the balls
 * There are two parallel roads, each containing N and M buckets, respectively. Each bucket may contain some balls.
 * The buckets on both roads are kept in such a way that they are sorted according to the number of balls in them.
 * Geek starts from the end of the road which has the bucket with a lower number of balls(i.e. if buckets are sorted
 * in increasing order, then geek will start from the left side of the road).
 * The geek can change the road only at the point of intersection(which means, buckets with the same number of balls
 * on two roads). Now you need to help Geek to collect the maximum number of balls.
 */

public class GeekCollectsTheBalls {

    public long totalBalls(int arr1[], int arr2[]) {
        //Arrays.sort(arr1);
        //Arrays.sort(arr2);
        long path1 = 0l;
        long path2 = 0l;
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                path1 += arr1[i];
                i++;
            } else if (arr1[i] > arr2[j]) {
                path2 += arr2[j];
                j++;
            } else {
                path1 += arr1[i];
                path2 += arr2[j];
                if (path1 > path2) {
                    path2 = path1;
                } else {
                    path1 = path2;
                }
                i++;
                j++;
            }
        }
        //added logic when last element in  arrays are equal
        if(arr1[i-1] == arr2[j-1]){
            if (path1 > path2) {
                path2 = path1;
            } else {
                path1 = path2;
            }
        }

        while (i < arr1.length) {
            path1 += arr1[i];
            i++;
        }

        while (j < arr2.length) {
            path2 += arr2[j];
            j++;
        }

        return path1 > path2 ? path1 : path2;
    }

}
