package Tree;

import java.util.ArrayList;
import java.util.List;

public class PrintAllAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> list = new ArrayList<>();

        printAll(root, list, new TreeNode(6));

        list.stream().forEach(x -> {
            System.out.println(x);
        });

    }

    static boolean printAll(TreeNode root, List<Integer> list, TreeNode data) {
        if (root == null) {
            return false;
        }
        if (root.val == data.val || printAll(root.left, list, data) || printAll(root.right, list, data)) {
            list.add(root.val);
            return true;
        }
        return false;
    }

}
