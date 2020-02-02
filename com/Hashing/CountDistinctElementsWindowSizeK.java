package com.Hashing;


/**
 * Count distinct elements in every window of size k
 * Given an array of size n and an integer k, return the of count of distinct numbers in all windows of size k.
 * Example:
 *
 * Input: arr[] = {1, 2, 1, 3, 4, 2, 3};
 * k = 4
 * Output:
 * 3
 * 4
 * 4
 * 3
 *
 *
 *
 * Explanation:
 * First window is {1, 2, 1, 3}, count of distinct numbers is 3
 * Second window is {2, 1, 3, 4} count of distinct numbers is 4
 * Third window is {1, 3, 4, 2} count of distinct numbers is 4
 * Fourth window is {3, 4, 2, 3} count of distinct numbers is 3
 */

import java.util.HashMap;

/**
 * An Efficient Solution is to use the count of the previous window while sliding the window. The idea is to create a
 * hash map that stores elements of the current window. When we slide the window, we remove an element from the hash
 * and add an element. We also keep track of distinct elements. Below is the algorithm.
 *
 * Create an empty hash map. Let hash map be hM
 * Initialize distinct element count ‘dist_count’ as 0.
 * Traverse through the first window and insert elements of the first window to hM. The elements are used as key and
 * their counts as the value in hM. Also, keep updating ‘dist_count’
 * Print ‘dist_count’ for the first window.
 * Traverse through the remaining array (or other windows).
 * Remove the first element of the previous window.
 * If the removed element appeared only once, remove it from hM and do “dist_count–“
 * else (appeared multiple times in hM), then decrement its count in hM
 * Add the current element (last element of the new window)
 * If the added element is not present in hM, add it to hM and do “dist_count++”
 * Else (the added element appeared multiple times), increment its count in hM
 */

public class CountDistinctElementsWindowSizeK {

    public static void main(String arg[])
    {
        int arr[] =  {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        countDistinct(arr, k);
    }

    static void countDistinct(int arr[], int k)
    {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

        // initialize distinct element  count for current window
        int dist_count = 0;

        // Traverse the first window and store count of every element in hash map
        for (int i = 0; i < k; i++)
        {
            if (hM.get(arr[i]) == null)
            {
                hM.put(arr[i], 1);
                dist_count++;
            }
            else
            {
                int count = hM.get(arr[i]);
                hM.put(arr[i], count+1);
            }
        }

        // Print count of first window
        System.out.println(dist_count);

        // Traverse through the remaining array
        for (int i = k; i < arr.length; i++)
        {

            // Remove first element of previous window If there was only one occurrence, then reduce distinct count.
            if (hM.get(arr[i-k]) == 1)
            {
                hM.remove(arr[i-k]);
                dist_count--;
            }
            else // reduce count of the removed element
            {
                int count = hM.get(arr[i-k]);
                hM.put(arr[i-k], count-1);
            }

            // Add new element of current window If this element appears first time, increment distinct element count
            if (hM.get(arr[i]) == null)
            {
                hM.put(arr[i], 1);
                dist_count++;
            }
            else // Increment distinct element count
            {
                int count = hM.get(arr[i]);
                hM.put(arr[i], count+1);
            }
            // Print count of current window
            System.out.println(dist_count);
        }
    }

    //Time complexity of the above solution is O(n).

}
