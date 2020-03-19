package com.Hashing;

/**
 * Print the elements of an array in the decreasing frequency if 2 numbers have same frequency then print the one which came first.
 *
 * Examples:
 *
 * Input : arr[] = {2, 5, 2, 8, 5, 6, 8, 8}
 * Output : arr[] = {8, 8, 8, 2, 2, 5, 5, 6}
 *
 * Input : arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8}
 * Output : arr[] = {8, 8, 8, 2, 2, 5, 5, 6, -1, 9999999}
 */


import java.io.IOException;
import java.util.*;

/**
 * All of the above approaches work in O(n Log n) time where n is total number of elements. In this post, a new
 * approach is discussed that works in O(n + m Log m) time where n is total number of elements and m is total number of distinct elements.
 *
 * The idea is to use hashing.
 *
 * We insert all elements and their counts into a hash. This step takes O(n) time where n is number of elements.
 * We copy contents of hash to an array (or vector) and sort them by counts. This step takes O(m Log m) time
 * where m is total number of distinct elements. For maintaining the order of elements if the frequency is same,
 * we use another hash which has the key as elements of the array and value as the index. If the frequency is same for
 * two elements then sort elements according to the index.
 *
 */
public class SortElementsByFrequency {

    // Driver program
    public static void main(String[] args) throws IOException {
        int a[] = { 2, 5, 2, 6,10, -1, 9999999, 5, 8, 8, 8 };
        System.out.println(sortByFrequency(a, a.length));
    }

    public static StringBuffer sortByFrequency(int arr1[], int l1) {
        // Build a map of array elements to its count
        Map<Integer, Integer> countMap = getCountMap(arr1, l1);
        StringBuffer result = new StringBuffer();

        // Sort the map using a comparingByValue comparator
        // build the result by appending keys the count times to the result

        countMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer> comparingByValue().reversed())
                .forEach(e -> {
                    int key = e.getKey();
                    int val = e.getValue();
                    for (int i = 0; i < val; i++) {
                        result.append(key + " ");
                    }
                });


      //  countMap.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).forEach(System.out::println);

        return result;
    }

    // helper function to return the element count map
    private static Map<Integer, Integer> getCountMap(int[] arr, int l1) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < l1; i++) {
            if (countMap.containsKey(arr[i])) {
                countMap.put(arr[i], countMap.get(arr[i]) + 1);
            } else {
                countMap.put(arr[i], 1);
            }
        }
        return countMap;
    }

    /**
     * Time Complexity : O(n) + O(m Log m) where n is total number of elements and m is total number of distinct elements
     */

}
