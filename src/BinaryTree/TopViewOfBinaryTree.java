package BinaryTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class TopViewOfBinaryTree {

	Node root;
	
	public TopViewOfBinaryTree()
    {
        root = null;
    }
 
	 public static void main(String args[]) {
		 TopViewOfBinaryTree tree = new TopViewOfBinaryTree();
	       tree.root = new Node(1);
	       tree.root.left = new Node(2);
	       tree.root.right = new Node(3);
	       tree.root.left.left = new Node(4);
	       tree.root.left.right = new Node(5);
	       tree.root.right.left = new Node(6);
	       tree.root.right.right = new Node(7);
	       tree.root.right.left.right = new Node(8);
	        
	       System.out.println("Top view of binary tree is ");
	       tree.printTopView();
	       
	    }

	private void printTopView() {
		if(root == null) {
			return;
		}
		
		Map<Integer, Node> treeMap = new TreeMap<Integer, Node>();
		Queue<NodeWithDistance> queue = new LinkedList<NodeWithDistance>();
		queue.add(new NodeWithDistance(root, 0));
	
		while(!queue.isEmpty()) {
			NodeWithDistance queueNode = queue.poll();
			if(! treeMap.containsKey(queueNode.distance)) {
				treeMap.put(queueNode.distance, queueNode.node);
			} 
			if(queueNode.node.left != null) {
				queue.add(new NodeWithDistance(queueNode.node.left, queueNode.distance -1));
			}
			if(queueNode.node.right != null) {
				queue.add(new NodeWithDistance(queueNode.node.right, queueNode.distance + 1));
			}
		}
		
		Set<Integer> keySet = treeMap.keySet();
		Iterator<Integer> itr = keySet.iterator();
		while (itr.hasNext()) {
			Integer key = (Integer) itr.next();
			Node node = treeMap.get(key);
			
			System.out.print(node.data+" ");
			System.out.println("");
		}
		
	}

}
