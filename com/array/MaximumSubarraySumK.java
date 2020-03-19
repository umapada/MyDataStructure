package com.array;

/*
Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

 */
// https://www.programcreek.com/2014/10/leetcode-maximum-size-subarray-sum-equals-k-java/


//Solution
//As we iterate over the array , put the sum in a hashmap as key, index as value.
// We can get sum-k in time of O(1)

import java.util.HashMap;

//Important
//TODO
public class MaximumSubarraySumK {

    public static void main(String[] args) {
        int num[] = {3,2,3,1,4,-1,2,-2,1,1,3};
      //  int num[] = {1, -1, 5, -2, 3};
        int out = maxSubArrayLen(num, 8);
        System.out.println(out);
    }

    public static int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum == k){
                max = Math.max(max, i+1);
            }

            Integer sum_minusK_index = map.get(sum-k);
            if(sum_minusK_index != null){
                max = Math.max(max, i-sum_minusK_index);
            }

            map.putIfAbsent(sum, i);

//            if(!map.containsKey(sum)){
//                map.put(sum, i);
//            }
        }
        return max;
    }
}
