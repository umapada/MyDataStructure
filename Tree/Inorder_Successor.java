package Tree;

/*
In Binary Tree, Inorder successor of a node is the next node in Inorder traversal of the Binary Tree.
Inorder Successor is NULL for the last node in Inoorder traversal. In Binary Search Tree, Inorder Successor
of an input node can also be defined as the node with the smallest key greater than the key of input node. So,
it is sometimes important to find next node in sorted order.

 */
//Progress => //4
public class Inorder_Successor {

    TreeNode inOrderSuccessor(TreeNode root, TreeNode n) {

        // step 1 of the above algorithm
        if (n.right != null) {
            return minValue(n.right);
        }

        // step 2 of the above algorithm
        TreeNode p = n.parent;
        while (p != null && n == p.right) {
            n = p;
            p = p.parent;
        }
        return p;
    }

    /* Given a non-empty binary search tree, return the minimum data
 value found in that tree. Note that the entire tree does not need
 to be searched. */
    TreeNode minValue(TreeNode node) {
        TreeNode current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

}


/*
Time Complexity: O(h) where h is height of tree.

 */