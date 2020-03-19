package com.array;
/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2

Input:nums = [3,4,7,2,-3,1,4,2], k = 7
Output: 2
 */

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int [] arr = {3,4,7,2,-3,1,4,2};
        int out = subarraySum(arr,7);
        System.out.println(out);
    }

    static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map< Integer, Integer > map = new HashMap< >();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}
