package Cmpny.FB;

import com.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 */
public class BinaryTreeRightSideView {
    class Max_level {
        int max_level;
    }

    Max_level max = new Max_level();
    static List<Integer> ret = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        ret.clear();
        rightViewUtil(root, 1, max);
        return ret;
    }

    void rightViewUtil(TreeNode node, int level, Max_level max_level) {

        // Base Case
        if (node == null)
            return;

        // If this is the last Node of its level
        if (max_level.max_level < level) {
            ret.add(node.data);
            max_level.max_level = level;
        }

        // Recur for right subtree first, then left subtree
        rightViewUtil(node.right, level + 1, max_level);
        rightViewUtil(node.left, level + 1, max_level);

    }
}
