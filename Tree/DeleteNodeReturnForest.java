package Tree;
/*
Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.

Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]

 */


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class DeleteNodeReturnForest {
    List<TreeNode> res = new ArrayList<>();
    Set<Integer> set = new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        for (int i : to_delete) set.add(i);

        if (!set.contains(root.val)) res.add(root);
        dfs(root);
        return res;
    }

    private TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }
        node.left = dfs(node.left);
        node.right = dfs(node.right);
        if (set.contains(node.val)) {
            if (node.left != null) res.add(node.left);
            if (node.right != null) res.add(node.right);
            return null;
        }
        return node;
    }
}