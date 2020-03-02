package com.Tree;
// Java program to correct the BST
// if two nodes are swapped
import java.util.*;
import java.lang.*;
import java.io.*;
/*
Two of the nodes of a Binary Search Tree (BST) are swapped. Fix (or correct) the BST.
Input Tree:
         10
        /  \
       5    8
      / \
     2   20

In the above tree, nodes 20 and 8 must be swapped to fix the tree.
Following is the output tree
         10
        /  \
       5    20
      / \
     2   8
 */


/*

We can solve this in O(n) time and with a single traversal of the given BST. Since inorder traversal of BST is always a
 sorted array, the problem can be reduced to a problem where two elements of a sorted array are swapped. There are two
 cases that we need to handle:



1. The swapped nodes are not adjacent in the inorder traversal of the BST.

 For example, Nodes 5 and 25 are swapped in {3 5 7 8 10 15 20 25}.
 The inorder traversal of the given tree is 3 25 7 8 10 15 20 5
If we observe carefully, during inorder traversal, we find node 7 is smaller than the previous visited node 25. Here
 save the context of node 25 (previous node). Again, we find that node 5 is smaller than the previous node 20. This
  time, we save the context of node 5 ( current node ). Finally swap the two node’s values.

2. The swapped nodes are adjacent in the inorder traversal of BST.

  For example, Nodes 7 and 8 are swapped in {3 5 7 8 10 15 20 25}.
  The inorder traversal of the given tree is 3 5 8 7 10 15 20 25
Unlike case #1, here only one point exists where a node value is smaller than previous node value. e.g. node 7 is
smaller than node 8.

How to Solve? We will maintain three pointers, first, middle and last. When we find the first point where current node
value is smaller than previous node value, we update the first with the previous node & middle with the current node.
When we find the second point where current node value is smaller than previous node value, we update the last with
the current node. In case #2, we will never find the second point. So, last pointer will not be updated. After
processing, if the last node value is null, then two swapped nodes of BST are adjacent.

 */


class TwoNodesOfBSTSwapped
{
    Node first, middle, last, prev;

    // This function does inorder traversal
    // to find out the two swapped nodes.
    // It sets three pointers, first, middle
    // and last. If the swapped nodes are
    // adjacent to each other, then first
    // and middle contain the resultant nodes
    // Else, first and last contain the
    // resultant nodes
    void correctBSTUtil( Node root)
    {
        if( root != null )
        {
            // Recur for the left subtree
            correctBSTUtil( root.left);

            // If this node is smaller than
            // the previous node, it's
            // violating the BST rule.
            if (prev != null && root.data <
                    prev.data)
            {
                // If this is first violation,
                // mark these two nodes as
                // 'first' and 'middle'
                if (first == null)
                {
                    first = prev;
                    middle = root;
                }

                // If this is second violation,
                // mark this node as last
                else
                    last = root;
            }

            // Mark this node as previous
            prev = root;

            // Recur for the right subtree
            correctBSTUtil( root.right);
        }
    }

    // A function to fix a given BST where
    // two nodes are swapped. This function
    // uses correctBSTUtil() to find out
    // two nodes and swaps the nodes to
    // fix the BST
    void correctBST( Node root )
    {
        // Initialize pointers needed
        // for correctBSTUtil()
        first = middle = last = prev = null;

        // Set the poiters to find out
        // two nodes
        correctBSTUtil( root );

        // Fix (or correct) the tree
        if( first != null && last != null )
        {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }
        // Adjacent nodes swapped
        else if( first != null && middle !=
                null )
        {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }

        // else nodes have not been swapped,
        // passed tree is really BST.
    }

    /* A utility function to print
    Inoder traversal */
    void printInorder(Node node)
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(" " + node.data);
        printInorder(node.right);
    }


    // Driver program to test above functions
    public static void main (String[] args)
    {
		/* 6
			/ \
		10 2
		/ \ / \
		1 3 7 12

		10 and 2 are swapped
		*/

        Node root = new Node(6);
        root.left = new Node(10);
        root.right = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(12);
        root.right.left = new Node(7);

        System.out.println("Inorder Traversal"+
                " of the original tree");
        TwoNodesOfBSTSwapped tree = new TwoNodesOfBSTSwapped();
        tree.printInorder(root);

        tree.correctBST(root);

        System.out.println("\nInorder Traversal"+
                " of the fixed tree");
        tree.printInorder(root);
    }
}
//    Time Complexity: O(n)
