package com.Hashing;

import java.util.Arrays;

/**
 * Sort an array according to the order defined by another array
 * Given two arrays A1[] and A2[], sort A1 in such a way that the relative order among the elements will be same as
 * those are in A2. For the elements not present in A2, append them at last in sorted order.
 * Example:
 *
 *  Input: A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
 *        A2[] = {2, 1, 8, 3}
 * Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}
 * The code should handle all cases like the number of elements in A2[] may be more or less compared to A1[].
 * A2[] may have some elements which may not be there in A1[] and vice versa is also possible.
 */

public class SortArrayDefinedByOtherArray {

    public static void main(String args[])
    {
        int A1[] = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 };
        int A2[] = { 2, 1, 8, 3 };
        int m = A1.length;
        int n = A2.length;
        System.out.println("Sorted array is ");
        sortAccording(A1, A2, m, n);

        Arrays.stream(A1).forEach(System.out::println);
    }


/*
    Method 1 (Using Sorting and Binary Search)
    Let size of A1[] be m and size of A2[] be n.

    Create a temporary array temp of size m and copy contents of A1[] to it.
    Create another array visited[] and initialize all entries in it as false. visited[] is used to mark those elements
    in temp[] which are copied to A1[]. Sort temp[] Initialize the output index ind as 0. Do following for every
    element of A2[i] in A2[] Binary search for all occurrences of A2[i] in temp[], if present then copy all occurrences
    to A1[ind] and increment ind. Also mark the copied elements visited[] Copy all unvisited elements from temp[] to A1[]
    */

    /* A Binary Search based function to find
    index of FIRST occurrence of x in arr[].
    If x is not present, then it returns -1 */
    static int first(int arr[], int low, int high,
                     int x, int n)
    {
        if (high >= low) {
            /* (low + high)/2; */
            int mid = low + (high - low) / 2;

            if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
                return mid;
            if (x > arr[mid])
                return first(arr, (mid + 1), high,
                        x, n);
            return first(arr, low, (mid - 1), x, n);
        }
        return -1;
    }

    // Sort A1[0..m-1] according to the order defined by A2[0..n-1].
    static void sortAccording(int A1[], int A2[], int m,
                              int n)
    {
        // The temp array is used to store a copy of A1[] and visited[] is used to mark the visited elements in temp[].
        int temp[] = new int[m], visited[] = new int[m];
        for (int i = 0; i < m; i++) {
            temp[i] = A1[i];
            visited[i] = 0;
        }

        // Sort elements in temp
        Arrays.sort(temp);

        // for index of output which is sorted A1[]
        int ind = 0;

        // Consider all elements of A2[], find them in temp[] and copy to A1[] in order.
        for (int i = 0; i < n; i++) {
            // Find index of the first occurrence of A2[i] in temp
            int f = first(temp, 0, m - 1, A2[i], m);

            // If not present, no need to proceed
            if (f == -1)
                continue;

            // Copy all occurrences of A2[i] to A1[]
            for (int j = f; (j < m && temp[j] == A2[i]);
                 j++) {
                A1[ind++] = temp[j];
                visited[j] = 1;
            }
        }

        // Now copy all items of temp[] which are not present in A2[]
        for (int i = 0; i < m; i++)
            if (visited[i] == 0)
                A1[ind++] = temp[i];
    }

    /**
     * Time complexity: The steps 1 and 2 require O(m) time. Step 3 requires O(M * Log M) time. Step 5 requires
     * O(N Log M) time. Therefore overall time complexity is O(M Log M + N Log M).
     */


    /**
     * Method 2 (Using Self-Balancing Binary Search Tree)
     *
     * We can also use a self balancing BST like AVL Tree, Red Black Tree, etc. Following are detailed steps.
     *
     * Create a self balancing BST of all elements in A1[]. In every node of BST, also keep track of count of
     * occurrences of the key and a bool field visited which is initialized as false for all nodes.
     * Initialize the output index ind as 0. Do following for every element of A2[i] in A2[]
     * Search for A2[i] in the BST, if present then copy all occurrences to A1[ind] and increment ind. Also mark the
     * copied elements visited in the BST node. Do an inorder traversal of BST and copy all unvisited keys to A1[].
     * Time Complexity of this method is same as the previous method. Note that in a self balancing Binary Search Tree,
     * all operations require logm time.
     *
     * Method 3 (Use Hashing)
     *
     * Loop through A1[], store the count of every number in a HashMap (key: number, value: count of number)
     * Loop through A2[], check if it is present in HashMap, if so, put in output array that many times and remove
     * the number from HashMap. Sort the rest of the numbers present in HashMap and put in output array.
     *
     *
     *
     * Method 4 (By Writing a Customized Compare Method)
     * We can also customize compare method of a sorting algorithm to solve the above problem.
     *
     * If num1 and num2 both are in A2 then number with lower index in A2 will be treated smaller than other.
     * If only one of num1 or num2 present in A2, then that number will be treated smaller than the other which doesn’t present in A2.
     * If both are not in A2, then natural ordering will be taken.
     * Time complexity of this method is O(mnLogm) if we use a O(nLogn) time complexity sorting algorithm. We can
     * improve time complexity to O(mLogm) by using a Hashing instead of doing linear search.
     *
     *
     */
}
