package com.Tree;
/*
Find all paths in a tree whose sum is some given no
(paths may not start at root)

If paths were to start at root only, then it was straightforward to check all paths from the root. But if paths
can start anywhere, then its slightly more complex.
 */
public class PathSumZero_AnyPath {

    boolean hasPath(TreeNode root, int sum, int origSum){
        if(root == null || sum <=0){
            return false;
        }
        sum = sum - root.val;
        if(sum == 0){
            return true;
        }

        return hasPath(root.left, sum, origSum) || hasPath(root.right, sum, origSum)
                || hasPath(root.left, origSum, origSum) || hasPath(root.right,origSum, origSum);
    }

}
