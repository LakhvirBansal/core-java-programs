package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LeafNodesCount {

	Node root;
	
	public LeafNodesCount()
    {
        root = null;
    }
    
	 public static void main(String args[]) {
		 LeafNodesCount tree = new LeafNodesCount();
	       tree.root= new Node(1);
	       tree.root.left= new Node(2);
	       tree.root.right= new Node(3);
	       tree.root.left.left= new Node(4);
	       tree.root.left.right= new Node(5);
	       tree.root.right.left = new Node(18);
	       tree.root.right.right = new Node(7);
	       
	       int count = tree.leafNodesCount();
	       System.out.println("leaf nodes count "+count);
	    }

	private int leafNodesCount() {
		if(root == null) {
			return 0;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		int count = 0;
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			
			if(temp.left == null && temp.right == null) {
				count++;
			}
			
			if(temp.left != null) {
				queue.add(temp.left);
			}
			
			if(temp.right != null) {
				queue.add(temp.right);
			}
		}
		
		return count;
	}

}
