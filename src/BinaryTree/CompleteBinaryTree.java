package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;


public class CompleteBinaryTree {

	Node root;
	
	public CompleteBinaryTree()
    {
        root = null;
    }
    
	 public static void main(String args[]) {
		 CompleteBinaryTree tree = new CompleteBinaryTree();
	       tree.root= new Node(1);
	       tree.root.left= new Node(2);
	       tree.root.right= new Node(3);
	       tree.root.left.left= new Node(4);
	       tree.root.left.right= new Node(5);
	       
	       tree.root.right.left = new Node(6);
	        
	       boolean isCompleteTree = tree.checkCompleteTree();
	       System.out.println("is complete tree :"+isCompleteTree);
	       
	       
	       
	    }

	private boolean checkCompleteTree() {
		
		// Base Case: An empty tree is complete Binary Tree 
		if(root == null) {
			return true;
		}
		
		boolean isCompleteTree = false;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			if(temp.left != null) {
				/*
				 * if tree is complete binary tree already and left side node is available then we need to return false;
				 */
				if(isCompleteTree) {
					return false;
				}
				queue.add(temp.left);
			} else {
				/*
				 * if left node is not there then either tree is complete tree or any right element is present then not a complete
				 * for complete binary tree all the next nodes should be null also.
				 */
				isCompleteTree = true;
			}
			
			if(temp.right != null) {
				if(isCompleteTree) {
					return false;
				}
				queue.add(temp.right);
			} else {
				isCompleteTree = true;
			}
		}
		return true;
	}

}
