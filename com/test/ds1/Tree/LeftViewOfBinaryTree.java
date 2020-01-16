package com.test.ds1.Tree;

/**
 * Given a Binary Tree, print left view of it. Left view of a Binary Tree is set of nodes visible when
 * tree is visited from left side.
 */

/**
 * Input :
 *                  1
 *                /   \
 *               2     3
 *              / \     \
 *             4   5     6
 * Output : 1 2 4
 *
 * Input :
 *         1
 *       /   \
 *     2       3
 *       \
 *         4
 *           \
 *             5
 *              \
 *                6
 * Output :1 2 4 5 6
 */

/**
 * The problem can also be solved using simple recursive traversal. We can keep track of the level of a node by
 * passing a parameter to all recursive calls. The idea is to keep track of the maximum level also. Whenever
 * we see a node whose level is more than maximum level so far, we print the node because this is the first node
 * in its level (Note that we traverse the left subtree before right subtree).
 */



// Java program to print left view of binary tree

/* Class containing left and right child of current
node and key value*/

/* Class to print the left view */
class LeftViewOfBinaryTree {
    TreeNode root;
    static int max_level = 0;

    // recursive function to print left view
    void leftViewUtil(TreeNode node, int level)
    {
        // Base Case
        if (node == null)
            return;

        // If this is the first node of its level
        if (max_level < level) {
            System.out.print(" " + node.data);
            max_level = level;
        }

        // Recur for left and right subtrees
        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    // A wrapper over leftViewUtil()
    void leftView()
    {
        leftViewUtil(root, 1);
    }

    /* testing for example nodes */
    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        LeftViewOfBinaryTree tree = new LeftViewOfBinaryTree();
        tree.root = new TreeNode(12);
        tree.root.left = new TreeNode(10);
        tree.root.right = new TreeNode(30);
        tree.root.right.left = new TreeNode(25);
        tree.root.right.right = new TreeNode(40);

        tree.leftView();
    }
}