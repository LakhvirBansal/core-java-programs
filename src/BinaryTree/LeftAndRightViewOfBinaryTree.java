package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftAndRightViewOfBinaryTree {

	Node root;
	
	public LeftAndRightViewOfBinaryTree()
    {
        root = null;
    }
 
	 public static void main(String args[]) {
		 LeftAndRightViewOfBinaryTree tree = new LeftAndRightViewOfBinaryTree();
	       tree.root = new Node(1);
	       tree.root.left = new Node(2);
	       tree.root.right = new Node(3);
	       tree.root.left.left = new Node(4);
	       tree.root.left.right = new Node(5);
	       tree.root.right.left = new Node(6);
	       tree.root.right.right = new Node(7);
	       tree.root.right.left.right = new Node(8);
	        
	       System.out.println("left view of binary tree is ");
	       tree.printLeftView();
	       
	       System.out.println("right view of binary tree is ");
	       tree.printRightView();
	       
	    }

	 private void printLeftView() {
			if(root == null) {
				return;
			}
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			while(queue.size() > 0) {
				int count = queue.size();
				int queueCount = queue.size();
				while (count > 0) {
					Node temp = queue.remove();
					if(count == queueCount) {
						System.out.print(temp.data+" ");
					}
					if(temp.left != null) {
						queue.add(temp.left);
					}
					
					if(temp.right != null) {
						queue.add(temp.right);
					}
					count--;
				}
			}
			System.out.println("");
		}
	 
	 private void printRightView() {
			if(root == null) {
				return;
			}
			Queue<Node> queue = new LinkedList<Node>();
			queue.offer(root);
			while(queue.size() > 0) {
				int count = queue.size();
				while (count > 0) {
					Node temp = queue.poll();
					if(count == 1) {
						System.out.print(temp.data+" ");
					}
					if(temp.left != null) {
						queue.add(temp.left);
					}
					
					if(temp.right != null) {
						queue.add(temp.right);
					}
					count--;
				}
			}
			System.out.println("");
		}

}
