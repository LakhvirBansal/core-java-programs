package StringPrograms;

class Node1 {
    int data;
    Node1 left, right;
    public Node1(int item)
    {
        data = item;
        left = right = null;
    }
}

public class LevelOrderTreeTraversal {

	Node1 root;
	
	public LevelOrderTreeTraversal()
    {
        root = null;
    }
 
    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }
    
    int height(Node1 root)
    {
        if (root == null)
           return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
             
            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1); 
        }
    }
    
    void printGivenLevel (Node1 root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }
	 public static void main(String args[]) {
		 LevelOrderTreeTraversal tree = new LevelOrderTreeTraversal();
	       tree.root= new Node1(1);
	       tree.root.left= new Node1(2);
	       tree.root.right= new Node1(3);
	       tree.root.left.left= new Node1(4);
	       tree.root.left.right= new Node1(5);
	        
	       System.out.println("Level order traversal of binary tree is ");
	       tree.printLevelOrder();
	    }

}
