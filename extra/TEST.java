package extra;


/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class TEST {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(1);


        boolean b = isPalindrome(head);

        System.out.println(b);

    }

    public static boolean isPalindrome(ListNode head) {

        if (head != null && head.next != null) {
            ListNode slow = head;
            ListNode fast = head;
           // ListNode prevSlow = null;

            while (fast != null && fast.next != null) {
           //     prevSlow = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode revList = reverse(slow);
            ListNode tempRevList = revList;
            ListNode tempOrigList = head;

            print(tempOrigList);
            System.out.println();
            print(revList);
            System.out.println();

            while (tempRevList != null && tempOrigList != null) {
                if (tempRevList.val != tempOrigList.val) {

                    reverse(revList);
                    print(head);
                    return false;
                }
                tempRevList = tempRevList.next;
                tempOrigList = tempOrigList.next;
            }
            reverse(revList);
            print(head);
            return true;
        }
        print(head);
        return true;
    }

    static void print(ListNode head){
        ListNode node = head;
        while(node != null){
            System.out.print(node.val + " - ");
            node = node.next;
        }
    }

    static ListNode reverse(ListNode head) {
        ListNode prevNode = null;
        ListNode currentNode = head;
        ListNode nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        currentNode = prevNode;

        return currentNode;
    }
}
