package com.stackqueue;
/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Example:

MyStack stack = new MyStack();

stack.push(1);
stack.push(2);
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false
 */


import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueue {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top;
    /** Initialize your data structure here. */
    public StackUsingQueue() {

    }
    // Push element x onto stack.
    public void push(int x) {
        q1.add(x);
        top = x;
    }
/*
/*
Complexity Analysis
Time complexity : O(1). Queue is implemented as linked list and add operation has O(1) time complexity.
Space complexity : O(1)
 */
    // Removes the element on top of the stack.
    public int pop() {
        while (q1.size() > 1) {
            top = q1.remove();
            q2.add(top);
        }
        int a = q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return a;
    }
/*
Complexity Analysis

Time complexity : O(n). The algorithm dequeues n elements from q1 and enqueues n - 1 elements to q2, where n is the
stack size. This gives 2n−1 operations.
Space complexity : O(1).

*/
    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return (q1.size() ==0  & q2.size() == 0);
    }
}
