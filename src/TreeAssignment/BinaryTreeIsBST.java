package TreeAssignment;

class Node{
	int key;
	Node left, right;
	
	Node(int val){
		key = val;
		left = right = null;
	}
}

public class BinaryTreeIsBST {


	
	Node root;
	
	private boolean isBST() {
		return isBSTUtil(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	private boolean isBSTUtil(Node root, int min, int max) {
		if(root == null){
			return true;
		}
		
		 if (root.key < min || root.key > max)
	            return false;
	 
	        /* otherwise check the subtrees recursively
	        tightening the min/max constraints */
	        // Allow only distinct values
	        return (isBSTUtil(root.left, min, root.key-1) &&
	                isBSTUtil(root.right, root.key+1, max));
	}

	public static void main(String[] args) {
		BinaryTreeIsBST tree = new BinaryTreeIsBST();
        tree.root = new Node(4);
        tree.root.left = new Node(3);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(2);
        //tree.root.left.right = new Node(6);
 
        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
	}

	
}
