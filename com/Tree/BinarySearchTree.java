package com.Tree;


//Progress => //4
public class BinarySearchTree {
	TreeNode root;

	BinarySearchTree() {
		root = null;
	}

	public static void main(String[] args) {
		BinarySearchTree bt = new BinarySearchTree();
		bt.insertTree( 10);
		bt.insertTree( 20);
		bt.insertTree( 5);
		bt.insertTree( 56);
		bt.insertTree(56);
		bt.insertTree(80);
		
		bt.traverse();
		System.out.println(bt.search(20));
		
		System.out.println("Is BST =  " + bt.isBST());
	}
	
	boolean isBST() {
		return isBST(root);
	}

	void insertTree(int data){
		root = insert(root, data);
	}
	
	boolean search(int data){
		return search(root, data);
	}
	private boolean search(TreeNode root, int data) {
		boolean found = false;
		if(root == null){
			return false;
		}
		else if(data == root.data){
			found = true;
			return found;
		}else if(data < root.data){
			return search(root.left, data);
		}else{
			return search(root.right, data);
		}
		
	}

	void traverse(){
		inorder(root);
	}


	TreeNode insert(TreeNode root, int param) {
		if (root == null) {
			TreeNode node = new TreeNode(param);
			return node;
		} else if (root.data < param) {
			root.right = insert(root.right, param);
		} else {
			root.left = insert(root.left, param);
		}

		return root;
	}

	void inorder(TreeNode root) {
		if (root != null) {
			
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);

		}
	}
	
	 boolean isBST(TreeNode root) {
		 boolean ret= false;
		if(root == null) {
			return true;
		}
		if(root.left != null && root.data<root.left.data) {
			return false;
		}
		if(root.right != null && root.data>root.right.data) {
			return false;
		}
		
		ret = isBST(root.left);
		ret = isBST(root.right);
		
		return ret;
	}

}
