package com.Tree;

// Find in a binary tree, if a path exists from root to leaf for a given sum
public class PathSumZero_RootLeaf {

    boolean hasSum(TreeNode root, int sum){
        if(root == null){
            return sum == 0;
        }
        return hasSum(root.left, sum-root.val) || hasSum(root.right, sum-root.val);
    }
}
