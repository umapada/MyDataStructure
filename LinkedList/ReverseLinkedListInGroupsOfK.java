package LinkedList;

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
