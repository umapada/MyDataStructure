package com.Tree;

import java.util.*;

/*
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples 1:

Input: [3,9,20,null,null,15,7]

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7

Output:

[
  [9],
  [3,15],
  [20],
  [7]
]
Examples 2:

Input: [3,9,8,4,0,1,7]

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7

Output:

[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Examples 3:

Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2

Output:

[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
 */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class VerticalSumLeftToRight {

    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if(root == null) {
            return res;
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> code = new LinkedList<>();

        queue.offer(root);
        code.offer(0);

        while(!queue.isEmpty()){
            TreeNode front = queue.poll();
            int val = code.poll();

            if(!map.containsKey(val)){
                map.put(val, new ArrayList<>());
            }
            map.get(val).add(front.val);

            if(front.left != null){
                queue.offer(front.left);
                code.offer(val-1);
            }
            if(front.right != null){
                queue.offer(front.right);
                code.offer(val+1);
            }
        }

        res.addAll(map.values());
        return res;

    }

}