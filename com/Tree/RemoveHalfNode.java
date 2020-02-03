package com.Tree;

/**
 * Given A binary Tree, how do you remove all the half nodes (which has only one child)?
 * Note leaves should not be touched as they have both children as NULL.
 */


class RemoveHalfNode
{
    Node root;

    void printInorder(Node node)
    {
        if (node != null)
        {
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
        }
    }

    // Removes all nodes with only one child and returns
    // new root (note that root may change)
    Node RemoveHalfNodes(Node node)
    {
        if (node == null)
            return null;

        node.left = RemoveHalfNodes(node.left);
        node.right = RemoveHalfNodes(node.right);

        if (node.left == null && node.right == null)
            return node;

		/* if current nodes is a half node with left
		child NULL left, then it's right child is
		returned and replaces it in the given tree */
        if (node.left == null)
        {
            Node new_root = node.right;
            return new_root;
        }

		/* if current nodes is a half node with right
		child NULL right, then it's right child is
		returned and replaces it in the given tree */
        if (node.right == null)
        {
            Node new_root = node.left;
            return new_root;
        }

        return node;
    }

    // Driver program
    public static void main(String args[])
    {
        RemoveHalfNode tree = new RemoveHalfNode();
        Node NewRoot = null;
        tree.root = new Node(2);
        tree.root.left = new Node(7);
        tree.root.right = new Node(5);
        tree.root.left.right = new Node(6);
        tree.root.left.right.left = new Node(1);
        tree.root.left.right.right = new Node(11);
        tree.root.right.right = new Node(9);
        tree.root.right.right.left = new Node(4);

        System.out.println("the inorder traversal of tree is ");
        tree.printInorder(tree.root);

        NewRoot = tree.RemoveHalfNodes(tree.root);

        System.out.print("\nInorder traversal of the modified tree \n");
        tree.printInorder(NewRoot);
    }
}

// This code has been contributed by Mayank Jaiswal
