package Tree;

import java.util.*;

/**
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be
 * serialized to a string and this string can be deserialized to the original tree structure.
 */

//Pre Order traversal
class Solution {
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
        Queue<String> nodesLeftToMaterialize = new LinkedList<>();
        nodesLeftToMaterialize.addAll(Arrays.asList(data.split(DELIMITER)));
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


public class SerializeDeserializeBST {

 //   Java Solution 2 - Preorder Traversal


    private TreeNode deserializeArrayOptimized(int[] preorder, int[] currIndex, int min, int max)
	    {
	        if (currIndex[0] >= preorder.length) return null;

	        TreeNode root = null;

	        if ((preorder[currIndex[0]] > min) && (preorder[currIndex[0]] < max))
	        {
	            root = new TreeNode(preorder[currIndex[0]]);
	            currIndex[0] += 1;
	            root.left = deserializeArrayOptimized(preorder, currIndex, min, root.data);
	            root.right = deserializeArrayOptimized(preorder, currIndex, root.data, max);
	        }

	        return root;
	    }

	    private int findDivision(int[] preorder, int value, int low, int high)
	    {
	        int i;
	        for (i = low; i <= high; i++)
	        {
	            if (value < preorder[i])
	                break;
	        }
	        return i;
	    }

	    private TreeNode deserializeArray(int[] preorder, int low, int high)
	    {
	        if (low > high) return null;

	        TreeNode root = new TreeNode(preorder[low]);

	        int divIndex = findDivision(preorder, root.data, low+1, high);

	        root.left = deserializeArray(preorder, low + 1, divIndex - 1);
	        root.right = deserializeArray(preorder, divIndex, high);

	        return root;
	    }

 // Encodes a tree to a single string.
  String serialize(TreeNode root) {
     if(root==null)
         return null;

     Stack<TreeNode> stack = new Stack<TreeNode>();
     stack.push(root);
     StringBuilder sb = new StringBuilder();

     while(!stack.isEmpty()){
         TreeNode h = stack.pop();
         if(h!=null){
             sb.append(h.data+",");
             stack.push(h.right);
             stack.push(h.left);
         }else{
             sb.append("#,");
         }
     }

     return sb.toString().substring(0, sb.length()-1);
 }

    // Decodes your encoded data to tree.
    TreeNode deserialize(String data) {
        if(data == null)
            return null;

        int[] t = {0};
        String[] arr = data.split(",");

        return helper(arr, t);
    }

    TreeNode helper(String[] arr, int[] t){
        if(arr[t[0]].equals("#")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[t[0]]));

        t[0]=t[0]+1;
        root.left = helper(arr, t);
        t[0]=t[0]+1;
        root.right = helper(arr, t);

        return root;
    }


// Java Solution 1 - Level Order Traveral

    // Encodes a tree to a single string.
    String serialize2(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode h = q.poll();
            if (h == null) {
                list.add("#");
            } else {
                list.add("" + h.data);
                q.offer(h.left);
                q.offer(h.right);
            }
        }

        return String.join(",", list);
    }

    // Decodes your encoded data to tree.
    TreeNode deserialize2(String data) {
        String[] arr = data.split(",");
        if (arr[0].equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty()) {
            TreeNode h = q.poll();
            if (h != null) {
                TreeNode left = null;
                if (!arr[i].equals("#")) {
                    left = new TreeNode(Integer.parseInt(arr[i]));
                }
                h.left = left;
                q.offer(left);
                i++;

                TreeNode right = null;
                if (!arr[i].equals("#")) {
                    right = new TreeNode(Integer.parseInt(arr[i]));
                }
                h.right = right;
                q.offer(right);
                i++;
            }
        }

        return root;
    }

}