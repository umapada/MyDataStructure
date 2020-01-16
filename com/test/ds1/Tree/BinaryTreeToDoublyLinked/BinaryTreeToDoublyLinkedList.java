package com.test.ds1.Tree.BinaryTreeToDoublyLinked;

import com.test.ds1.Tree.TreeNode;
/**
 * Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place. The left and right pointers in nodes
 * are to be used as previous and next pointers respectively in converted DLL. The order of nodes in DLL must be
 * same as Inorder of the given Binary Tree. The first node of Inorder traversal (left most node in BT) must be
 * head node of the DLL.
 */


/**
 * The idea is to do inorder traversal of the binary tree. While doing inorder traversal, keep track of the
 * previously visited node in a variable say prev. For every visited node, make it next of prev and
 * previous of this node as prev.
 */


class BinaryTreeToDoublyLinkedList
{
    TreeNode root;

    // head --> Pointer to head node of created doubly linked list
    TreeNode head;

    // Initialize previously visited node as NULL. This is
    // static so that the same value is accessible in all recursive
    // calls
    static TreeNode prev = null;

    // A simple recursive function to convert a given Binary tree
    // to Doubly Linked List
    // root --> Root of Binary Tree
    void BinaryTree2DoubleLinkedList(TreeNode root)
    {
        // Base case
        if (root == null)
            return;

        // Recursively convert left subtree
        BinaryTree2DoubleLinkedList(root.left);

        // Now convert this node
        if (prev == null)
            head = root;
        else
        {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        // Finally convert right subtree
        BinaryTree2DoubleLinkedList(root.right);
    }

    /* Function to print nodes in a given doubly linked list */
    void printList(TreeNode node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        // Let us create the tree as shown in above diagram
        BinaryTreeToDoublyLinkedList tree = new BinaryTreeToDoublyLinkedList();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(12);
        tree.root.right = new TreeNode(15);
        tree.root.left.left = new TreeNode(25);
        tree.root.left.right = new TreeNode(30);
        tree.root.right.left = new TreeNode(36);

        // convert to DLL
        tree.BinaryTree2DoubleLinkedList(tree.root);

        // Print the converted List
        tree.printList(tree.head);

    }
}