package extra;/*

Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5

*/

class Remove_Linked_List_Elements{

    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        ListNode currentNode = head;
        ListNode nextNode = head.next;
        while(nextNode != null){
            if(head.val == val){
                head = head.next;
                currentNode = head;
                nextNode = currentNode.next;
            }else if( nextNode.val == val){
                    nextNode = nextNode.next;
                    currentNode.next = nextNode;
                }else{
                currentNode = nextNode;
                nextNode = nextNode.next;
            }
        }

        if (head.val == val && head.next == null){
            head = null;
        }
        return head;
    }


}
