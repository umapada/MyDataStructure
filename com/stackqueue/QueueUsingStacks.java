package com.stackqueue;

/*

Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Example:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false

 */


/*
Approach #1 (Two Stacks) Push - O(n) per operation, Pop - O(1) per operation.
 */

/*
Approach #2 (Two Stacks) Push - O(1) per operation, Pop - Amortized O(1) per operation.
 */

import java.util.*;

public class QueueUsingStacks {
}

class MyQueue {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    int front;

    Deque<Integer> queue = new LinkedList<>();


    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s1.empty())
            front = x;
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.empty()){
            while (!s1.empty()){
                s2.push(s1.pop());
            }
        }
        if(s2.empty()){
            return -1;
        }else{
            return s2.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if(!s2.empty()){
            return s2.peek();
        }
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty() & s2.empty();
    }
}
