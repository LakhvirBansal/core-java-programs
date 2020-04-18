package BinaryTree;

public class BoundryLevelTraversal {

	Node root;
	
	public BoundryLevelTraversal()
    {
        root = null;
    }
    
	 public static void main(String args[]) {
		 BoundryLevelTraversal tree = new BoundryLevelTraversal();
	       tree.root= new Node(1);
	       tree.root.left= new Node(2);
	       tree.root.right= new Node(3);
	       tree.root.left.left= new Node(4);
	       tree.root.left.right= new Node(5);
	        
	       tree.root.left.right.right= new Node(6);
	       tree.root.right.right= new Node(7);
	       tree.root.right.right.right= new Node(8);
	       System.out.println("boundry traversal of binary tree is :");
	       tree.printBoundryTraversalOfBinaryTree();
	       
	    }

	private void printBoundryTraversalOfBinaryTree() {
		printLeftSideExceptLeafNodes(root);
		System.out.println("");
		printLeafNodes(root);
		System.out.println("");
		printRightSideExceptLeafNodes(root.right);
	}

	private void printRightSideExceptLeafNodes(Node root) {
		if(root == null) {
			return;
		}
		
		if(root.left == null && root.right == null) {
			return;
		}
		printRightSideExceptLeafNodes(root.right);
		System.out.print(root.data +" ");
	}

	private void printLeafNodes(Node root) {
		if(root == null) {
			return;
		}
		
		if(root.left == null && root.right == null) {
			System.out.print(root.data +" ");;
		}
		
		printLeafNodes(root.left);
		printLeafNodes(root.right);
		
	}

	private void printLeftSideExceptLeafNodes(Node root) {
		
		if(root == null) {
			return;
		}
		
		if(root.left == null && root.right == null) {
			return;
		}
		
		System.out.print(root.data +" ");
		printLeftSideExceptLeafNodes(root.left);
	}

}
