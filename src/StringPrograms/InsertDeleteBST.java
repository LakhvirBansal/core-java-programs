package StringPrograms;

public class InsertDeleteBST {

	class Node{
		
		int key;
		
		Node left, right;
		
		public Node(int val){
			key = val;
			left = right = null;
		}
	}
	
	Node root;
	
	InsertDeleteBST(){
		root = null;
	}
	

	private void insert(int val) {
		root = insertNode(root, val);
		
	}
	
	private Node insertNode(Node root, int val) {
		
		if(root == null){
			root = new Node(val);
			return root;
		}
		
		if(val < root.key){
			root.left = insertNode(root.left, val);
		} else{
			root.right = insertNode(root.right, val);
		}
		
		return root;
	}


	private void traverseInorder() {
		traverseInorder(root);
		
	}

	private void traverseInorder(Node root) {
		if(root !=null){
			traverseInorder(root.left);
			System.out.println(root.key);
			traverseInorder(root.right);
		}
	}

	private void delete(int i) {
		root = deleteRec(root, i);
		
	}

	private Node deleteRec(Node root, int val) {
		if(root == null){
			return root;
		} 
		if(val < root.key){
			root.left = deleteRec(root.left, val);
		} else if(val > root.key){
			root.right = deleteRec(root.right, val);
		} else{
			// if only one child
			if(root.left == null){
				return root.right;
			} else if(root.right == null){
				return root.left;
			}
			
			// if 2 childs
			root.key = minVal(root.right);
			root.right = deleteRec(root.right, root.key);
		}
		
	return root;
	}


	private int minVal(Node root) {
		
		int retVal = root.key;
		while(root.left != null){
			retVal = root.left.key;
			root = root.left;
		}
		return retVal;
	}


	public static void main(String[] args) {
		InsertDeleteBST bst = new InsertDeleteBST();
		
		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);
		
		//bst.traverseInorder();
		
		bst.delete(50);
		bst.traverseInorder();
		
	}


	



}
