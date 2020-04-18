package BinaryTree;

public class HeightOfBinaryTree {

	Node root;
	
	public HeightOfBinaryTree()
    {
        root = null;
    }
 
	 public static void main(String args[]) {
		 HeightOfBinaryTree tree = new HeightOfBinaryTree();
	       tree.root = new Node(1);
	       tree.root.left = new Node(2);
	       tree.root.right = new Node(6);
	       tree.root.left.left = new Node(3);
	       tree.root.left.right = new Node(4);
	       tree.root.left.right.right= new Node(5);
	       
	       int height = tree.getHeight();
	       System.out.println("Height of binary tree is :"+height);
	    }

	 private int getHeight() {
		return getHeight(root);
	}

	private int getHeight(Node root) {
		if(root == null) 
			return 0;
		else {
			int lh = getHeight(root.left);
			int rh = getHeight(root.right);
			return Math.max(lh, rh) + 1;
		}
	}

}
