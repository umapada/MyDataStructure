package com.test.ds1.Tree;

/* A binary tree node has data, pointer to left child,
and a pointer to right child */
class TreeNode
{
 int data;
 TreeNode left, right, parent;
    int hd; //Horizontal Distance
 TreeNode(int d)
 {
     data = d;
     left = right = null;
 }
 TreeNode(){

 }
}
