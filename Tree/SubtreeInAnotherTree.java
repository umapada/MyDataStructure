package Tree;
/*
Check if one tree is a subtree in another tree

Solution 1: Print the inorder and preoder traversals of both the trees and see if the traversals of
one tree are substrings in other tree's traversals.

However, this solutions requires O(m+n) space where m and n are nodes in respective trees.


Solution 2: We can check the trees node by node also if there is some logic for nodes that do not match.

 */

public class SubtreeInAnotherTree {

    boolean isSubtree (TreeNode t1, TreeNode t2)
    {
        if (t2 == null) // An empty subtree can always be found in any tree
            return true;

        if (t1 == null) // If no more tree is left to search, return false
            return false;

        // If there is a match, check the left and right nodes to match with
        // left and right subtrees
        if (t1.data == t2.data)
            return isSubtree(t1.left, t2.left) && isSubtree(t1.right, t2.right);

        // If there is no match, check left and right subtrees for a
        // match with current tree
        return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
    }
}
