package com;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;



public class P {



    // Driver code
    public static void main(String[] args)
    {

        int nums [] = {10, 23, 45, 6};

        int a = findKthLargest(nums, 3);


    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i: nums){
            q.offer(i);

            if(q.size()>k){
                q.poll();
            }
        }
        int ret =  q.peek();
        return ret;
    }


}
