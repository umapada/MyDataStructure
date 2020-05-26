package Tree;
/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */

import java.util.HashMap;
import java.util.Map;

class TreeFromPostOrderAndInorder {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int post_index=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int index = 0;
        for(int val: inorder){
            inorderMap.put(val, index++);
        }

        post_index = postorder.length - 1;

        return build(postorder, 0, inorder.length-1);

    }

    TreeNode build(int[] postorder, int left_index, int right_index){
        if(left_index > right_index){
            return null;
        }
        int root_val = postorder[post_index--];
        TreeNode root = new TreeNode(root_val);
        int in_index = inorderMap.get(root_val);
        root.right = build(postorder, in_index+1, right_index);
        root.left = build(postorder, left_index, in_index-1);
        return root;
    }

}