package com.Tree;

/* A binary tree node has data, pointer to left child,
and a pointer to right child */
public class TreeNode
{
 public int data;
 public TreeNode left, right, parent;
    int hd; //Horizontal Distance
 public TreeNode(int d)
 {
     data = d;
     left = right = null;
 }
 TreeNode(){

 }
}
