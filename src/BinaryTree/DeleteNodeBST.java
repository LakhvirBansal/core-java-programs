package BinaryTree;

public class DeleteNodeBST {

     // Root of BST
    Node root;
 
    // Constructor
    DeleteNodeBST()
    {
        root = null;
    }
 
    // This method mainly calls deleteRec()
    void deleteKey(int key)
    {
        root = deleteRec(root, key);
    }
 
    /* A recursive function to insert a new key in BST */
    Node deleteRec(Node root, int key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)  return root;
 
        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.left = deleteRec(root.left, key);
        else if (key > root.data)
            root.right = deleteRec(root.right, key);
 
        // if key is same as root's key, then This is the node
        // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.data = minValue(root.right);
 
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }
 
        return root;
    }
 
    int minValue(Node root)
    {
        int minv = root.data;
        while (root.left != null)
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }
 
    // This method mainly calls insertRec()
    void insert(int key)
    {
        root = insertRec(root, key);
    }
 
    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key)
    {
 
        /* If the tree is empty, return a new node */
        if (root == null)
        {
            root = new Node(key);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);
 
        /* return the (unchanged) node pointer */
        return root;
    }
 
    // This method mainly calls InorderRec()
    void inorder()
    {
        inorderRec(root);
    }
 
    // A utility function to do inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null)
        {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
 
    // Driver Program to test above functions
    public static void main(String[] args)
    {
    	DeleteNodeBST tree = new DeleteNodeBST();
 
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
 
        System.out.println("Inorder traversal of the given tree");
        //tree.inorder();
 
        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println("Inorder traversal of the modified tree");
        //tree.inorder();
 
        System.out.println("\nDelete 30");
        tree.deleteKey(30);
        System.out.println("Inorder traversal of the modified tree");
       // tree.inorder();
 
        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        System.out.println("Inorder traversal of the modified tree");
       // tree.inorder();
    }
}
