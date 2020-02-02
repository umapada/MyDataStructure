package com.DivideAndConquer;

/**
 * Given two sorted arrays of size m and n respectively, you are tasked with finding the element that would be at
 * the k’th position of the final sorted array.
 *
 * Examples:
 *
 * Input : Array 1 - 2 3 6 7 9
 *         Array 2 - 1 4 8 10
 *         k = 5
 * Output : 6
 * Explanation: The final sorted array would be -
 * 1, 2, 3, 4, 6, 7, 8, 9, 10
 * The 5th element of this array is 6.
 * Input : Array 1 - 100 112 256 349 770
 *         Array 2 - 72 86 113 119 265 445 892
 *         k = 7
 * Output : 256
 * Explanation: Final sorted array is -
 * 72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
 * 7th element of this array is 256.
 *
 */

/**
 * Basic Approach
 * Since we are given two sorted arrays, we can use merging technique to get the final merged array.
 * From this, we simply go to the k’th index
 */
public class K_ThElementOfTwoSortedArrays {

    static int kth(int arr1[], int arr2[], int m, int n, int k)
    {
        int[] sorted1 = new int[m + n];
        int i = 0, j = 0, d = 0;
        while (i < m && j < n)
        {
            if (arr1[i] < arr2[j])
                sorted1[d++] = arr1[i++];
            else
                sorted1[d++] = arr2[j++];
        }
        while (i < m)
            sorted1[d++] = arr1[i++];
        while (j < n)
            sorted1[d++] = arr2[j++];
        return sorted1[k - 1];
    }

    // main function
    public static void main (String[] args)
    {
        int arr1[] = {2, 3, 6, 7, 9};
        int arr2[] = {1, 4, 8, 10};
        int k = 5;
        System.out.print(kth(arr1, arr2, 5, 4, k));
    }

    /**
     * Time Complexity: O(n)
     * Auxiliary Space : O(m + n)
     */
}


/*
Divide And Conquer Approach 1
While the previous method works, can we make our algorithm more efficient? The answer is yes. By using a divide and
conquer approach, similar to the one used in binary search, we can attempt to find the k’th element in a more efficient way.

Explanation:
We compare the middle elements of arrays arr1 and arr2,
let us call these indices mid1 and mid2 respectively.

Let us assume arr1[mid1]  k, then clearly the elements after
mid2 cannot be the required element. We then set the last
element of arr2 to be arr2[mid2].

In this way, we define a new subproblem with half the size
of one of the arrays.
 */