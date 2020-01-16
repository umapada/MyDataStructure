package com.test.ds1.stackqueue.PriorityQueue;

import java.util.PriorityQueue;

/**
 * Given an infinite stream of integers, find the k’th largest element at any point of time.
 * Example:
 *
 * Input:
 * stream[] = {10, 20, 11, 70, 50, 40, 100, 5, ...}
 * k = 3
 *
 * Output:    {_,   _, 10, 11, 20, 40, 50,  50, ...}
 */


/**
 * We can use a min heap to solve this problem. The heap stores the top k largest elements.The top of the
 * heap is the Kth Largest element and all other elements are greater than the heap top. Whenever the size
 * is greater than k, delete the min. Time complexity is O(nlog(k)). Space complexity is O(k) for storing
 * the top k numbers
 */

public class KthLargestElementInStream {

    public static void main(String[] args)
    {
        int nums [] = {5,10, 23, 45, 6, 7, 11,34};
        int a = findKthLargest(nums, 3);
        System.out.println(a);
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i: nums){
            q.offer(i);

            if(q.size()>k){
                q.poll();
            }
            if(q.size()<=2){
                System.out.print( " " + -1);
            }else {
                System.out.print(" " + q.peek());
            }

        }
        System.out.println();
        int ret =  q.peek();
        return ret;
    }
}
