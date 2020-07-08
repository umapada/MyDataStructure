package Tree;

import java.util.*;

/**
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be
 * serialized to a string and this string can be deserialized to the original tree structure.
 */

//Pre Order traversal
class SerializeDeserializeBST {
    private static final String NULL_SYMBOL = "X";
    private static final String DELIMITER = ",";

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        String str = serialize(root);
        System.out.println();
        System.out.println("Serialized tree = " + str);
        TreeNode d_root = deserialize(str);
    }

    public static String serialize(TreeNode root) {

        // If we have a null symbol...we encode a null symbol
        if (root == null) {
            return NULL_SYMBOL + DELIMITER;
        }

        String leftSerialized = serialize(root.left);
        String rightSerialized = serialize(root.right);

        // Here we append the node we hold ('root') to the other serializations

        return root.data + DELIMITER + leftSerialized + rightSerialized;
    }

    /*
     * Here we take the string and simply split it on the delimiter. We then have a
     * list of values we can materialize into nodes
     */
    public static TreeNode deserialize(String data) {
        if(data == null) return null;
        Queue<String> nodesLeftToMaterialize = new LinkedList<>(Arrays.asList(data.split(DELIMITER)));
        return deserializeHelper(nodesLeftToMaterialize);
    }

    private static TreeNode deserializeHelper(Queue<String> nodesLeftToMaterialize) {

        String valueForNode = nodesLeftToMaterialize.poll();

        if (valueForNode.equals(NULL_SYMBOL)) {
            return null;
        }
        TreeNode newNode = new TreeNode(Integer.valueOf(valueForNode));
        newNode.left = deserializeHelper(nodesLeftToMaterialize);
        newNode.right = deserializeHelper(nodesLeftToMaterialize);


        return newNode;
    }
}
// =========================================