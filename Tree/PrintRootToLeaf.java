package Tree;

import java.util.ArrayList;
import java.util.List;

public class PrintRootToLeaf {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

       // root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> list = new ArrayList<>();

        findPath(root, list, new ArrayList<Integer>());

        list.stream().forEach(x-> {
            x.stream().forEach(System.out::print);
            System.out.println();
        });

    }

    static void findPath(TreeNode root, List<List<Integer>> list, List<Integer> temp){
        if(root != null) {
            temp.add(Integer.valueOf(root.val));

            if (root.left == null && root.right == null) {
                list.add(new ArrayList<>(temp));
            }

            findPath(root.left, list, temp);
            findPath(root.right, list, temp);
            temp.remove(Integer.valueOf(root.val));
        }

    }

}
