package com.test.ds1.Hashing;

/**
 * Print all subarrays with 0 sum
 * Given an array, print all subarrays in the array which has sum 0.
 *
 * Examples:
 *
 * Input:  arr = [6, 3, -1, -3, 4, -2, 2,
 *              4, 6, -12, -7]
 * Output:
 * Subarray found from Index 2 to 4
 * Subarray found from Index 2 to 6
 * Subarray found from Index 5 to 6
 * Subarray found from Index 6 to 9
 * Subarray found from Index 0 to 10
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Do following for each element in the array
 *
 * Maintain sum of elements encountered so far in a variable (say sum).
 * If current sum is 0, we found a subarray starting from index 0 and ending at index current index
 * Check if current sum exists in the hash table or not.
 * If current sum already exists in the hash table then it indicates that this sum was the sum of some sub-array elements arr[0]…arr[i] and now the same sum is obtained for the current sub-array arr[0]…arr[j] which means that the sum of the sub-array arr[i+1]…arr[j] must be 0.
 * Insert current sum into the hash table
 */


public class SubarraysWithZeroSum {

    public static void main(String args[])
    {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        int n = arr.length;

        List<Pair> out = findSubArrays(arr, n);

        // if we did not find any subarray with 0 sum,
        // then subarray does not exists
        if (out.size() == 0)
            System.out.println("No subarray exists");
        else
            out.stream().forEach(x->{
                System.out.println("Subarray found from Index " + x.first + " to " + x.second);
            });
    }


    static List<Pair> findSubArrays(int[] arr, int n)
    {
        // create an empty map
        Map<Integer,List<Integer>> map = new HashMap<>();

        // create an empty vector of pairs to store
        // subarray starting and ending index
        List<Pair> out = new ArrayList<>();

        // Maintains sum of elements so far
        int sum = 0;

        for (int i = 0; i < n; i++)
        {
            // add current element to sum
            sum += arr[i];

            // if sum is 0, we found a subarray starting
            // from index 0 and ending at index i
            if (sum == 0)
                out.add(new Pair(0, i));
            List<Integer> al = new ArrayList<>();

            // If sum already exists in the map there exists
            // at-least one subarray ending at index i with
            // 0 sum
            if (map.containsKey(sum))
            {
                // map[sum] stores starting index of all subarrays
                al = map.get(sum);
                for (int it = 0; it < al.size(); it++)
                {
                    out.add(new Pair(al.get(it) + 1, i));
                }
            }
            al.add(i);
            map.put(sum, al);
        }
        return out;
    }


}

class Pair
{
    int first, second;
    Pair(int a, int b)
    {
        first = a;
        second = b;
    }
}