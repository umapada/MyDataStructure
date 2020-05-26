package Tree;
/*
Given a binary tree root, the task is to return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
Output: 20
Explanation: Maximum sum in a valid Binary search tree is obtained in root node with key equal to 3.

Input: root = [4,3,null,1,2]
Output: 2
Explanation: Maximum sum in a valid Binary search tree is obtained in a single root node with key equal to 2.
Example 3:

Input: root = [-4,-2,-5]
Output: 0
Explanation: All values are negatives. Return an empty BST.
Example 4:

Input: root = [2,1,3]
Output: 6
Example 5:

Input: root = [5,4,8,3,null,6,3]
Output: 7

// SOLUTION


For each subtree, we return 4 elements.

the status of this subtree, 1 means it's empty, 2 means it's a BST, 0 means it's not a BST
size of this subtree (we only care about size of BST though)
the minimal value in this subtree
the maximal value in this subtree
Then we only need to make sure for every BST

both of its children are BST
the right bound of its left child is smaller than root.val
the left bound of its right child is larger than root.val
Complexity
Time: O(N)
Space: O(logN) for function calls, worst case O(N) if the given tree is not balanced



 */
public class MaximumSumBSTInBinaryTree {
    static int max = 0;
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(3);
//
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(40);
//
//        root.right.left = new TreeNode(2);
//        root.right.right = new TreeNode(5);
//
//        root.right.right.left = new TreeNode(4);
//        root.right.right.right = new TreeNode(6);


        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(8);

        int out = new MaximumSumBSTInBinaryTree().maxSumBST(root);

        System.out.println(out);


    }

    public int maxSumBST(final TreeNode root) {
       // final int[] res = new int[1];
        //res[0] = 0;
         traverse(root);
        return max;
    }

    private int[] traverse(final TreeNode root) {
        if (root == null) {
            //1 means it's empty
            return new int[]{1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        int[] LSubTreeInfo = traverse(root.left);
        int[] RSubTreeInfo = traverse(root.right);

        if (((LSubTreeInfo[0] == 2 && root.val > LSubTreeInfo[3])||(LSubTreeInfo[0] == 1)) &&
                ((RSubTreeInfo[0] == 2 && root.val < RSubTreeInfo[2])||(RSubTreeInfo[0] == 1))) {

            final int curSum = root.val + LSubTreeInfo[1] + RSubTreeInfo[1];
            final int curMin = root.left == null ? root.val : LSubTreeInfo[2];
            final int curMax = root.right == null ? root.val : RSubTreeInfo[3];
            max = Math.max(max, curSum);
            //2 means it's BST
            return new int[]{2, curSum, curMin, curMax};
        }
        //0 means it's not BST
        return new int[]{0, -1, -1, -1};
    }
}
