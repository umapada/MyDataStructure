package LinkedList;
/*
Reverse a linked list in groups of K

Example: If the list is 5->6->7->8->9->10->11->12->null and k is 3, then output would be:

7->6->5->10->9->8->12->11->null


 */
public class ReverseLinkedListInGroupsOfK {

    Node reverse(Node head, int k){
        int count =0;
        Node next = null, prev=null;
        Node current = head;

        while (count < k && current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if(next != null){
            head.next = reverse(next,k);
        }

        return prev;
    }
}
