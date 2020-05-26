package Tree;
/*
Problem: A binary tree is foldable if it's a mirror image of itself
        i.e. if its left and right subtrees are identical mirror images

        Example:
            1
          /   \
         2     2
        / \   / \
        4   3 3   4
        Foldable

             1
           /   \
          2     2
         / \   / \
        3   4 3   4
        Not foldable

             1
           /   \
          2     2
         /       \
        3         3
         Foldable
*/
public class FoldableBinaryTree {

    boolean isFoldable(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        return left.val == right.val && isFoldable(left.left, right.right) && isFoldable(left.right, right.left);
    }

}