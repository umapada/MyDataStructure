package com.test.ds1.Tree;

//Java implementation of a O(n) time 
//method for Zigzag order traversal
import java.util.*;

//Binary Tree node
class ZNode {
	int data;
	ZNode leftChild;
	ZNode rightChild;

	ZNode(int data) {
		this.data = data;
	}
}

class ZBinaryTree {
	ZNode rootNode;

	// function to print the
	// zigzag traversal
	void printZigZagTraversal() {

		// if null then return
		if (rootNode == null) {
			return;
		}

		// declare two stacks
		Stack<ZNode> currentLevel = new Stack<>();
		Stack<ZNode> nextLevel = new Stack<>();

		// push the root
		currentLevel.push(rootNode);
		boolean leftToRight = true;

		// check if stack is empty
		while (!currentLevel.isEmpty()) {

			// pop out of stack
			ZNode node = currentLevel.pop();

			// print the data in it
			System.out.print(node.data + " ");

			// store data according to current
			// order.
			if (leftToRight) {
				if (node.leftChild != null) {
					nextLevel.push(node.leftChild);
				}

				if (node.rightChild != null) {
					nextLevel.push(node.rightChild);
				}
			} else {
				if (node.rightChild != null) {
					nextLevel.push(node.rightChild);
				}

				if (node.leftChild != null) {
					nextLevel.push(node.leftChild);
				}
			}

			if (currentLevel.isEmpty()) {
				leftToRight = !leftToRight;
				Stack<ZNode> temp = currentLevel;
				currentLevel = nextLevel;
				nextLevel = temp;
			}
		}
	}
}

public class ZigZagBinaryTree {

	// driver program to test the above function
	public static void main(String[] args) {
		ZBinaryTree tree = new ZBinaryTree();
		tree.rootNode = new ZNode(1);
		tree.rootNode.leftChild = new ZNode(2);
		tree.rootNode.rightChild = new ZNode(3);
		tree.rootNode.leftChild.leftChild = new ZNode(7);
		tree.rootNode.leftChild.rightChild = new ZNode(6);
		tree.rootNode.rightChild.leftChild = new ZNode(5);
		tree.rootNode.rightChild.rightChild = new ZNode(4);

		System.out.println("ZigZag Order traversal of binary tree is");
		tree.printZigZagTraversal();
	}
}
