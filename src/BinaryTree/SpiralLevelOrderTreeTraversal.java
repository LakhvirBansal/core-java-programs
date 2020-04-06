package BinaryTree;

import java.util.Stack;

public class SpiralLevelOrderTreeTraversal {

	Node root;
	
	public SpiralLevelOrderTreeTraversal()
    {
        root = null;
    }
    
	 public static void main(String args[]) {
		 SpiralLevelOrderTreeTraversal tree = new SpiralLevelOrderTreeTraversal();
	       tree.root= new Node(1);
	       tree.root.left= new Node(2);
	       tree.root.right= new Node(3);
	       tree.root.left.left= new Node(4);
	       tree.root.left.right= new Node(5);
	       tree.root.right.left = new Node(18);
	       tree.root.right.right = new Node(7);
	       tree.root.left.right.left = new Node(17);
	       tree.root.left.right.right = new Node(6);
	       tree.root.left.right.left.left = new Node(19);
	       
	       System.out.println(" spiral order traversal of binary tree is ");
	       tree.printSpiralOrderTraversal();
	    }

	private void printSpiralOrderTraversal() {
		if(root == null) {
			return;
		}
		
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		stack1.push(root);
		
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			
			while(! stack1.isEmpty()) {
				Node node = stack1.pop();
				System.out.print(node.data+ " ");
				if(node.left != null) {
					stack2.push(node.left);
				}
				if(node.right != null) {
					stack2.push(node.right);
				}
			}
			
			while(! stack2.isEmpty()) {
				Node node = stack2.pop();
				System.out.print(node.data+ " ");
				if(node.right != null) {
					stack1.push(node.right);
				}
				if(node.left != null) {
					stack1.push(node.left);
				}
			}
		}
		
	}

}
