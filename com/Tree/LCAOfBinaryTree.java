package com.Tree;
//Progress => //4
public class LCAOfBinaryTree {

    //Root of the Binary Tree
    TreeNode root;

    TreeNode findLCA(int n1, int n2)
    {
        return findLCA(root, n1, n2);
    }

    // This function returns pointer to LCA of two given values n1 and n2. This function assumes that n1 and
    // n2 are present in Binary Tree
    TreeNode findLCA(TreeNode root, int n1, int n2)
    {
        // Base case
        if (root == null)
            return null;

        // If either n1 or n2 matches with root's key, report the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (root.data == n1 || root.data == n2)
            return root;

        // Look for keys in left and right subtrees
        TreeNode left_lca = findLCA(root.left, n1, n2);
        TreeNode right_lca = findLCA(root.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in one subtree and other is present in other, So this node is the LCA
        if (left_lca!=null && right_lca!=null)
            return root;

        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        LCAOfBinaryTree tree = new LCAOfBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        System.out.println("LCA(4, 5) = " + tree.findLCA(4, 5).data);
        System.out.println("LCA(4, 6) = " + tree.findLCA(4, 6).data);
        System.out.println("LCA(3, 4) = " + tree.findLCA(3, 4).data);
        System.out.println("LCA(2, 4) = " + tree.findLCA(2, 4).data);
    }

}
