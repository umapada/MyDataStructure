package Tree;
/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */

import java.util.HashMap;
import java.util.Map;

class TreeFromPreOrderAndInorder {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int pre_idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int index = 0;
        for(int val:inorder){
            inorderMap.put(val, index++);
        }

        return build(preorder, 0, inorder.length -1 );
    }
    TreeNode build(int[] preorder, int left_index, int right_index){
        if(left_index > right_index)
            return null;

        int root_val = preorder[pre_idx];
        int in_index = inorderMap.get(root_val);
        pre_idx++;
        TreeNode root = new TreeNode(root_val);
        root.left = build(preorder, left_index, in_index - 1);
        root.right = build(preorder, in_index + 1, right_index);
        return root;
    }
}