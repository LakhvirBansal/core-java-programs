package BinaryTree;


public class BinarySearchTree {
	
	class Node{
		int key;
		Node left, right;
		
		Node(int val){
			key = val;
			left = right = null;
		}
	}
	
	Node root;
	
	BinarySearchTree(){
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
	
	  // This method mainly calls InorderRec()
    void inorder()  {
       inorderRec(root);
    }
    
    @SuppressWarnings("unused")
	private void preOrder() {
    	 preOrderRec(root);
		
	}
    private void preOrderRec(Node root) {
    	   if (root != null) {
    		   System.out.println(root.key);
    		   preOrderRec(root.left);
               
    		   preOrderRec(root.right);
           }
	}

	// A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
    
    private void search(int searchVal) {
		search(root, searchVal);
		
	}

    
    private void search(Node root, int searchVal) {
    	
    	if(root == null){
    		System.out.println("element not found");
    	} else if(root.key == searchVal){
    		System.out.println("element found");
    	} else{
    		if(searchVal > root.key){
    			search(root.right, searchVal);
    		} else{
    			search(root.left, searchVal);
    		}
    	}
		
	}

	public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
 
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
 
        // print inorder traversal of the BST
      //  tree.inorder();
       // tree.preOrder();
        
        tree.search(10);
    }

}
