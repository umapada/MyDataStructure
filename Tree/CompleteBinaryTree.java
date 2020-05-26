package Tree;
// Given a binary tree, determine if it is a complete binary tree.

/**
 * A complete binary tree is a binary tree whose all levels except the last level are completely filled and all the
 * leaves in the last level are all to the left side
 */

/**
 * In the array representation of a binary tree, if the parent node is assigned an index of ‘i’ and left child gets
 * assigned an index of ‘2*i + 1’ while the right child is assigned an index of ‘2*i + 2’. If we represent the above
 * binary tree as an array with the respective indices assigned to the different nodes of the tree above from top to
 * down and left to right.
 *
 * Hence we proceed in the following manner in order to check if the binary tree is complete binary tree.
 *
 * Calculate the number of nodes (count) in the binary tree.
 * Start recursion of the binary tree from the root node of the binary tree with index (i) being set as 0 and the
 * number of nodes in the binary (count).
 * If the current node under examination is NULL, then the tree is a complete binary tree. Return true.
 * If index (i) of the current node is greater than or equal to the number of nodes in the binary tree (count)
 * i.e. (i>= count), then the tree is not a complete binary. Return false.
 * Recursively check the left and right sub-trees of the binary tree for same condition. For the left sub-tree use the
 * index as (2*i + 1) while for the right sub-tree use the index as (2*i + 2).
 */


// Java program to check if binay tree is complete or not

class CompleteBinaryTree
{
    Node root;

    /* This function counts the number of nodes in a binary tree */
    int countNodes(Node root)
    {
        if (root == null)
            return (0);
        return (1 + countNodes(root.left) + countNodes(root.right));
    }

    /* This function checks if the binary tree is complete or not */
    boolean isComplete(Node root, int index, int number_nodes)
    {
        // An empty tree is complete
        if (root == null)
            return true;

        // If index assigned to current node is more than
        // number of nodes in tree, then tree is not complete
        if (index >= number_nodes)
            return false;

        // Recur for left and right subtrees
        return (isComplete(root.left, 2 * index + 1, number_nodes)
                && isComplete(root.right, 2 * index + 2, number_nodes));

    }

    // Driver program
    public static void main(String args[])
    {
        CompleteBinaryTree tree = new CompleteBinaryTree();

        // Le us create tree in the last diagram above
        Node NewRoot = null;
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.left.left = new Node(4);
        tree.root.right.right = new Node(6);

        int node_count = tree.countNodes(tree.root);
        int index = 0;

        if (tree.isComplete(tree.root, index, node_count))
            System.out.print("The binary tree is complete");
        else
            System.out.print("The binary tree is not complete");
    }
}

// This code is contributed by Mayank Jaiswal
