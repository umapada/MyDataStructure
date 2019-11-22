package com.test.ds1.linkedlist;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in
reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

 */

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p = l1, q = l2, headNode = new ListNode(0), currNode = headNode;
        int carry = 0;

        while(p != null || q != null){

            int pVal = p!= null? p.val:0;
            int qVal = q!= null? q.val:0;
            int sum = pVal + qVal + carry;

            carry = sum / 10;

            currNode.next = new ListNode(sum % 10);

            if(p!= null) {
                p = p.next;
            }
            if(q != null){
                q = q.next;
            }

            currNode = currNode.next;
        }

        if(carry != 0){
            currNode.next = new ListNode(carry);
        }

        return headNode.next;
    }
}
