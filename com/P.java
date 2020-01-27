package com;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;


public class P {



    // Driver code
    public static void main(String[] args)
    {

        Deque<Integer> q = new LinkedList<>();

    q.add(5);
    q.add(6);
    q.add(7);
    q.add(8);


    q.stream().forEach(System.out::print);
        System.out.println();
        System.out.println(q.removeLast());
        q.stream().forEach(System.out::print);
        q.addFirst(8);
        System.out.println();
        q.stream().forEach(System.out::print);




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
