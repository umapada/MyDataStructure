package TEST;

import extra.ListNode;
import Tree.TreeNode;
/*
Given a binary tree root and a linked list with head as the first node.

Return True if all the elements in the linked list starting from the head correspond to some downward path connected in
the binary tree otherwise return False.

In this context downward path means a path that starts at some node and goes downwards.
 */

/*
Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: true
Explanation: Nodes in blue form a subpath in the binary Tree.

Input: head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: true
Example 3:

Input: head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: false
Explanation: There is no path in the binary tree that contains all the elements of the linked list from head.

Constraints:
1 <= node.val <= 100 for each node in the linked list and binary tree.
The given linked list will contain between 1 and 100 nodes.
The given binary tree will contain between 1 and 2500 nodes.

 */

public class LinkedListInBinaryTree {


    public static void main(String[] args) {
      //  [10,7,4,10,2,6,10,10,10,1,10,6]
// [1,10,7,10,8,6,1,10,7,1,10,4,3,9,null,10,10,4,10,7,1,3,7,null,null,7,9,6,3,null,null,8,10,10,3,1,1,null,null,null,null,null,2,null,null,10,3,5,null,null,null,6,null,5,null,null,6,2,5,null,4,null,10,9,10,null,null,null,3,10,8,5,6,null,7,3,null,8,9,6,2,null,8,9,10,10,null,4,6,4,null,null,2,5,6,null,null,null,null,6,null,1,null,null,null,null,8,null,null,10,10,null,null,null,8,null,null,3,10,null,null,10,2,null,null,7,6,null,null,null,null,null,null,null,null,null,null,4,null,null,10,null,2,null,null,1,6,null,null,8,9,null,null,null,8,4,null,null,null,10,4,null,1,null,null,null,null,9,null,null,null,null,null,9,null,10,1,6,null,null,null,null,null,null,null,5,null,2,10,null,null,null,null,null,null,null,6,null,5]
    }


    class Solution {
        public boolean isSubPath(ListNode head, TreeNode root) {
            if(head == null){
                return true;
            }
            if(root == null){
                return false;
            }
            return (isPathExist(head, root) || isPathExist(head, root.left) || isPathExist(head, root.right));
        }


        boolean isPathExist(ListNode head, TreeNode root){
            if(head == null){
                return true;
            }
            if(root == null){
                return false;
            }
            if(head.val == root.val){
                return isPathExist(head.next, root.left) && isPathExist(head.next, root.right);
            }
            return false;
        }
    }

}
