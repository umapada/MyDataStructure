package com.Tree;
//Progress => //4
//Time Complexity: O(n^2)
class DiameterBinaryTree
{
    TreeNode root;

    /* Method to calculate the diameter and return it to main */
    int diameter(TreeNode root)
    {
        /* base case if tree is empty */
        if (root == null)
            return 0;
 
        /* get the height of left and right sub trees */
        int lheight = height(root.left);
        int rheight = height(root.right);
 
        /* get the diameter of left and right subtrees */
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);
 
        /* Return max of following three
          1) Diameter of left subtree
         2) Diameter of right subtree
         3) Height of left subtree + height of right subtree + 1 */
        return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
 
    }
 
    /* A wrapper over diameter(Node root) */
    int diameter()
    {
        return diameter(root);
    }
 
    /*The function Compute the "height" of a tree. Height is the
      number of nodes along the longest path from the root node
      down to the farthest leaf node.*/
    static int height(TreeNode node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;
 
        /* If tree is not empty then height = 1 + max of left
           height and right heights */
        return (1 + Math.max(height(node.left), height(node.right)));
    }

    static int  d = 0;
    static int D(TreeNode root){
        if (root == null) {
            return 0;
        }
        int l = D(root.left);
        int r = D(root.right);
        if(d < l + r){
            d = l + r;
        }
        return 1 + Math.max(l,r);
    }

    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
    	DiameterBinaryTree tree = new DiameterBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
 
        System.out.println("The diameter of given binary tree is : " + tree.diameter());
        D(tree.root);
        System.out.println(d + 1);
    }
}