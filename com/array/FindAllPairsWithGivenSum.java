package com.array;
//Given an unsorted array, find all pairs whose sum is a given number K
/*
Solution 1: Use a hash-map to store all numbers.
When storing a number in the map, lookup N-k.
If N-k exists in the map, sum is found, else move to next number.

Solution 2: Sort the array and search with two indexes set to start and end of the array.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllPairsWithGivenSum {

    public static void main(String[] args) {
        int [] arr = {1,3,5,2,1,4,6,8,0};
        Arrays.sort(arr);
        int target = 5;
        System.out.println(findPairs(arr,target));
    }

  static List<List<Integer>> findPairs(int [] arr, int K){
      List<List<Integer>> list = new ArrayList<>();
            int start = 0;
            int end = arr.length-1;

            while (start <= end)
            {
                int sum = arr[start] + arr[end];
                if (sum == K)
                {
                    List<Integer> ll = new ArrayList<>();
                    list.add(ll);
                    ll.add(arr[start] );
                    ll.add(arr[end]);
                  //  System.out.println ("Found sum for " + arr[start] + " and " + arr[end]);
                    start++;
                    end--;
                }
                else if (sum < K)
                {
                    start++;
                }
                else
                {
                    end--;
                }
            }



            return list;
        }
}
