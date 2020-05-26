package Tree;

/*
Given a binary tree root, a ZigZag path for a binary tree is defined as follow:

Choose any node in the binary tree and a direction (right or left).
If the current direction is right then move to the right child of the current node otherwise move to the left child.
Change the direction from right to left or right to left.
Repeat the second and third step until you can't move in the tree.
Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return the longest ZigZag path contained in that tree.
 */
class LongestZigZag {

    static int max = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.right = new TreeNode(1);

        longestZigZag(root);
        System.out.println(max);

    }

    public static int longestZigZag(TreeNode root) {
        if (root == null) return -1;// if null return -1
        max = 0;
        helper(root.left, 1, false);// go left
        helper(root.right, 1, true);// go right
        return max;
    }

    private static void helper(TreeNode root, int step, boolean isRight) {
        if (root == null) return;
        max = Math.max(max, step);
        if (isRight) {// if coming from right go left
            helper(root.left, step + 1, false);
            helper(root.right, 1, true);//try again from start
        } else {// else coming from left then go right
            helper(root.right, step + 1, true);
            helper(root.left, 1, false);
        }
    }
}