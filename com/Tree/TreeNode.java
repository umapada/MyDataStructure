package com.Tree;

/* A binary tree node has data, pointer to left child, and a pointer to right child */
public class TreeNode
{
    public int data;
    public int val;
    public TreeNode left, right, parent;
    int hd; //Horizontal Distance
 public TreeNode(int d)
 {
     data = d;
     val = d;
     left = right = null;
 }
// TreeNode(){
//
// }
}

// Java program to remove half nodes
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
