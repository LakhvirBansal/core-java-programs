package BinaryTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

class NodeWithDistance {
	
	public Node node;
	public int distance;
	
	NodeWithDistance( Node node, int distance){
		this.node = node;
		this.distance = distance;
	}
	
}
public class VerticalTreeTraversal {

	Node root;
	
	public VerticalTreeTraversal()
    {
        root = null;
    }
 
	 public static void main(String args[]) {
		 VerticalTreeTraversal tree = new VerticalTreeTraversal();
	       tree.root = new Node(1);
	       tree.root.left = new Node(2);
	       tree.root.right = new Node(3);
	       tree.root.left.left = new Node(4);
	       tree.root.left.right = new Node(5);
	       tree.root.right.left = new Node(6);
	       tree.root.right.right = new Node(7);
	       tree.root.right.left.right = new Node(8);
	        
	       System.out.println("vertical order traversal of binary tree is ");
	       tree.printVerticalOrder();
	       
	    }

	private void printVerticalOrder() {
		if(root == null) {
			return;
		}
		
		Map<Integer, List<Node>> treeMap = new TreeMap<Integer, List<Node>>();
		Queue<NodeWithDistance> queue = new LinkedList<NodeWithDistance>();
		queue.add(new NodeWithDistance(root, 0));
	
		while(!queue.isEmpty()) {
			NodeWithDistance queueNode = queue.poll();
			if(treeMap.containsKey(queueNode.distance)) {
				treeMap.get(queueNode.distance).add(queueNode.node);
			} else {
				List<Node> nodesList = new ArrayList<Node>();
				nodesList.add(queueNode.node);
				treeMap.put(queueNode.distance, nodesList);
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
			List<Node> nodes = treeMap.get(key);
			
			for (Node node : nodes) {
				System.out.print(node.data+" ");
			}
			System.out.println("");
		}
		
	}

}
