package LinkedList;
/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
 */
public class ReverseLinkedList {

    public Node reverseList(Node head) {
        if (head == null || head.next == null) return head;

        Node p = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return p;
    }

    public Node reverseList_Iterative(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

}
