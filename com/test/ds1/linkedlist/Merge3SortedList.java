package com.test.ds1.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class ListData{
    int data;
    ListNode listNode;
    ListData(int data, ListNode node){
        this.data = data;
        this.listNode = node;
    }
}

/* Not completed yet */

public class Merge3SortedList {

    ListNode merge3SortedList(ListNode l1, ListNode l2, ListNode l3){

        ListNode a = l1, b = l2, c = l3, dummyNode = new ListNode(0), headNode = dummyNode;

        Queue<ListData> pq = new PriorityQueue(new Comparator<ListData>() {
            @Override
            public int compare(ListData o1, ListData o2) {
                if (o1.data < o2.data) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        if(a != null){
            pq.add(new ListData(a.val, a));
        }
        if(b!= null){
            pq.add(new ListData(b.val, b));
        }
        if(c != null){
            pq.add(new ListData(c.val, c));
        }

        while (a != null || b != null || c != null){

            ListData listData = pq.poll();
            if(listData.listNode.next != null){
                pq.add(new ListData(listData.listNode.next.val, listData.listNode.next));
            }

            dummyNode.next = new ListNode(listData.data);
            dummyNode = dummyNode.next;

            if(a!= null){
                a = a .next;
            }
            if(b != null){
                b = b.next;
            }
            if(c != null){
                c = c.next;
            }
        }

        while (!pq.isEmpty()){
            dummyNode.next = new ListNode(pq.poll().data);
            dummyNode = dummyNode.next;
        }

        return headNode.next;
    }

}
