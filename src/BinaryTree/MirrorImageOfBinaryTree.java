package BinaryTree;

public class MirrorImageOfBinaryTree {

	Node root;
	
	public MirrorImageOfBinaryTree()
    {
        root = null;
    }
    /*
     * to change a binary tree into its mirror image we need to use post order tree traversal
     * and when we print the node we just swap the left and right subtree at that point.
     */
	 public static void main(String args[]) {
		 MirrorImageOfBinaryTree tree = new MirrorImageOfBinaryTree();
	       tree.root= new Node(1);
	       tree.root.left= new Node(2);
	       tree.root.right= new Node(3);
	       tree.root.left.left= new Node(4);
	       tree.root.left.right= new Node(5);
	       tree.root.right.right = new Node(7);
	       tree.root.left.right.right = new Node(6);
	       
	       tree.inorderTraversal();
	       
	       /*
	        * the inorder traversal or actual tree and mirror image tree is in reverse order.
	        */
	       System.out.println(" mirror image of binary tree is ");
	       tree.mirrorImageOfBinaryTree();
	       tree.inorderTraversal();
	    }

	private void mirrorImageOfBinaryTree() {
		mirrorImageOfBinaryTree(root);
	}

	private void mirrorImageOfBinaryTree(Node root) {
		if(root != null) {
			if(root.left != null) {
				mirrorImageOfBinaryTree(root.left);
			}
			if(root.right != null) {
				mirrorImageOfBinaryTree(root.right);
			}

			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
	}

	private void inorderTraversal() {
		inorderTraversal(root);
	}

	private void inorderTraversal(Node root) {
		if(root != null) {
			if(root.left != null) {
				inorderTraversal(root.left);
			}
			System.out.print(root.data +" ");
			
			if(root.right != null) {
				inorderTraversal(root.right);
			}
		}
	}
	
}
