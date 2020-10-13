package Tree;

/**
 * Given a binary tree, print it vertically. The following example illustrates vertical order traversal.
 *            1
 *         /    \
 *        2      3
 *       / \   /   \
 *      4   5  6   7
 *                /  \
 *               8   9
 *
 *
 * The output of print this tree vertically will be:
 * 4
 * 2
 * 1 5 6
 * 3 8
 * 7
 * 9
 */

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

/**
 * We need to check the Horizontal Distances from the root for all nodes. If two nodes have the same Horizontal
 * Distance (HD), then they are on the same vertical line. The idea of HD is simple. HD for root is 0, a right edge
 * (edge connecting to right subtree) is considered as +1 horizontal distance and a left edge is considered as -1
 * horizontal distance. For example, in the above tree, HD for Node 4 is at -2, HD for Node 2 is -1, HD for 5 and
 * 6 is 0 and HD for node 7 is +2.
 * We can do preorder traversal of the given Binary Tree. While traversing the tree, we can recursively calculate HDs.
 * We initially pass the horizontal distance as 0 for root. For left subtree, we pass the Horizontal Distance as
 * Horizontal distance of root minus 1. For right subtree, we pass the Horizontal Distance as Horizontal Distance of
 * root plus 1. For every HD value, we maintain a list of nodes in a hash map. Whenever we see a node in traversal,
 * we go to the hash map entry and add the node to the hash map using HD as a key in a map.
 */


// Java program for printing vertical order of a given binary tree

    //TODO It should be implement with BFS, not dfs. With dfs, order not maintained from top to bottom
public class VerticalOrderPrintTree
{
    // Utility function to store vertical order in map 'm'
    // 'hd' is horizontal distance of current node from root.
    // 'hd' is initially passed as 0
    static void getVerticalOrder(TreeNode root, int hd, Map<Integer, List<Integer>> m)
    {
        // Base case
        if(root == null)
            return;

        //get the vector list at 'hd'
        List<Integer> get = m.get(hd);

        // Store current node in map 'm'
        if(get == null)
        {
            get = new Vector<>();
            get.add(root.data);
        }
        else {
            get.add(root.data);
        }
        m.put(hd, get);

        // Store nodes in left subtree
        getVerticalOrder(root.left, hd-1, m);

        // Store nodes in right subtree
        getVerticalOrder(root.right, hd+1, m);
    }

    // The main function to print vertical order of a binary tree
    // with the given root
    static void printVerticalOrder(TreeNode root)
    {
        // Create a map and store vertical order in map using
        // function getVerticalOrder()
        Map<Integer, List<Integer>> map = new TreeMap<>();
        int hd =0;
        getVerticalOrder(root,hd,map);

        // Traverse the map and print nodes at every horigontal
        // distance (hd)
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet())
        {
            System.out.println(entry.getValue());
        }
    }

    // Driver program to test above functions
    public static void main(String[] args) {

        // TO DO Auto-generated method stub
      /*  TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        */
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(8);
        root.right = new TreeNode(1);

        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(4);
        root.right.left.right.right = new TreeNode(7);

        root.right.right = new TreeNode(2);

        System.out.println("Vertical Order traversal is");
        printVerticalOrder(root);
    }
}

