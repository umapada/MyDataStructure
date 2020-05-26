package Tree;
/*
If we just check the root, left, right property of every node, and all of them are BSTs in themselves, we cannot say the resulting tree is also BST. For example:


     5
    / \
   3   7
    \
     9

In the above, 3 < 5 < 7 (BST is complete for root and its immediate children).

Subtrees (involving node and their immediate children) at 3, 9 and 7 are all BSTs

Yet the whole tree is not BST because 9 lies in left subtree of 5


This indicates, that the test for BST should check to see that all the nodes lying left to a node should be smaller than that node and the nodes to the right of a node should all be greater than that node.


Due to the above property, every node should lie in a range defined by its closest right and left parents.
 */

public class ValidateBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.right = new TreeNode(9);
        System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }
    // Call the below as:
//    isBST (root, INT_MIN, INT_MAX);
   static boolean isBST(TreeNode node, int min, int max)
    {
        if (node==null)
            return true;
        if (node.data < min || node.data > max)
            return false;

        return isBST(node.left, min, node.data-1) && isBST(node.right, node.data+1, max);
    }
}
