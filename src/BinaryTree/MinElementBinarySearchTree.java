package BinaryTree;


public class MinElementBinarySearchTree {
	
	class Node{
		int key;
		Node left, right;
		
		Node(int val){
			key = val;
			left = right = null;
		}
	}
	
	Node root;
	
	MinElementBinarySearchTree(){
		root = null;
	}
	
	void insert(int key) {
	    root = insertRec(root, key);
	}

	private Node insertRec(Node root, int key) {
		
		if(root == null){
			root = new Node(key);
			return root;
		} 
		
		if(root.key > key){
		root.left = insertRec(root.left,key);
		} else{
			root.right = insertRec(root.right, key);
		}
		
		return root;
	}

    private void minElement() {
		int val = findMinElement(root);
		if(val == 0){
			System.out.println("tree is empty");
		} else{
			
			System.out.println("the min value is :"+val);
		}
		
	}
    
	private int findMinElement(Node root) {
		
		if(root == null){
			return 0;
			
		}
		int minElement = root.key;
		while(root.left != null){
			
			minElement = root.left.key;
			root = root.left;
		}

		return minElement;
	}

	public static void main(String[] args) {
        MinElementBinarySearchTree tree = new MinElementBinarySearchTree();
 
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(60);
        tree.insert(70);
        tree.insert(80);
        tree.insert(90);
        tree.insert(100);
        tree.insert(110);

        // print inorder traversal of the BST
      //  tree.inorder();
       // tree.preOrder();
        
        tree.minElement();
    }

	

}
