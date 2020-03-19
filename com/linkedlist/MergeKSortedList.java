package com.linkedlist;

/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */


public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }

        ListNode first = lists[0];

        ListNode result = null;
        for(int i=1; i < lists.length; i ++){
            result = sortedMerge(first, lists[i]);
            first = result;
        }

        return result;

    }


    ListNode sortedMerge(ListNode a, ListNode b)
    {
        ListNode result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.val <= b.val) {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

}
