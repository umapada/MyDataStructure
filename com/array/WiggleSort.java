package com.array;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].
Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].
Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
 */

class WiggleSort {
    public void wiggleSort(int[] nums) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : nums){
            pq.add(n);
        }
        int i = 1;
        while(!pq.isEmpty()){
            if(i >= nums.length){
                i = 0;
            }
            nums[i] = pq.remove();
            i += 2;
        }
    }
}
